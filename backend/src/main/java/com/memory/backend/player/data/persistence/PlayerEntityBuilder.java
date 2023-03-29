package com.memory.backend.player.data.persistence;

import com.memory.backend.Icons;

import java.util.UUID;

public class PlayerEntityBuilder {
    private UUID gameId;
    private Icons avatar;
    private Integer score;
    private Boolean isInGame;
    private Boolean isTurnPlayer;

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

    public PlayerEntity createPlayerEntity() {
        return new PlayerEntity(gameId, avatar, score, isInGame, isTurnPlayer);
    }
}