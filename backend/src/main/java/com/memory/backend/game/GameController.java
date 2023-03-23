package com.memory.backend.game;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class GameController {

    @GetMapping("/activegames")
    public ResponseEntity<Object> showActiveGames(){

    }

}
