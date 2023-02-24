package com.soprasteria.model.player;

import com.soprasteria.model.icons.CardIcon;

import lombok.Data;

@Data
public class Player {
	
	private CardIcon avatar;
	private int collectedCards;
	private CardIcon previousSelectedIcon;
	
	//Constructor
	
	public Player(String avatar) {
		this.avatar = CardIcon.fromValue(avatar);
		this.collectedCards = 0;
		this.previousSelectedIcon = null;
	}
	
	//Method
	
	public void assingPlayer(Player p) {
		this.avatar = p.getAvatar();
		this.collectedCards = p.getCollectedCards();
		this.previousSelectedIcon = p.getPreviousSelectedIcon();
	}

	//Getters and Setters

	public CardIcon getAvatar() {
		return avatar;
	}

	public void setAvatar(CardIcon avatar) {
		this.avatar = avatar;
	}

	public int getCollectedCards() {
		return collectedCards;
	}

	public void setCollectedCards(int collectedCards) {
		this.collectedCards = collectedCards;
	}

	public CardIcon getPreviousSelectedIcon() {
		return previousSelectedIcon;
	}

	public void setPreviousSelectedIcon(CardIcon previousSelectedIcon) {
		this.previousSelectedIcon = previousSelectedIcon;
	}
	
}
