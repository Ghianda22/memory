package com.memory.backend.game.data;

import com.memory.backend.game.data.enums.GameBgImage;
import com.memory.backend.game.data.enums.GameDifficulty;

public class GameBuilder {
    private String gameName;
    private GameBgImage gameBgImage;
    private GameDifficulty gameDifficulty;
    private int maxNumberOfPlayers;
    private boolean isGamePublic;

    public GameBuilder setGameName(String gameName) {
        this.gameName = gameName;
        return this;
    }

    public GameBuilder setGameBgImage(GameBgImage gameBgImage) {
        this.gameBgImage = gameBgImage;
        return this;
    }

    public GameBuilder setGameDifficulty(GameDifficulty gameDifficulty) {
        this.gameDifficulty = gameDifficulty;
        return this;
    }

    public GameBuilder setMaxNumberOfPlayers(int maxNumberOfPlayers) {
        this.maxNumberOfPlayers = maxNumberOfPlayers;
        return this;
    }

    public GameBuilder setIsGamePublic(boolean isGamePublic) {
        this.isGamePublic = isGamePublic;
        return this;
    }

    public Game createGame() {
        return new Game(gameName, gameBgImage, gameDifficulty, maxNumberOfPlayers, isGamePublic);
    }
}