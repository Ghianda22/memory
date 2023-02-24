package com.soprasteria.model.icons;

import lombok.Data;

@Data
public class Card {
	
	private CardIcon cardIcon;
	private boolean selected;
	
	
	//Constructor
	
	
	public Card(CardIcon cardIcon) {
		super();
		this.cardIcon = cardIcon;
		this.selected = false;
	}

	//Getters and Setters
	
	
	public CardIcon getCardIcon() {
		return cardIcon;
	}


	public void setCardIcon(CardIcon cardIcon) {
		this.cardIcon = cardIcon;
	}


	public boolean isSelected() {
		return selected;
	}


	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
	
	
}
