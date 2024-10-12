package com.converter.service;

import com.converter.api.ExchangeRateAPI;

public class CurrencyConverter {
    private ExchangeRateAPI api;

    public CurrencyConverter() {
        this.api = new ExchangeRateAPI();
    }

    public void convert(String fromCurrency, String toCurrency, double amount) {
        double exchangeRate = api.getExchangeRate(fromCurrency, toCurrency);
        if (exchangeRate != -1) {
            double result = amount * exchangeRate;
            System.out.printf("%.2f %s = %.2f %s\n", amount, fromCurrency, result, toCurrency);
        } else {
            System.out.println("Error obteniendo la tasa de cambio.");
        }
    }
}

