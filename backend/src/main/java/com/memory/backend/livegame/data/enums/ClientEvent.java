package com.memory.backend.livegame.data.enums;

public enum ClientEvent {
    START_GAME,
    QUIT_GAME,
    TURN_CARD,
}
/* what does the server returns ?
 *
 * START_GAME -> player record with isTurnPlayer = true
 * QUIT_GAME -> updated list of players
 * TURN_CARD -> updated list of cards? List of modified cards?
 * */