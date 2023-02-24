package com.soprasteria.storage;

import java.util.HashMap;
import java.util.Map;

import com.soprasteria.model.game.Game;

public class GameStorage {

	private static Map<String,Game> gameStorage;
	private static GameStorage instance;
	
	//Constructor 
	
	private GameStorage() {
		gameStorage = new HashMap<>();
	}
	
	
	/**
	 * Singleton pattern, to be sure that only a GameStorage will be created during the lifecycle of
	 * the software
	 * @return the GameStorage
	 */
	public static synchronized GameStorage getInstance() {
		if(instance == null) {
			instance = new GameStorage();
		}
		return instance;
	}
	
	//Getter
	
	public Map<String,Game> getGameStorage(){
		return gameStorage;
	}

	//Setter
	public void setGameStorage(Game newGame) {
		gameStorage.put(newGame.getGameName(),newGame);
	}
	
	
}
