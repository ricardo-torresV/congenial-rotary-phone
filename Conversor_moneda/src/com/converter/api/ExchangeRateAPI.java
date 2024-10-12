package com.converter.api;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class ExchangeRateAPI {
    private static final String API_KEY = "87ad82639662bfa1b86c28ac";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";

    public double getExchangeRate(String fromCurrency, String toCurrency) {
        try {
            String urlStr = API_URL + API_KEY + "/pair/" + fromCurrency + "/" + toCurrency;
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                Scanner sc = new Scanner(url.openStream());
                StringBuilder inline = new StringBuilder();
                while (sc.hasNext()) {
                    inline.append(sc.nextLine());
                }
                sc.close();

                JSONObject jsonResponse = new JSONObject(inline.toString());
                return jsonResponse.getDouble("conversion_rate");
            } else {
                System.out.println("Error en la conexión: Código de respuesta " + responseCode);
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
