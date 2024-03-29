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
    private Boolean isAdmin;

    public PlayerEntity() {
    }

    PlayerEntity(UUID gameId, Icons avatar, Integer score, Boolean isInGame, Boolean isTurnPlayer, Boolean isAdmin) {
        this.gameId = gameId;
        this.avatar = avatar;
        this.score = score;
        this.isInGame = isInGame;
        this.isTurnPlayer = isTurnPlayer;
        this.isAdmin = isAdmin;
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
    public Boolean getIsAdmin() {
        return isAdmin;
    }

    private void setGameId(UUID gameId) {
        this.gameId = gameId;
    }
    private void setAvatar(Icons avatar) {
        this.avatar = avatar;
    }
    public void setScore(Integer score) {
        this.score = score;
    }
    public void setInGame(Boolean inGame) {
        isInGame = inGame;
    }
    public void setTurnPlayer(Boolean turnPlayer) {
        isTurnPlayer = turnPlayer;
    }
    private void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}
