package com.soprasteria.model.game;

public enum GameDifficulty {
	
	EASY("Easy"),
	MEDIUM("Medium"),
	HARD("Hard");
	
	public static GameDifficulty fromValue(String stringGameDifficulty){
        for(GameDifficulty gameDifficulty : GameDifficulty.values()) {
            if (gameDifficulty.getDifficulty().equalsIgnoreCase(stringGameDifficulty)) {
                return gameDifficulty;
            }
        }
        throw new IllegalArgumentException("Game difficulty not found: " + stringGameDifficulty);
    }
	
	private final String difficulty;

    public String getDifficulty() {
        return difficulty;
    }

    GameDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
