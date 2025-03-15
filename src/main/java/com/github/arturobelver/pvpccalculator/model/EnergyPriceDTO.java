package com.github.arturobelver.pvpccalculator.model;

import java.time.LocalDateTime;

public class EnergyPriceDTO {
    private LocalDateTime datetime;
    private double price;

    // Getters y Setters
    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "EnergyPriceDTO{" +
                "datetime=" + datetime +
                ", price=" + price +
                '}';
    }
}