package com.borges.bankaccount.service;

import com.borges.bankaccount.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class NotificationService {

    private final RestTemplate restTemplate;

    private static final String NOTIFICATION_URL = "https://run.mocky.io/v3/e4520707-3550-4022-9d34-88c3b38e0b28";

    public NotificationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void notifyMessage(Customer customer, String message) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("cliente", customer.getName());
        payload.put("documento", customer.getDocument());
        payload.put("mensagem", message);


        try {
            ResponseEntity<String> response = restTemplate.postForEntity(NOTIFICATION_URL, payload, String.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                System.out.println("✅ Notificação enviada com sucesso para: " + customer.getName());
            } else {
                System.err.println("❌ Notificação falhou para: " + customer.getName() +
                        " | Status: " + response.getStatusCode());
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao enviar notificação: " + customer.getName() + ":" + e.getMessage());
        }
    }
}
