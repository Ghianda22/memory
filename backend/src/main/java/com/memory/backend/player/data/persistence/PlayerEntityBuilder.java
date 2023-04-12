package com.memory.backend.player.data.persistence;

import com.memory.backend.Icons;

import java.util.UUID;

public class PlayerEntityBuilder {
    private UUID gameId;
    private Icons avatar = Icons.getRandomIcon();
    private Integer score = 0;
    private Boolean isInGame = true; //is false only if the player quit
    private Boolean isTurnPlayer;
    private Boolean isAdmin = false;

    public PlayerEntityBuilder setGameId(UUID gameId) {
        this.gameId = gameId;
        return this;
    }

    public PlayerEntityBuilder setAvatar(Icons avatar) {
        this.avatar = avatar;
        return this;
    }

    public PlayerEntityBuilder setScore(Integer score) {
        this.score = score;
        return this;
    }

    public PlayerEntityBuilder setIsInGame(Boolean isInGame) {
        this.isInGame = isInGame;
        return this;
    }

    public PlayerEntityBuilder setIsTurnPlayer(Boolean isTurnPlayer) {
        this.isTurnPlayer = isTurnPlayer;
        return this;
    }

    public PlayerEntityBuilder setIsAdmin(Boolean admin) {
        isAdmin = admin;
        return this;
    }

    public PlayerEntity createPlayerEntity() {
        return new PlayerEntity(gameId, avatar, score, isInGame, isTurnPlayer, isAdmin);
    }
}