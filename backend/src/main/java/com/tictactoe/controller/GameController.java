package com.tictactoe.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tictactoe.model.Game;
import com.tictactoe.service.GameService;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    @PostMapping("/playername")
    public ResponseEntity<Void> addName(@RequestParam String playerName) {
        log.info("Player name: {}", playerName);
        gameService.saveName(playerName);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/players")
    public String[] getName() {
        return gameService.getPlayerNames();
    }

    @PostMapping("/reset")
    public void resetPlayerNames() {
        gameService.resetPlayerNames();
    }

    @PostMapping("/start")
    public ResponseEntity<Void> start() {
        gameService.start();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/play")
    public ResponseEntity<Game> play(@RequestParam Integer tileNumber) {
        log.info("Clicked tile: {}", tileNumber);
        return ResponseEntity.ok(gameService.makeMove(tileNumber));
    }

}
