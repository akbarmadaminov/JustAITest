package com.example.controller;

import com.example.model.VkRequest;
import com.example.service.BotService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/callback")
@Log4j2
public class BotController {

    public static final String CONFIRM_CODE = "221639a7";

    @Autowired
    private BotService botService;

    @PostMapping
    public String postMessage(@RequestBody VkRequest request) {
        log.info("Received POST request with body: {}", request);
        if ("confirmation".equals(request.getType())) {
            return CONFIRM_CODE;
        }
        botService.sendMessage(request);
        return "ok";
    }
}