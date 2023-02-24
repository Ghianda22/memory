package com.soprasteria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soprasteria.controller.parameters.PlayParam;
import com.soprasteria.controller.parameters.StartNewGameParam;
import com.soprasteria.exceptions.GameAlreadyExistException;
import com.soprasteria.exceptions.GameAlreadyStartedException;
import com.soprasteria.exceptions.InvalidParamException;
import com.soprasteria.model.game.Game;
import com.soprasteria.services.GameService;

@RestController
@RequestMapping("/game")
public class GameController {

	@Autowired
	private final GameService gameService = new GameService();
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	
	/**
	 * This method will be called from the front-end when the player wants to see all active games, to choose 
	 * which one to connect to.
	 * @return all the game storage, with OK as status.
	 */
	@GetMapping("/showactivegames")
	public ResponseEntity<Object> showActiveGames(){
		return new ResponseEntity<Object> (gameService.getAllGames(),HttpStatus.OK);
	}
	
	/**
	 * This method will be called from the front-end when the player wants to start a new game.
	 * @param param: requested parameters for createGame method in GameService.
	 * @return the new game, with OK as status.
	 */
	@PostMapping("/startnewgame")
	public ResponseEntity<Object> startNewGame(@RequestBody StartNewGameParam param){
		try {
			return new ResponseEntity <Object>(gameService.createGame(param.getGameName(),param.getNumberOfPlayers(),param.getPlayerAvatar(),param.isGameVisibility(),param.getGameDifficulty(),param.getStringMatchIcon()),HttpStatus.OK);
		} catch (GameAlreadyExistException e) {
			return new ResponseEntity <Object>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * This method will be called from the front-end when the player wants to connect to a game.
	 * @param param: requested parameters for connectToGame method in GameService.
	 * @return the game to connect if everything is OK, else bad request with the exception's message.
	 */
	@PostMapping("/connecttogame/{gameName}/{playerAvatar}")
	public ResponseEntity<Object> connectToGame(@PathVariable(value = "gameName") String gameName,@PathVariable(value = "playerAvatar") String playerAvatar){
		try {
			String completeAvatar = "/images/icons/" + playerAvatar + "-icon.png";
			return new ResponseEntity<Object>(gameService.connectToGame(completeAvatar, gameName), HttpStatus.OK);
		} catch (InvalidParamException | GameAlreadyStartedException e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/gameplay")
	public ResponseEntity<Object> play(@RequestBody PlayParam param){
		try {
			simpMessagingTemplate.convertAndSend("/topic/game-progress/" + gameService.selectCard(param.getGameName(), param.getIndexOfSelectedCard(), param.getPlayer()).getGameName(),gameService.selectCard(param.getGameName(), param.getIndexOfSelectedCard(), param.getPlayer()));
			return new ResponseEntity<Object>(gameService.selectCard(param.getGameName(), param.getIndexOfSelectedCard(), param.getPlayer()),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
}
