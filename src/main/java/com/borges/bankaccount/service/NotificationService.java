package com.borges.bankaccount.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    private final RestTemplate restTemplate;

    private static final String NOTIFICATION_URL = "https://run.mocky.io/v3/e4520707-3550-4022-9d34-88c3b38e0b28";

    public NotificationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void notifyMessage() {
        try {
            restTemplate.postForEntity(NOTIFICATION_URL, null, String.class);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao enviar notificação externa");
        }
    }
}
