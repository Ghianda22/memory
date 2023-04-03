package com.memory.backend.livegame.data;

public class MessageBean {
    private String from;
    private String text;

    MessageBean(String from, String text) {
        this.from = from;
        this.text = text;
    }

    public String getFrom() {
        return from;
    }

    public String getText() {
        return text;
    }
}
