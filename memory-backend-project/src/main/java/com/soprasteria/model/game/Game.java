package com.soprasteria.model.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.soprasteria.model.icons.Card;
import com.soprasteria.model.icons.CardIcon;
import com.soprasteria.model.icons.MatchIcon;
import com.soprasteria.model.player.Player;

import lombok.Data;


@Data
public class Game {

	private String gameName;
	private int numberOfPlayers;
	private List<Player> listOfPlayers;
	private List<Card> listOfCards;
	private GameVisibility gameVisibility; 
	private GameDifficulty gameDifficulty;
	private MatchIcon matchIcon;
	private GameStatus gameStatus;
	private Player turnPlayer;
	
	//Constructor
	
	/**
	 * This method is the constructor of the class, it will take some parameters and then initializate all the 
	 * enum class that are in this class, then it will call initializeGameCards
	 * 
	 * @param gameName: a simple string that identify the game
	 * @param listOfPlayers: the list of players in game
	 * @param gameVisibility: the visibility of the game, then I am setting the enum from the boolean (true for public,false for private)
	 * @param gameDifficulty: the difficulty of the game, then I am setting the enum from the string ("Easy","Medium","Hard")
	 * @param stringMatchIcon: the match Icon, then I am setting the enum from the string
	 */
	public Game(String gameName,int numberOfPlayers, boolean gameVisibility,String gameDifficulty, String stringMatchIcon) {
		this.gameName = gameName;
		this.setNumberOfPlayers(numberOfPlayers);
		this.listOfPlayers = new ArrayList<>();
		this.gameVisibility = GameVisibility.fromValue(gameVisibility);
		this.gameDifficulty = GameDifficulty.fromValue(gameDifficulty);
		this.listOfCards = new ArrayList<>();
		this.matchIcon = MatchIcon.fromValue(stringMatchIcon);
		this.gameStatus = GameStatus.NEW;
		this.turnPlayer = null;
		initializeGameCards();
	}
	
	
	//Methods
	
	/**
	 * This method took all the possible values of the cards and then shuffle them into a List. If the difficulty is 
	 * easy, I have to put 8 cards in my listOfCards, 2 copies for each icon. If the difficulty is hard, I have to put
	 * 16 cards etc.
	 */
	public void initializeGameCards() {
		
		List<CardIcon> totalPossibleCards = new ArrayList<>();
		
		for(CardIcon cardIcon : CardIcon.values()) {
			totalPossibleCards.add(cardIcon);
		}
		Collections.shuffle(totalPossibleCards);
		
		switch(gameDifficulty) {
		
		case EASY: 
			for(int i = 0; i < 4; ++i) {
				listOfCards.add(new Card(totalPossibleCards.get(i)));
				listOfCards.add(new Card(totalPossibleCards.get(i)));
			}
		
		case MEDIUM: 
			for(int i = 0; i < 8; ++i) {
				listOfCards.add(new Card(totalPossibleCards.get(i)));
				listOfCards.add(new Card(totalPossibleCards.get(i)));
			}
			
		case HARD: 
			for(int i = 0; i < 12; ++i) {
				listOfCards.add(new Card(totalPossibleCards.get(i)));
				listOfCards.add(new Card(totalPossibleCards.get(i)));
			}
		}
		
		Collections.shuffle(listOfCards);
		
	}
	
	
	/**
	 * This method will be called by the service at the end of the game (in the method selectCard), and simply will
	 * order listOfPlayers, so that in the front-end I will have my ordered list to show at the end of the game.
	 * The method is a simple sorting algorithm.
	 */
	public void calculateClassification() {
		for(int i = 0; i < listOfPlayers.size(); ++i) {
			int max = listOfPlayers.get(i).getCollectedCards();
			int index = i;
			for(int j = i; j < listOfPlayers.size(); ++j) {
				max = listOfPlayers.get(j).getCollectedCards() > max ? listOfPlayers.get(j).getCollectedCards() : listOfPlayers.get(i).getCollectedCards();
				index = listOfPlayers.get(j).getCollectedCards() > max ? j : i;
			}
			Player p = listOfPlayers.get(index);
			listOfPlayers.get(index).assingPlayer(listOfPlayers.get(i));
			listOfPlayers.get(i).assingPlayer(p);
		}
	}
	
	/**
	 * This method simply changes the actual turn player with the  following one in the list of players.
	 * @param actualTurnPlayer
	 */
	public void changeTurnPlayer(Player actualTurnPlayer) {
		int checkSize;
		for(checkSize = 0; checkSize < listOfPlayers.size() && !listOfPlayers.get(checkSize).equals(actualTurnPlayer); ++checkSize);
		int newIndexPlayer = checkSize + 1 < listOfPlayers.size() ? checkSize + 1 : 0;
		turnPlayer = listOfPlayers.get(newIndexPlayer);
	}


	//Getters and Setters
	
	public String getGameName() {
		return gameName;
	}


	public void setGameName(String gameName) {
		this.gameName = gameName;
	}


	public List<Player> getListOfPlayers() {
		return listOfPlayers;
	}


	public void setListOfPlayers(List<Player> listOfPlayers) {
		this.listOfPlayers = listOfPlayers;
	}


	public List<Card> getListOfCards() {
		return listOfCards;
	}


	public void setListOfCards(List<Card> listOfCards) {
		this.listOfCards = listOfCards;
	}


	public GameVisibility getGameVisibility() {
		return gameVisibility;
	}


	public void setGameVisibility(GameVisibility gameVisibility) {
		this.gameVisibility = gameVisibility;
	}


	public GameDifficulty getGameDifficulty() {
		return gameDifficulty;
	}


	public void setGameDifficulty(GameDifficulty gameDifficulty) {
		this.gameDifficulty = gameDifficulty;
	}


	public MatchIcon getMatchIcon() {
		return matchIcon;
	}


	public void setMatchIcon(MatchIcon matchIcon) {
		this.matchIcon = matchIcon;
	}


	public GameStatus getGameStatus() {
		return gameStatus;
	}


	public void setGameStatus(GameStatus gameStatus) {
		this.gameStatus = gameStatus;
	}


	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}


	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}


	public Player getTurnPlayer() {
		return turnPlayer;
	}


	public void setTurnPlayer(Player turnPlayer) {
		this.turnPlayer = turnPlayer;
	}
	
	
}

