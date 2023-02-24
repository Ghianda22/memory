package com.soprasteria.model.icons;

public enum MatchIcon {
	
	
	BRAIN("/images/active_games/brain-ag-bg.jpg"),
	EINSTEIN("/images/active_games/einstein-ag-bg.jpg"),
	ELEPHANT( "/images/active_games/elephant-ag-bg.jpg"),
	LION("/images/active_games/lion-ag-bg.jpg");
	
	public static MatchIcon fromValue(String stringMatchIcon){
        for(MatchIcon matchIcon : MatchIcon.values()) {
            if (matchIcon.getIcon().equalsIgnoreCase(stringMatchIcon)) {
                return matchIcon;
            }
        }
        throw new IllegalArgumentException("Icon not found: " + stringMatchIcon);
    }
	
	private final String icon;

    public String getIcon() {
        return icon;
    }

    MatchIcon(String icon) {
        this.icon = icon;
    }
}
