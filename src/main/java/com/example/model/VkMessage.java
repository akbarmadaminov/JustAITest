package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class VkMessage {

    @JsonProperty("date")
    private long date;

    @JsonProperty("from_id")
    private int fromId;

    @JsonProperty("id")
    private int id;

    @JsonProperty("out")
    private int out;

    @JsonProperty("version")
    private int version;

    @JsonProperty("attachments")
    private List<Object> attachments;

    @JsonProperty("conversation_message_id")
    private int conversationMessageId;

    @JsonProperty("fwd_messages")
    private List<Object> fwdMessages;

    @JsonProperty("important")
    private boolean important;

    @JsonProperty("is_hidden")
    private boolean isHidden;

    @JsonProperty("peer_id")
    private int peerId;

    @JsonProperty("random_id")
    private int randomId;

    @JsonProperty("text")
    private String text;

    @JsonProperty("is_unavailable")
    private boolean isUnavailable;
}
