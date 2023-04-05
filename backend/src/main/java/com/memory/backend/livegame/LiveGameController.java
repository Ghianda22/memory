package com.memory.backend.livegame;

import com.memory.backend.livegame.data.request.IncomingEvent;
import com.memory.backend.livegame.data.response.OutcomingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class LiveGameController {

    private final SimpMessagingTemplate simpMessagingTemplate;
    private final LivegameDelegate livegameDelegate;

    @Autowired
    public LiveGameController(SimpMessagingTemplate simpMessagingTemplate, LivegameDelegate livegameDelegate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.livegameDelegate = livegameDelegate;
    }

    @MessageMapping("/actions") //channel between player-server
    public void receive(IncomingEvent event){
        System.out.println(event);
        livegameDelegate.handleEvent(event);
    }

    public void send(OutcomingEvent event){
        simpMessagingTemplate.convertAndSend("/livegame/" + event.getGameId(), event);
    }
}
