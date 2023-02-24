package com.soprasteria.controller.parameters;

import lombok.Data;

@Data
public class StartNewGameParam {
	
	private String gameName;
	private int numberOfPlayers;
	private String playerAvatar;
	private boolean gameVisibility;
	private String gameDifficulty;
	private String stringMatchIcon;
	
	
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	public boolean isGameVisibility() {
		return gameVisibility;
	}
	public void setGameVisibility(boolean gameVisibility) {
		this.gameVisibility = gameVisibility;
	}
	public String getGameDifficulty() {
		return gameDifficulty;
	}
	public void setGameDifficulty(String gameDifficulty) {
		this.gameDifficulty = gameDifficulty;
	}
	public String getStringMatchIcon() {
		return stringMatchIcon;
	}
	public void setStringMatchIcon(String stringMatchIcon) {
		this.stringMatchIcon = stringMatchIcon;
	}
	public String getPlayerAvatar() {
		return playerAvatar;
	}
	public void setPlayerAvatar(String playerAvatar) {
		this.playerAvatar = playerAvatar;
	}
	
}
