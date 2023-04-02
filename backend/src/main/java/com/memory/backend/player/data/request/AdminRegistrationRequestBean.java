package com.memory.backend.player.data.request;

import com.memory.backend.Icons;

import java.util.UUID;

public final class AdminRegistrationRequestBean {
    private final UUID gameId;
    private final Icons avatar;

    AdminRegistrationRequestBean(UUID gameId, Icons avatar) {
        this.gameId = gameId;
        this.avatar = avatar;
    }

    public UUID getGameId() {
        return gameId;
    }

    public Icons getAvatar() {
        return avatar;
    }
}
