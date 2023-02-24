package com.soprasteria.controller.parameters;

import com.soprasteria.model.player.Player;

public class PlayParam {

	String gameName;
	int indexOfSelectedCard;
	Player player;
	
	
	
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public int getIndexOfSelectedCard() {
		return indexOfSelectedCard;
	}
	public void setIndexOfSelectedCard(int indexOfSelectedCard) {
		this.indexOfSelectedCard = indexOfSelectedCard;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
}
