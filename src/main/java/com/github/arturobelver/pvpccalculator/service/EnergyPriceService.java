package com.github.arturobelver.pvpccalculator.service;

import com.github.arturobelver.pvpccalculator.exception.EnergyPriceException;
import com.github.arturobelver.pvpccalculator.model.EnergyPriceDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Service
public class EnergyPriceService {

    @Value("${esios.api.token}")
    private String apiToken;

    private final RestTemplate restTemplate = new RestTemplate();

    public List<EnergyPriceDTO> getPricesBetweenDates(LocalDate startDate, LocalDate endDate) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Token token=" + apiToken);

            String url = "https://api.esios.ree.es/archives/70/download_json?start_date=" +
                    startDate.format(DateTimeFormatter.ISO_LOCAL_DATE) +
                    "&end_date=" +
                    endDate.format(DateTimeFormatter.ISO_LOCAL_DATE);

            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<EnergyPriceDTO[]> response = restTemplate.exchange(
                    url, HttpMethod.GET, entity, EnergyPriceDTO[].class);

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                return Arrays.asList(response.getBody());
            } else {
                throw new EnergyPriceException("Error al obtener los precios de energía: " + response.getStatusCode());
            }
        } catch (Exception e) {
            throw new EnergyPriceException("Error en la solicitud a la API de ESIOS", e);
        }
    }
}