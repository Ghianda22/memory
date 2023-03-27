package com.memory.backend.game.data;

public class GameRequestBeanBuilder {
    private String name;
    private String bgImage;
    private String difficulty;
    private Integer maxNumberOfPlayers;
    private Boolean isPublic;

    public GameRequestBeanBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public GameRequestBeanBuilder setBgImage(String bgImage) {
        this.bgImage = bgImage;
        return this;
    }

    public GameRequestBeanBuilder setDifficulty(String difficulty) {
        this.difficulty = difficulty;
        return this;
    }

    public GameRequestBeanBuilder setMaxNumberOfPlayers(Integer maxNumberOfPlayers) {
        this.maxNumberOfPlayers = maxNumberOfPlayers;
        return this;
    }

    public GameRequestBeanBuilder setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
        return this;
    }

    public GameRequestBean createGame() {
        return new GameRequestBean(name, bgImage, difficulty, maxNumberOfPlayers, isPublic);
    }
}