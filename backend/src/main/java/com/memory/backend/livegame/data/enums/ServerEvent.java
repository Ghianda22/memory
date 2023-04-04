package com.memory.backend.livegame.data.enums;

public enum ServerEvent {
    START_GAME,
    UPDATE_SCORE,
    CHANGE_TURN,
    GAME_END
}
/* what does the server returns ?
 *
 * START_GAME -> assignation of turn player to unlock the actions + gameStatus changes -> player record with isTurnPlayer = true
 * UPDATE_SCORE -> player record with score field updated
 * CHANGE_TURN -> player record
 * GAME_END -> void?
 * */