package com.memory.backend.game.data;

import java.util.List;

public final class GameResponseBean {
    private final List<GameEntity> activeGames;

    public GameResponseBean(List<GameEntity> activeGames) {
        this.activeGames = activeGames;
    }

    public List<GameEntity> getActiveGames() {
        return activeGames;
    }
}
