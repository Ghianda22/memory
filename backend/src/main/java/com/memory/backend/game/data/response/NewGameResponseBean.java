package com.memory.backend.game.data.response;

import java.util.UUID;

public final class NewGameResponseBean {
    private final UUID id;
    private final String message;

    NewGameResponseBean(UUID id, String message) {
        this.id = id;
        this.message = message;
    }

    public UUID getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
