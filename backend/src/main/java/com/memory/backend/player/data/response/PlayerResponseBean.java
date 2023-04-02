package com.memory.backend.player.data.response;

import java.util.UUID;

public final class PlayerResponseBean {
    private final UUID id;
    private final String message;

    PlayerResponseBean(UUID id, String message) {
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
