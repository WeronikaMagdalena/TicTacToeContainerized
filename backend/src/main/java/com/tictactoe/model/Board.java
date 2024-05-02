package com.tictactoe.model;

public class Board {
    Character[] board;

    public Board() {
        board = new Character[9];
    }

    public Character[] getBoard() {
        return board;
    }

}
