package com.vesa.wazeapi.services;

import com.vesa.wazeapi.HeaderRequestInterceptor;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

@Service
public class AndroidPushNotificationsService {

    private static final String FIREBASE_SERVER_KEY = "AAAAQhYp1aI:APA91bFp1HxVmz3LzmC2a5kEPZcjv-YtXuUOSJpzSVrbfB8bMVl6nfF0PcftUUoAHsTQciOMI-1VMmigQUynHbeefTLHW1xlhlELlwjL893OARA6aGHnVQGmBu2ciTBXsIygkBNXRhTh";
    private static final String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send";

    @Async
    public CompletableFuture<String> send(HttpEntity<String> entity) {

        RestTemplate restTemplate = new RestTemplate();


        ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new HeaderRequestInterceptor("Authorization", "key=" + FIREBASE_SERVER_KEY));
        interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json"));
        restTemplate.setInterceptors(interceptors);

        String firebaseResponse = restTemplate.postForObject(FIREBASE_API_URL, entity, String.class);

        return CompletableFuture.completedFuture(firebaseResponse);
    }
}
