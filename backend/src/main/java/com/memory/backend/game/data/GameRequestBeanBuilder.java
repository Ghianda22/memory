package com.memory.backend.game.data;

import com.memory.backend.game.data.enums.GameBgImage;
import com.memory.backend.game.data.enums.GameDifficulty;

public class GameRequestBeanBuilder {
    private String gameName;
    private String gameBgImage;
    private String gameDifficulty;
    private Integer maxNumberOfPlayers;
    private Boolean isGamePublic;

    public GameRequestBeanBuilder setGameName(String gameName) {
        this.gameName = gameName;
        return this;
    }

    public GameRequestBeanBuilder setGameBgImage(String gameBgImage) {
        this.gameBgImage = gameBgImage;
        return this;
    }

    public GameRequestBeanBuilder setGameDifficulty(String gameDifficulty) {
        this.gameDifficulty = gameDifficulty;
        return this;
    }

    public GameRequestBeanBuilder setMaxNumberOfPlayers(Integer maxNumberOfPlayers) {
        this.maxNumberOfPlayers = maxNumberOfPlayers;
        return this;
    }

    public GameRequestBeanBuilder setIsGamePublic(Boolean isGamePublic) {
        this.isGamePublic = isGamePublic;
        return this;
    }

    public GameRequestBean createGame() {
        return new GameRequestBean(gameName, gameBgImage, gameDifficulty, maxNumberOfPlayers, isGamePublic);
    }
}