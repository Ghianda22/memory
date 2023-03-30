package com.memory.backend;

import java.util.Random;

public enum Icons {
    LION,
    DOG,
    TOPHAT,
    DOLPHIN,
    FIRE,
    GLOBE,
    LOCK,
    PIANO,
    PIZZA,
    PRESENT,
    SILLY,
    SUNFLOWER,
    TARGET,
    UMBRELLA;

    private static final Random RANDOM = new Random();

    public static Icons getRandomIcon() {
        return values()[RANDOM.nextInt(values().length)];
    }
}
