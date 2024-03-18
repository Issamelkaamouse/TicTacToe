package org.example.design_patterns.tic_tac_toe_game;

public class ColumnWinStrategy implements WinStrategy{


    @Override
    public boolean checkForWin(char[][] gameBoard) {
        for (int j = 0; j < gameBoard.length; j++) {
            if (gameBoard[0][j] != '-' && gameBoard[0][j] == gameBoard[1][j] && gameBoard[0][j] == gameBoard[2][j]) {
                return true;
            }
        }
        return false;
    }
}
