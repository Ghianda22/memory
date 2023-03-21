package com.memory.backend.invitations;

import org.springframework.http.ResponseEntity;

public interface SenderService<T> {
    void sendSimpleMessage(T message);
//    ResponseEntity<Object> sendMessageWithAttachment(T message);
}
