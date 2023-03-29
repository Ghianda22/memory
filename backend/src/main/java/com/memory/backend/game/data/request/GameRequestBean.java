package com.memory.backend.game.data.request;

public final class GameRequestBean {
    private String name;
    private String bgImage;
    private String difficulty;
    private Integer maxNumberOfPlayers;
    private Boolean isPublic;


    public GameRequestBean() {}
    public GameRequestBean(String name, String bgImage, String difficulty, Integer maxNumberOfPlayers, Boolean isPublic) {
        this.name = name;
        this.bgImage = bgImage;
        this.difficulty = difficulty;
        this.maxNumberOfPlayers = maxNumberOfPlayers;
        this.isPublic = isPublic;
    }

    public String getName() {
        return name;
    }

    public String getBgImage() {
        return bgImage;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public Integer getMaxNumberOfPlayers() {
        return maxNumberOfPlayers;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }
}
