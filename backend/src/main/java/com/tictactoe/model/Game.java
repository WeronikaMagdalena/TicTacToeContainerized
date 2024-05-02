package com.tictactoe.model;

import lombok.Data;

@Data
public class Game {
    Character[] board;
    Character winner;
    Boolean gameOver = false;

    public Game() {
        board = new Character[9];
    }

}
