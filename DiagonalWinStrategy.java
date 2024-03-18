package org.example.design_patterns.tic_tac_toe_game;

public class DiagonalWinStrategy implements WinStrategy{

    @Override
    public boolean checkForWin(char[][] board) {
        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return true;
        }
        if (board[0][2] != '-' && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            return true;
        }
        return false;
    }
}
