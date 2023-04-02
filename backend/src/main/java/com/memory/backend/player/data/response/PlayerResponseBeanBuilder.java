package com.memory.backend.player.data.response;

import org.springframework.http.HttpStatus;

import java.util.UUID;

public class PlayerResponseBeanBuilder {
    private UUID id;
    private String message;

    public PlayerResponseBeanBuilder setId(UUID id) {
        this.id = id;
        return this;
    }

    public PlayerResponseBeanBuilder setMessage(String message) {
        this.message = message;
        return this;
    }


    public PlayerResponseBean createPlayerResponseBean() {
        return new PlayerResponseBean(id, message);
    }
}