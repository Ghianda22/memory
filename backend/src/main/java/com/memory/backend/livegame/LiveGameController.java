package com.memory.backend.livegame;

import com.memory.backend.livegame.data.MessageBean;
import com.memory.backend.livegame.data.MessageBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LiveGameController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public LiveGameController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/actions") //channel between player-server
    public void send(MessageBean message){
        System.out.println(message);
        simpMessagingTemplate.convertAndSend("/livegame/" + message.getFrom(), message);

    }

    public void startGame(){}
    public void quitGame(){}
    public void enterGame(){}
}
