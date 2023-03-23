package com.memory.backend.game.data.enums;

public enum GameDifficulty {

    EASY("8 (easy)"),
    MEDIUM("16 (medium)"),
    HARD("24 (hard)");

    public static GameDifficulty fromValue(String stringGameDifficulty){
        for(GameDifficulty gameDifficulty : GameDifficulty.values()) {
            if (gameDifficulty.getDifficulty().equalsIgnoreCase(stringGameDifficulty)) {
                return gameDifficulty;
            }
        }
        throw new IllegalArgumentException("Game difficulty not found: " + stringGameDifficulty);
    }


//    CLASS STRUCTURE -----------------------------------------------------
    private final String difficulty;

    public String getDifficulty() {
        return difficulty;
    }

    GameDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
