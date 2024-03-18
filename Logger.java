package org.example.design_patterns.tic_tac_toe_game;

public class Logger implements Observer {
    private Board board;

    public Logger(Board board) {
        this.board = board;
    }

    @Override
    public void update() {
        logBoardState();
    }

    public void logBoardState() {
        System.out.print("\n\n                                                 ");
        System.out.println("Logging current game board state:\n");

        char[][] gameBoard = board.getGameBoard();
        for (int i = 0; i < gameBoard.length; i++) {
            System.out.print("                                                 ");
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.printf("%2s",gameBoard[i][j]);
                if (j < gameBoard[i].length - 1) {
                    System.out.print("   |   ");
                }
            }
            System.out.println();
            if (i < gameBoard.length - 1) {
                System.out.print("                                                 ");
                System.out.println("---------------------");
            }
        }
        System.out.print("\n                                                 ");

    }
}
