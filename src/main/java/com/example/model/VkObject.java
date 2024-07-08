package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VkObject {

    @JsonProperty("message")
    private VkMessage message;
}
