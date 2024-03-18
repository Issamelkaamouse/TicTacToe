package org.example.design_patterns.tic_tac_toe_game;

public interface WinStrategy {
    boolean checkForWin(char[][] gameBoard);
}
