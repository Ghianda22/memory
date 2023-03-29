package com.memory.backend.game.data.persistence;

import com.memory.backend.game.data.enums.GameBgImage;
import com.memory.backend.game.data.enums.GameDifficulty;
import com.memory.backend.game.data.enums.GameStatus;

public class GameEntityBuilder {
    private GameStatus status;
    private String name;
    private GameBgImage bgImage;
    private GameDifficulty difficulty;
    private Integer maxNumberOfPlayers;
    private Boolean isPublic;

    public GameEntityBuilder setStatus(GameStatus status) {
        this.status = status;
        return this;
    }

    public GameEntityBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public GameEntityBuilder setBgImage(GameBgImage bgImage) {
        this.bgImage = bgImage;
        return this;
    }

    public GameEntityBuilder setDifficulty(GameDifficulty difficulty) {
        this.difficulty = difficulty;
        return this;
    }

    public GameEntityBuilder setMaxNumberOfPlayers(Integer maxNumberOfPlayers) {
        this.maxNumberOfPlayers = maxNumberOfPlayers;
        return this;
    }

    public GameEntityBuilder setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
        return this;
    }

    public GameEntity createGame() {
        return new GameEntity(status, name, bgImage, difficulty, maxNumberOfPlayers, isPublic);
    }
}