package com.alura.cursos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsutaApi {



    String consultaMoneda (String monedaAConsultar){

        String jsonRespuesta;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/7c504782dd2702001d4ff440/latest/"
                + monedaAConsultar))
                .build();


        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            jsonRespuesta = response.body();

        } catch (IOException | InterruptedException e) {

            System.out.println("Ocurrio un error inesperado");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return jsonRespuesta;
    }

    float conversionDeMondeda( double valorDeMoneda, float dineroACambiar ){
        return (float) valorDeMoneda * dineroACambiar;
    }

}
