package com.memory.backend.game.data.persistence;

import com.memory.backend.BaseEntity;
import com.memory.backend.game.data.enums.GameBgImage;
import com.memory.backend.game.data.enums.GameDifficulty;
import com.memory.backend.game.data.enums.GameStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Game")
public class GameEntity extends BaseEntity {

    private GameStatus status;
    private String name;
    private GameBgImage bgImage;
    private GameDifficulty difficulty;
    private Integer maxNumberOfPlayers;
    private Boolean isPublic;

    public GameEntity() {}

    public GameEntity(GameStatus status, String name, GameBgImage bgImage, GameDifficulty difficulty, Integer maxNumberOfPlayers, Boolean isPublic) {
        this.status = status;
        this.name = name;
        this.bgImage = bgImage;
        this.difficulty = difficulty;
        this.maxNumberOfPlayers = maxNumberOfPlayers;
        this.isPublic = isPublic;
    }

    public GameStatus getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public GameBgImage getBgImage() {
        return bgImage;
    }

    public GameDifficulty getDifficulty() {
        return difficulty;
    }

    public Integer getMaxNumberOfPlayers() {
        return maxNumberOfPlayers;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setBgImage(GameBgImage bgImage) {
        this.bgImage = bgImage;
    }

    private void setDifficulty(GameDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    private void setMaxNumberOfPlayers(Integer maxNumberOfPlayers) {
        this.maxNumberOfPlayers = maxNumberOfPlayers;
    }

    private void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }
}
