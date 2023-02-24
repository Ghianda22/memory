package com.soprasteria.services;

import org.springframework.stereotype.Service;

import com.soprasteria.exceptions.CardAlreadySelectedException;
import com.soprasteria.exceptions.GameAlreadyExistException;
import com.soprasteria.exceptions.GameAlreadyStartedException;
import com.soprasteria.exceptions.InvalidParamException;
import com.soprasteria.model.game.Game;
import com.soprasteria.model.game.GameStatus;
import com.soprasteria.model.icons.Card;
import com.soprasteria.model.player.Player;
import com.soprasteria.storage.GameStorage;

@Service
public class GameService {
	
	/**
	 * This method simply return all the games when a player wants to connect to a game.
	 * @return the game storage.
	 */
	public GameStorage getAllGames() {
		return GameStorage.getInstance();
	}
	
	/**
	 * This method simply create a new game, add the player that creates the game to the list of players, and
	 * add the new game to the game storage.Then, it set as turn player the player that created the turn.
	 * 
	 * @param gameName: for the constructor of game.
	 * @param numberOfPlayers: for the constructor of game.
	 * @param player: for the constructor of game.
	 * @param gameVisibility: for the constructor of game.
	 * @param gameDifficulty: for the constructor of game.
	 * @param stringMatchIcon: for the constructor of game.
	 * @return the new game.
	 * @throws GameAlreadyExistException 
	 */
	public Game createGame(String gameName,int numberOfPlayers, String playerAvatar, boolean gameVisibility,String gameDifficulty, String stringMatchIcon) throws GameAlreadyExistException {
		if(GameStorage.getInstance().getGameStorage().containsKey(gameName)) {
			throw new GameAlreadyExistException("A game with this title already exists. Select another name.");
		}
		Game newGame = new Game(gameName,numberOfPlayers, gameVisibility, gameDifficulty, stringMatchIcon);
		Player player = new Player(playerAvatar);
		newGame.getListOfPlayers().add(player);
		newGame.setTurnPlayer(player);
		GameStorage.getInstance().setGameStorage(newGame);
		return newGame;
	}
	
	/**
	 * This method is made to add a player to an existing game.
	 * @param player: to add the player to the list of players of the selected game.
	 * @param gameName: to search if there is the game which who the player wants to connect.
	 * @return the selected game.
	 * @throws InvalidParamException
	 * @throws GameAlreadyStartedException
	 */
	public Game connectToGame(String playerAvatar, String gameName) throws InvalidParamException, GameAlreadyStartedException {
		if(!GameStorage.getInstance().getGameStorage().containsKey(gameName)) {
			throw new InvalidParamException("Selected game does not exist.");
		}
		Game game = GameStorage.getInstance().getGameStorage().get(gameName);
		if(game.getGameStatus() != GameStatus.NEW) {
			throw new GameAlreadyStartedException("Game has already started.");
		}
		Player player = new Player(playerAvatar);
		game.getListOfPlayers().add(player);
		game.setGameStatus(game.getListOfPlayers().size() == game.getNumberOfPlayers() ? GameStatus.IN_PROGRESS :  GameStatus.NEW);
		GameStorage.getInstance().setGameStorage(game);
		return game;
	}
	
	
	/**
	 * This method is made to make the player to select one card, then it checks if the previous selected card
	 * (if it is not null).
	 * @param gameName.
	 * @param indexOfSelectedCard.
	 * @param player.
	 * @return the game.
	 * @throws InvalidParamException.
	 * @throws CardAlreadySelectedException.
	 */
	public Game selectCard(String gameName,int indexOfSelectedCard, Player player) throws InvalidParamException, CardAlreadySelectedException {
		if(!GameStorage.getInstance().getGameStorage().containsKey(gameName)) {
			throw new InvalidParamException("Selected game does not exist");
		}
		if(GameStorage.getInstance().getGameStorage().get(gameName).getListOfCards().size() <= indexOfSelectedCard) {
			throw new InvalidParamException("Selected card does not exist."); 
		}
		Game game = GameStorage.getInstance().getGameStorage().get(gameName);
		if(game.getListOfCards().get(indexOfSelectedCard).isSelected()) {
			throw new CardAlreadySelectedException("The card is already selected.");
		}
		else {
			game.getListOfCards().get(indexOfSelectedCard).setSelected(true);
		}
		Card selectedCard = GameStorage.getInstance().getGameStorage().get(gameName).getListOfCards().get(indexOfSelectedCard);
		if(player.getPreviousSelectedIcon() == null) {
			player.setPreviousSelectedIcon(selectedCard.getCardIcon());
		}
		else if(player.getPreviousSelectedIcon() == selectedCard.getCardIcon()){
			player.setCollectedCards(player.getCollectedCards() + 1);
			game.setGameStatus(player.getCollectedCards() == (game.getListOfCards().size() / 2) ? GameStatus.FINISHED : GameStatus.IN_PROGRESS);
			if(game.getGameStatus() == GameStatus.FINISHED) {
				GameStorage.getInstance().getGameStorage().remove(gameName);
				game.calculateClassification();
			}
			else {
				player.setPreviousSelectedIcon(null);
			}
			//The player continues to select if the game is not finished
		}
		else {
			player.setPreviousSelectedIcon(null);
			//The player does not continue to select
			game.changeTurnPlayer(player);
		}
		GameStorage.getInstance().setGameStorage(game);
		return game;
	}
	
}
