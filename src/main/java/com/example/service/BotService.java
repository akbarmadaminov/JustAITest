package com.example.service;

import com.example.model.VkRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class VkBotService {

    @Value("${vk.api.token}")
    private String vkApiToken;

    @Value("${vk.api.version}")
    private String vkApiVersion;

    private static final String VK_API_URL = "https://api.vk.com/method/messages.send";

    public void sendMessage(VkRequest request) {
        if ("message_new".equals(request.getType())) {
            int peerId = request.getObject().getMessage().getPeerId();
            String text = request.getObject().getMessage().getText();

            Map<String, String> params = new HashMap<>();
            params.put("peer_id", String.valueOf(peerId));
            params.put("message", text);
            params.put("access_token", vkApiToken);
            params.put("v", vkApiVersion);

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForObject(VK_API_URL, null, String.class, params);
        }
    }
}
