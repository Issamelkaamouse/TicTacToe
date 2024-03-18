package org.example.design_patterns.tic_tac_toe_game;

public class RowWinStrategy implements WinStrategy{
    @Override
    public boolean checkForWin(char[][] gameBoard) {
        for (int i = 0; i < gameBoard.length; i++) {
            if (gameBoard[i][0] != '-' && gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][0] == gameBoard[i][2]) {
                return true;
            }
        }
        return false;
    }
}
