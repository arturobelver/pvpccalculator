package com.github.arturobelver.pvpccalculator.exception;

public class EnergyPriceException extends RuntimeException {
    public EnergyPriceException(String message) {
        super(message);
    }

    public EnergyPriceException(String message, Throwable cause) {
        super(message, cause);
    }
}

