package com.example.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import lombok.extern.log4j.Log4j2;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Component
@Log4j2
public class VkClient {

    @Value("${vkAccessToken}")
    private String vkAccessToken;

    @Value("${vkApiUrl}")
    private String vkApiUrl;

    @Autowired
    private RestTemplate restTemplate;

    public void sendMessage(int peerId, String message) {
        int randomId = ThreadLocalRandom.current().nextInt();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(vkApiUrl)
                .queryParam("random_id", "{random_id}")
                .queryParam("peer_id", "{peer_id}")
                .queryParam("message", "{message}")
                .queryParam("v", "{v}")
                .queryParam("access_token", "{access_token}")
                .encode()
                .toUriString();

        Map<String, String> params = Map.of(
                "random_id", String.valueOf(randomId),
                "peer_id", String.valueOf(peerId),
                "message", message,
                "v", "5.199",
                "access_token", vkAccessToken
        );

        log.info("Sending message to VK. URL: {}, Params: {}", urlTemplate, params);
        HttpEntity<Void> request = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.POST, request, String.class, params);
            log.info("Response from VK API: {}", response.getBody());
        } catch (Exception e) {
            log.error("Error while sending message to VK API", e);
            // Retry logic or further error handling can be implemented here
        }
    }
}