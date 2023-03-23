package com.memory.backend.game.data;

import com.fasterxml.jackson.annotation.JsonAlias;

public class GameRequestBean {
    private String gameName;
    private String gameBgImage;
    private String gameDifficulty;
    private Integer maxNumberOfPlayers;
    private Boolean isGamePublic;


    public GameRequestBean() {}
    public GameRequestBean(String gameName, String gameBgImage, String gameDifficulty, Integer maxNumberOfPlayers, Boolean isGamePublic) {
        this.gameName = gameName;
        this.gameBgImage = gameBgImage;
        this.gameDifficulty = gameDifficulty;
        this.maxNumberOfPlayers = maxNumberOfPlayers;
        this.isGamePublic = isGamePublic;
    }

    public String getGameName() {
        return gameName;
    }

    public String getGameBgImage() {
        return gameBgImage;
    }

    public String getGameDifficulty() {
        return gameDifficulty;
    }

    public Integer getMaxNumberOfPlayers() {
        return maxNumberOfPlayers;
    }

    public Boolean getIsGamePublic() {
        return isGamePublic;
    }
}
