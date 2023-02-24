package com.soprasteria.model.icons;

public enum CardIcon {
	
	LION("/images/icons/lion-icon.png"),
	DOG("/images/icons/dog-icon.png"),
	TOPHAT("/images/icons/tophat-icon.png"),
	DOLPHIN("/images/icons/dolphin-icon.png"),
	FIRE("/images/icons/fire-icon.png"),
	GLOBE("/images/icons/globe-icon.png"),
	LOCK("/images/icons/lock-icon.png"),
	PIANO("/images/icons/piano-icon.png"),
	PIZZA("/images/icons/pizza-icon.png"),
	PRESENT("/images/icons/present-icon.png"),
	SILLY("/images/icons/silXly-icon.png"),
	SUNFLOWER("/images/icons/sunflower-icon.png"),
	TARGET("/images/icons/target-icon.png"),
	UMBRELLA("/images/icons/umbrella-icon.png");
	
	public static CardIcon fromValue(String stringCardIcon){
        for(CardIcon cardIcon : CardIcon.values()) {
            if (cardIcon.getIcon().equalsIgnoreCase(stringCardIcon)) {
                return cardIcon;
            }
        }
        throw new IllegalArgumentException("Icon not found: " + stringCardIcon);
    }
	
	private final String icon;

    public String getIcon() {
        return icon;
    }

    CardIcon(String icon) {
        this.icon = icon;
    }
}
