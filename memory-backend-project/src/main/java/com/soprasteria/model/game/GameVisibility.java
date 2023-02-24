package com.soprasteria.model.game;

public enum GameVisibility {
	
	PUBLIC(true),
	PRIVATE(false);
	
	public static GameVisibility fromValue(boolean booleanGameVisibility){
        for(GameVisibility gameVisibility : GameVisibility.values()) {
            if (gameVisibility.getVisibility() == booleanGameVisibility) {
                return gameVisibility;
            }
        }
        throw new IllegalArgumentException("Game visibility not found: " + booleanGameVisibility);
    }
	
	private final boolean visibility;

    public boolean getVisibility() {
        return visibility;
    }

    GameVisibility(boolean visibility) {
        this.visibility = visibility;
    }
}

