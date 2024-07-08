package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VkRequest {
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
}
