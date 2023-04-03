package com.memory.backend.livegame;

import com.memory.backend.livegame.data.MessageBean;
import com.memory.backend.livegame.data.MessageBeanBuilder;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class LiveGameController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public MessageBean send(MessageBean message){
        return new MessageBeanBuilder()
                .setFrom(message.getFrom())
                .setText(message.getText())
                .createMessageBean();
    }

    public void startGame(){}
    public void quitGame(){}
    public void enterGame(){}
}
