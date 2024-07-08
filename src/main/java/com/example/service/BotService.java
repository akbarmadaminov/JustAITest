package com.example.service;

import com.example.model.VkRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

import static com.example.constants.Constants.*;

@Service
public class BotService {

    public void sendMessage(VkRequest vkRequest) {
        int peerId = vkRequest.getObject().getMessage().getPeerId();
        String text = vkRequest.getObject().getMessage().getText();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", "Bearer " + VK_ACCESS_TOKEN);

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(VK_API_URL)
                .queryParam("random_id", "{random_id}")
                .queryParam("peer_id", "{peer_id}")
                .queryParam("message", "{message}")
                .queryParam("v", "{v}")
                .queryParam("access_token", "{access_token}")
                .encode()
                .toUriString();

        Map<String, String> params = Map.of(
                "random_id", "0",
                "peer_id", String.valueOf(peerId),
                "message", "Вы сказали: " + text,
                "v", "5.199",
                "access_token", VK_ACCESS_TOKEN
        );

        HttpEntity<Void> request = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, request, String.class, params);
        System.out.println("Response from VK API: " + response.getBody());
    }
}
