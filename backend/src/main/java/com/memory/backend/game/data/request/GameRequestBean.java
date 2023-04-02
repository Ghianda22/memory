package com.memory.backend.game.data.request;

import com.memory.backend.game.data.enums.GameBgImage;
import com.memory.backend.game.data.enums.GameDifficulty;

public final class GameRequestBean {
    private String name;
    private GameBgImage bgImage;
    private GameDifficulty difficulty;
    private Integer maxNumberOfPlayers;
    private Boolean isPublic;


    public GameRequestBean() {}
    public GameRequestBean(String name, GameBgImage bgImage, GameDifficulty difficulty, Integer maxNumberOfPlayers, Boolean isPublic) {
        this.name = name;
        this.bgImage = bgImage;
        this.difficulty = difficulty;
        this.maxNumberOfPlayers = maxNumberOfPlayers;
        this.isPublic = isPublic;
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

    public Boolean getIsPublic() {
        return isPublic;
    }
}
