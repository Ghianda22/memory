package com.memory.backend.game.data.response;

import java.util.UUID;

public class NewGameResponseBeanBuilder {
    private UUID id;
    private String message;

    public NewGameResponseBeanBuilder setId(UUID id) {
        this.id = id;
        return this;
    }

    public NewGameResponseBeanBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    public NewGameResponseBean createNewGameResponseBean() {
        return new NewGameResponseBean(id, message);
    }
}