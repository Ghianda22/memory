package com.memory.backend.player.data.persistence;

import com.memory.backend.BaseEntity;
import com.memory.backend.Icons;
import jakarta.persistence.Entity;

import java.util.UUID;

@Entity
public class PlayerEntity extends BaseEntity {
    private UUID gameId;
    private Icons avatar;
    private Integer score;
    private Boolean isInGame;
    private Boolean isTurnPlayer;

    public PlayerEntity() {
    }

    PlayerEntity(UUID gameId, Icons avatar, Integer score, Boolean isInGame, Boolean isTurnPlayer) {
        this.gameId = gameId;
        this.avatar = avatar;
        this.score = score;
        this.isInGame = isInGame;
        this.isTurnPlayer = isTurnPlayer;
    }

    public UUID getGameId() {
        return gameId;
    }

    public Icons getAvatar() {
        return avatar;
    }

    public Integer getScore() {
        return score;
    }

    public Boolean getIsInGame() {
        return isInGame;
    }

    public Boolean getIsTurnPlayer() {
        return isTurnPlayer;
    }

    private void setGameId(UUID gameId) {
        this.gameId = gameId;
    }
    private void setAvatar(Icons avatar) {
        this.avatar = avatar;
    }
    private void setScore(Integer score) {
        this.score = score;
    }
    private void setInGame(Boolean inGame) {
        isInGame = inGame;
    }
    private void setTurnPlayer(Boolean turnPlayer) {
        isTurnPlayer = turnPlayer;
    }
}
