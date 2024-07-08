package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VkObject {
    @JsonProperty("message")
    private VkMessage message;

    // Getters and setters
}
