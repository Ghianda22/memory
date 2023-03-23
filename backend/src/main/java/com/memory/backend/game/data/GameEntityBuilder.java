package com.memory.backend.game.data;

import com.memory.backend.game.data.enums.GameBgImage;
import com.memory.backend.game.data.enums.GameDifficulty;
import com.memory.backend.game.data.enums.GameStatus;

public class GameEntityBuilder {
    private String gameId;
    private GameStatus gameStatus;
    private String gameName;
    private GameBgImage gameBgImage;
    private GameDifficulty gameDifficulty;
    private Integer maxNumberOfPlayers;
    private Boolean isGamePublic;

    public GameEntityBuilder setGameId(String gameId) {
        this.gameId = gameId;
        return this;
    }

    public GameEntityBuilder setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
        return this;
    }

    public GameEntityBuilder setGameName(String gameName) {
        this.gameName = gameName;
        return this;
    }

    public GameEntityBuilder setGameBgImage(GameBgImage gameBgImage) {
        this.gameBgImage = gameBgImage;
        return this;
    }

    public GameEntityBuilder setGameDifficulty(GameDifficulty gameDifficulty) {
        this.gameDifficulty = gameDifficulty;
        return this;
    }

    public GameEntityBuilder setMaxNumberOfPlayers(Integer maxNumberOfPlayers) {
        this.maxNumberOfPlayers = maxNumberOfPlayers;
        return this;
    }

    public GameEntityBuilder setIsGamePublic(Boolean isGamePublic) {
        this.isGamePublic = isGamePublic;
        return this;
    }

    public GameEntity createGame() {
        return new GameEntity(gameId, gameStatus, gameName, gameBgImage, gameDifficulty, maxNumberOfPlayers, isGamePublic);
    }
}