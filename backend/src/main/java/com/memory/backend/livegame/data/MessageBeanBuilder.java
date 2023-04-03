package com.memory.backend.livegame.data;

public class MessageBeanBuilder {
    private String from;
    private String text;

    public MessageBeanBuilder setFrom(String from) {
        this.from = from;
        return this;
    }

    public MessageBeanBuilder setText(String text) {
        this.text = text;
        return this;
    }

    public MessageBean createMessageBean() {
        return new MessageBean(from, text);
    }
}