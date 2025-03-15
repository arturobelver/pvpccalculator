package com.github.arturobelver.pvpccalculator.service;

import com.github.arturobelver.pvpccalculator.model.EnergyPriceDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class EnergyPriceServiceTest {

    @Autowired
    private EnergyPriceService energyPriceService;

    @Test
    public void testGetPricesBetweenDates() {
        LocalDate startDate = LocalDate.of(2025, 2, 9);
        LocalDate endDate = LocalDate.of(2025, 2, 10);

        List<EnergyPriceDTO> prices = energyPriceService.getPricesBetweenDates(startDate, endDate);

        assertNotNull(prices);
        assertFalse(prices.isEmpty());

        // Imprimir los precios para verificar
        prices.forEach(System.out::println);
    }
}