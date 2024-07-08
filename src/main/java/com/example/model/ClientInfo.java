package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ClientInfo {

    @JsonProperty("button_actions")
    private List<String> buttonActions;

    @JsonProperty("keyboard")
    private boolean keyboard;

    @JsonProperty("inline_keyboard")
    private boolean inlineKeyboard;

    @JsonProperty("carousel")
    private boolean carousel;

    @JsonProperty("lang_id")
    private int langId;
}
