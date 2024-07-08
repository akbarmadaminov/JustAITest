package com.example.controller;

import com.example.model.VkRequest;
import com.example.service.BotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/callback")
public class BotController {

    @Autowired
    private BotService botService;

    @PostMapping
    public String postMessage(@RequestBody VkRequest request) {
        System.out.println("Received POST request with body: " + request);
        botService.sendMessage(request);
        return "ok";
    }
}
