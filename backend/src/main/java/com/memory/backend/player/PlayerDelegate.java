package com.memory.backend.player;

import com.memory.backend.exceptions.NotFoundOnDbException;
import com.memory.backend.game.services.GameService;
import com.memory.backend.player.data.persistence.PlayerEntity;
import com.memory.backend.player.data.request.AdminRegistrationRequestBean;
import com.memory.backend.player.data.response.PlayerResponseBean;
import com.memory.backend.player.data.response.PlayerResponseBeanBuilder;
import com.memory.backend.player.service.PlayerService;
import org.hibernate.validator.internal.constraintvalidators.hv.UUIDValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PlayerDelegate {

    private final PlayerService playerService;

    @Autowired
    public PlayerDelegate(PlayerService playerService) {
        this.playerService = playerService;
    }

    public ResponseEntity<PlayerResponseBean> registerAdmin(AdminRegistrationRequestBean adminRegistrationRequestBean){
        UUID gameId = adminRegistrationRequestBean.getGameId();
        if(!playerService.isGameCreated(gameId)){
            return new ResponseEntity<>(
                    new PlayerResponseBeanBuilder()
                            .setId(gameId)
                            .setMessage("The game does not exist or already has an admin")
                            .createPlayerResponseBean(),
                    HttpStatus.NOT_FOUND);
        }
        if(!playerService.getPlayersInGameWithId(gameId).isEmpty()){
            return new ResponseEntity<>(
                    new PlayerResponseBeanBuilder()
                            .setId(gameId)
                            .setMessage("Something went wrong on the db side")
                            .createPlayerResponseBean(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        UUID playerId = null;
        try {
            playerId = playerService.saveAdmin(gameId, adminRegistrationRequestBean.getAvatar());
        } catch (NotFoundOnDbException e) {
            return new ResponseEntity<>(
                    new PlayerResponseBeanBuilder()
                            .setId(gameId)
                            .setMessage("Game not found")
                            .createPlayerResponseBean(),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                new PlayerResponseBeanBuilder()
                        .setId(playerId)
                        .setMessage("The admin is now in the game with the id: %s".formatted(playerId))
                        .createPlayerResponseBean(),
                HttpStatus.OK);

    }


    public ResponseEntity<PlayerResponseBean> admitPlayerToGameWithId(UUID gameId){
        if(!playerService.isGameActive(gameId)){
            return new ResponseEntity<>(
                    new PlayerResponseBeanBuilder()
                        .setId(gameId)
                        .setMessage("The game is not available")
                        .createPlayerResponseBean(),
                    HttpStatus.NOT_FOUND);
        }
        Boolean isGameFull = playerService.isGameFull(gameId);
        if(isGameFull == null){
            return new ResponseEntity<>(
                    new PlayerResponseBeanBuilder()
                            .setId(gameId)
                            .setMessage("Something went wrong on the db side")
                            .createPlayerResponseBean(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(isGameFull){
            return new ResponseEntity<>(
                    new PlayerResponseBeanBuilder()
                            .setId(gameId)
                            .setMessage("The game is full")
                            .createPlayerResponseBean(),
                    HttpStatus.METHOD_NOT_ALLOWED);
        }
        UUID playerId = playerService.savePlayer(gameId);
        return new ResponseEntity<>(
                new PlayerResponseBeanBuilder()
                        .setId(playerId)
                        .setMessage("The player is now in the game with the id: %s".formatted(playerId))
                        .createPlayerResponseBean(),
                HttpStatus.OK);
    }
}
