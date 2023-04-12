package com.memory.backend.game.services;

import com.memory.backend.exceptions.NotFoundOnDbException;
import com.memory.backend.game.data.enums.GameDifficulty;
import com.memory.backend.game.data.persistence.GameEntityBuilder;
import com.memory.backend.game.data.persistence.GameRepository;
import com.memory.backend.game.data.persistence.GameEntity;
import com.memory.backend.game.data.enums.GameStatus;
import com.memory.backend.game.data.request.GameRequestBean;
import com.memory.backend.invitations.emails.data.persistence.InvitationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameEntity> getActiveGames() {
        return gameRepository.findAllByStatusAndIsPublicTrue(GameStatus.PENDING);
    }

//    --- DB MANAGEMENT ----------------------------------------------------------------------------

    //    --- SAVE
    public UUID saveNewGame(GameRequestBean gameRequestBean) {
        GameEntity newGame = new GameEntityBuilder()
                .setName(gameRequestBean.getName())
                .setBgImage(gameRequestBean.getBgImage())
                .setDifficulty(gameRequestBean.getDifficulty())
                .setMaxNumberOfPlayers(gameRequestBean.getMaxNumberOfPlayers())
                .setIsPublic(gameRequestBean.getIsPublic())
                .createGame();
//        author not saved here bc what if goes back or close the game?
        return gameRepository.saveAndFlush(newGame).getId();
    }

    //    --- GETTER
    public GameStatus getGameStatusById(UUID gameId) {
        Optional<GameEntity> gameEntityOptional = gameRepository.findById(gameId);
        if (gameEntityOptional.isEmpty()) {
            return null;
        }
        return gameEntityOptional.get().getStatus();
    }

    public GameDifficulty getGameDifficultyById(UUID gameId) {
        Optional<GameEntity> gameEntityOptional = gameRepository.findById(gameId);
        if (gameEntityOptional.isEmpty()) {
            return null;
        }
        return gameEntityOptional.get().getDifficulty();
    }

    public Integer getGameMaxNumberOfPlayers(UUID gameId) {
        Optional<GameEntity> gameEntityOptional = gameRepository.findById(gameId);
        if (gameEntityOptional.isEmpty()) {
            return null;
        }
        return gameEntityOptional.get().getMaxNumberOfPlayers();
    }

    public Boolean validateGameStatus(UUID gameId, GameStatus gameStatus) {
        return getGameStatusById(gameId).equals(gameStatus);
    }

    //    --- UPDATE
    public void updateGameStatusById(UUID gameId, GameStatus newStatus) {
        Optional<GameEntity> gameEntityOptional = gameRepository.findById(gameId);
        if (gameEntityOptional.isPresent()) {
//        TODO: fix this aberrant infraction of the immutability of data
            gameEntityOptional.get().setStatus(newStatus);
            gameRepository.flush();
        }


    }

}
