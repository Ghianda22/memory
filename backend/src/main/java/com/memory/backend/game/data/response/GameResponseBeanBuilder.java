package com.memory.backend.game.data.response;

import com.memory.backend.game.data.persistence.GameEntity;

import java.util.List;

public class GameResponseBeanBuilder {
    private List<GameEntity> activeGames;

    public GameResponseBeanBuilder setActiveGames(List<GameEntity> activeGames) {
        this.activeGames = activeGames;
        return this;
    }

    public GameResponseBean createGameResponseBean() {
        return new GameResponseBean(activeGames);
    }
}