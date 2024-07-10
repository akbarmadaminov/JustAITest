package com.example.service;

import com.example.component.VkClient;
import com.example.model.VkRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class BotService {

    @Autowired
    private VkClient vkClient;

    public void sendMessage(VkRequest vkRequest) {
        int peerId = vkRequest.getObject().getMessage().getPeerId();
        String text = "Вы сказали: " + vkRequest.getObject().getMessage().getText();
        log.info("Preparing to send message to peerId: {}, text: {}", peerId, text);
        vkClient.sendMessage(peerId, text);
    }
}
