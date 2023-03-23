package com.memory.backend.game.data;

import com.memory.backend.game.data.enums.GameBgImage;
import com.memory.backend.game.data.enums.GameDifficulty;
import com.memory.backend.game.data.enums.GameStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class GameEntity {
    @Id
    private String gameId;
    private GameStatus gameStatus;
    private String gameName;
    private GameBgImage gameBgImage;
    private GameDifficulty gameDifficulty;
    private Integer maxNumberOfPlayers;
    private Boolean isGamePublic;

    public GameEntity() {}

    public GameEntity(String gameId, GameStatus gameStatus, String gameName, GameBgImage gameBgImage, GameDifficulty gameDifficulty, Integer maxNumberOfPlayers, Boolean isGamePublic) {
        this.gameId = gameId;
        this.gameStatus = gameStatus;
        this.gameName = gameName;
        this.gameBgImage = gameBgImage;
        this.gameDifficulty = gameDifficulty;
        this.maxNumberOfPlayers = maxNumberOfPlayers;
        this.isGamePublic = isGamePublic;
    }

    public String getGameId() {
        return gameId;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
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

    public Integer getMaxNumberOfPlayers() {
        return maxNumberOfPlayers;
    }

//    had to modify the name to make hibernate recognize this as a getter
    public Boolean getIsGamePublic() {
        return isGamePublic;
    }
}
