package com.memory.backend.player.data.request;

import com.memory.backend.Icons;

import java.util.UUID;

public class AdminRegistrationRequestBeanBuilder {
    private UUID gameId;
    private Icons avatar;

    public AdminRegistrationRequestBeanBuilder setGameId(UUID gameId) {
        this.gameId = gameId;
        return this;
    }

    public AdminRegistrationRequestBeanBuilder setAvatar(Icons avatar) {
        this.avatar = avatar;
        return this;
    }

    public AdminRegistrationRequestBean createAdminRegistrationRequestBean() {
        return new AdminRegistrationRequestBean(gameId, avatar);
    }
}