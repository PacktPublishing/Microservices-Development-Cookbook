package com.packtpub.microservices.ch05.retryclient;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.util.ExponentialBackOff;

import java.io.IOException;

public class Main {

    static final HttpTransport transport = new NetHttpTransport();

    public static void main(String[] args) {
        HttpRequestFactory factory = transport.createRequestFactory();
        GenericUrl url = new GenericUrl("http://localhost:4567/");

        try {
            HttpRequest request = factory.buildGetRequest(url);
            ExponentialBackOff backoff = new ExponentialBackOff.Builder()
                    .setInitialIntervalMillis(500)
                    .setMaxElapsedTimeMillis(10000)
                    .setMaxIntervalMillis(6000)
                    .setMultiplier(1.5)
                    .setRandomizationFactor(0.5)
                    .build();

            request.setUnsuccessfulResponseHandler(
                    new HttpBackOffUnsuccessfulResponseHandler(backoff));
            HttpResponse response = request.execute();
            System.out.println("Got a successful response: " + response.getStatusCode());
        } catch (HttpResponseException e) {
            System.out.println("Got an unsuccessful response: " + e.getStatusCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}