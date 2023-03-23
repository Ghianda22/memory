package com.memory.backend.game;


import com.memory.backend.game.data.GameRequestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class GameController {

    private final GameDelegate gameDelegate;

    @Autowired
    public GameController(GameDelegate gameDelegate) {
        this.gameDelegate = gameDelegate;
    }


    @GetMapping("/activegames")
    public ResponseEntity<Object> showActiveGames(){
        return ResponseEntity.ok()
                .body(gameDelegate.getActiveGames());
    }

    @PostMapping("/newgame/create")
    public ResponseEntity<String> createNewGame(@RequestBody GameRequestBean gameRequestBean){
        try{
            gameDelegate.insertNewGame(gameRequestBean);
            return new ResponseEntity<>("The game has been added to the db", HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
