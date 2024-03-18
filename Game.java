package org.example.design_patterns.tic_tac_toe_game;

public class Game {
    public static void main(String[] args) {
        Board board = TicTacToeBoard.getInstance();
        ((TicTacToeBoard) board).setRowWinStrategy(new RowWinStrategy());
        ((TicTacToeBoard) board).setColWinStrategy(new ColumnWinStrategy());
        ((TicTacToeBoard) board).setDiagonalWinStrategy(new DiagonalWinStrategy());
        Observer observer = new Logger(board);
        board.registerObserver(observer);
        board.startGame();
    }
}
