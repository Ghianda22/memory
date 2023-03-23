package com.memory.backend.game.data;

import com.memory.backend.game.data.enums.GameBgImage;
import com.memory.backend.game.data.enums.GameDifficulty;

public class Game {
    private String gameName;
    private GameBgImage gameBgImage;
    private GameDifficulty gameDifficulty;
    private int maxNumberOfPlayers;
    private boolean isGamePublic;

    public Game(String gameName, GameBgImage gameBgImage, GameDifficulty gameDifficulty, int maxNumberOfPlayers, boolean isGamePublic) {
        this.gameName = gameName;
        this.gameBgImage = gameBgImage;
        this.gameDifficulty = gameDifficulty;
        this.maxNumberOfPlayers = maxNumberOfPlayers;
        this.isGamePublic = isGamePublic;
    }

    public String getGameName() {
        return gameName;
    }

    public GameBgImage getGameBgImage() {
        return gameBgImage;
    }

    public GameDifficulty getGameDifficulty() {
        return gameDifficulty;
    }

    public int getMaxNumberOfPlayers() {
        return maxNumberOfPlayers;
    }

    public boolean isGamePublic() {
        return isGamePublic;
    }
}
