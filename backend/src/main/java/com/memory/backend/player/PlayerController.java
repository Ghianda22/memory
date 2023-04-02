package com.memory.backend.player;

import com.memory.backend.player.data.request.AdminRegistrationRequestBean;
import com.memory.backend.player.data.response.PlayerResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("livegame")
public class PlayerController {
    private final PlayerDelegate playerDelegate;

    @Autowired
    public PlayerController(PlayerDelegate playerDelegate) {
        this.playerDelegate = playerDelegate;
    }

    @GetMapping("{gameId}")
    public ResponseEntity<PlayerResponseBean> registerPlayer(@PathVariable(value = "gameId") UUID gameId) {
        return playerDelegate.admitPlayerToGameWithId(gameId);
    }

    public void reigsterInvitedPlayer() {
    }

    @GetMapping("/admin")
    public ResponseEntity<PlayerResponseBean> registerAdmin(@RequestBody AdminRegistrationRequestBean adminRegistrationRequestBean) {
        return playerDelegate.registerAdmin(adminRegistrationRequestBean);
    }
}
