package com.memory.backend.game;

import com.memory.backend.game.data.*;
import com.memory.backend.game.data.enums.GameBgImage;
import com.memory.backend.game.data.enums.GameDifficulty;
import com.memory.backend.game.data.enums.GameStatus;
import com.memory.backend.game.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameDelegate {

    private final GameService gameService;
    private final Integer MAX_PLAYERS = 4;
    private final Integer MIN_PLAYERS = 2;

    @Autowired
    public GameDelegate(GameService gameService) {
        this.gameService = gameService;
    }

    //    check if the new game data are correct then create a new game and save it in the db
    public GameResponseBean getActiveGames(){
        return new GameResponseBeanBuilder()
                .setActiveGames(gameService.getActiveGames())
                .createGameResponseBean();
    }

    public void insertNewGame(GameRequestBean gameRequestBean) throws IllegalArgumentException, NullPointerException{
        checkGameName(gameRequestBean.getGameName());
        checkGameNumberOfPlayers(gameRequestBean.getMaxNumberOfPlayers());
        GameEntity newGameEntity = new GameEntityBuilder()
                .setGameName(gameRequestBean.getGameName())
                .setGameBgImage(GameBgImage.fromValue(gameRequestBean.getGameBgImage()))
                .setGameDifficulty(GameDifficulty.fromValue(gameRequestBean.getGameDifficulty()))
                .setMaxNumberOfPlayers(gameRequestBean.getMaxNumberOfPlayers())
                .setIsGamePublic(gameRequestBean.getIsGamePublic())
                .setGameId(gameService.generateGameId())
                .setGameStatus(GameStatus.PENDING)
                .createGame();
        gameService.saveNewGame(newGameEntity);
    }

    void checkGameName(String gameName) throws NullPointerException, IllegalArgumentException{
        if (gameName.isEmpty()){
            throw new NullPointerException("The game name can't be empty");
        }
        if(gameName.length()<2 || gameName.length()>30){
            throw new IllegalArgumentException("The game name must have a lenght between 2 and 30 characters");
        }
    }
    void checkGameNumberOfPlayers(Integer maxNumberOfPlayers) throws IllegalArgumentException{
        if(maxNumberOfPlayers > MAX_PLAYERS || maxNumberOfPlayers < MIN_PLAYERS){
            throw new IllegalArgumentException("The game is designed to support from " + MIN_PLAYERS + " to " + MAX_PLAYERS);
        }
    }

}
