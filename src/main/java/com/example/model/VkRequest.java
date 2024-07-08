package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageBody {
    @JsonProperty("group_id")
    private int groupId;

    @JsonProperty("type")
    private String type;

    @JsonProperty("event_id")
    private String eventId;

    @JsonProperty("v")
    private String version;

    @JsonProperty("object")
    private VkObject object;

    @JsonProperty("client_info")
    private ClientInfo clientInfo;

    // Getters and setters
}
