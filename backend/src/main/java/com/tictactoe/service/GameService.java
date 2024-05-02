package com.tictactoe.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.tictactoe.model.Board;

@Slf4j
@Service
public class GameService {
    Board boardState = new Board();
    private static final Character PLAYER_X = 'X';
    private static final Character PLAYER_O = 'O';
    Character turn = PLAYER_X;
    Boolean game = true;
    private static final Integer[][] WINNING_COMBINATIONS = {
            // Rows
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            // Columns
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            // Diagonals
            {0, 4, 8},
            {2, 4, 6}
    };

    public void start() {
        game = true;
        boardState = new Board();
    }

    public Board makeMove(Integer tileNumber) {
        if (!game)
            return boardState;
        Character[] board = boardState.getBoard();
        if (board[tileNumber] == null) {
            if (turn == PLAYER_X) {
                board[tileNumber] = PLAYER_X;
                turn = PLAYER_O;
            } else {
                board[tileNumber] = PLAYER_O;
                turn = PLAYER_X;
            }
        }
        Character winner = checkWinner();
        if (winner != null) {
            log.info("Player {} wins!", winner);
            game = false;
        }
        return boardState;
    }

    public Character checkWinner() {
        Character winner = null;
        Character[] board = boardState.getBoard();
        for (Integer[] combination : WINNING_COMBINATIONS) {
            if (board[combination[0]] != null &&
                    board[combination[0]] == board[combination[1]] &&
                    board[combination[0]] == board[combination[2]]) {
                winner = board[combination[0]];
                break;
            }
        }
        return winner;
    }

}
