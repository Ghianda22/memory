package com.memory.backend.livegame;

import com.memory.backend.livegame.data.IncomingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class LiveGameController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public LiveGameController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/actions") //channel between player-server
    public void send(IncomingEvent event){
        System.out.println(event);
//        simpMessagingTemplate.convertAndSend("/livegame/" + message.getFrom(), message);

    }
}
