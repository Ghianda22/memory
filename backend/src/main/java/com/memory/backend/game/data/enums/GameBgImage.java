package com.memory.backend.game.data.enums;

public enum GameBgImage {

    BRAIN("/images/active_games/brain-ag-bg.jpg"),
    EINSTEIN("/images/active_games/einstein-ag-bg.jpg"),
    ELEPHANT( "/images/active_games/elephant-ag-bg.jpg"),
    LION("/images/active_games/lion-ag-bg.jpg");

    public static GameBgImage fromValue(String stringGameBgImage){
        for(GameBgImage gameBgImage : GameBgImage.values()) {
            if (gameBgImage.getImage().equalsIgnoreCase(stringGameBgImage)) {
                return gameBgImage;
            }
        }
        throw new IllegalArgumentException("Icon not found: " + stringGameBgImage);
    }

    private final String image;

    public String getImage() {
        return image;
    }

    GameBgImage(String image) {
        this.image = image;
    }
}
