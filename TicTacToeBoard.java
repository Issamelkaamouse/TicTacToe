package org.example.design_patterns.tic_tac_toe_game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeBoard implements Board {
    private List<Observer> observers = new ArrayList<>();
    private static TicTacToeBoard instance;
    public final int SIZE = 3;
    private char[][] gameBoard = new char[SIZE][SIZE];

    private WinStrategy rowWinStrategy;
    private WinStrategy colWinStrategy;
    private WinStrategy diagonalWinStrategy;

    private Player currentPlayer = new Player('X');

    public void setRowWinStrategy(WinStrategy rowWinStrategy) {
        this.rowWinStrategy = rowWinStrategy;
    }

    public void setColWinStrategy(WinStrategy colWinStrategy) {
        this.colWinStrategy = colWinStrategy;
    }

    public void setDiagonalWinStrategy(WinStrategy diagonalWinStrategy) {
        this.diagonalWinStrategy = diagonalWinStrategy;
    }

    @Override
    public void startGame() {
        // Initialize the game board with empty cells
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                gameBoard[i][j] = '-';
            }
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            notifyObservers();
            System.out.print("Player " + currentPlayer.getSymbol() + ", enter your move (row column) [ 0,1 or 2 ]:  ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (row < 0 || row >= SIZE || col < 0 || col >= SIZE || gameBoard[row][col] != '-') {
                System.out.println("Invalid move. Please try again.");
                continue;
            }

            gameBoard[row][col] = currentPlayer.getSymbol();

            if (checkForWin()) {
                notifyObservers();
                System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
                break;
            }

            if (checkGameOver()) {
                notifyObservers();
                System.out.println("Game Over!");
                break;
            }

            currentPlayer = (currentPlayer.getSymbol() == 'X') ? new Player('O') : new Player('X');
        }

        scanner.close();
    }
    public void makeMove(int row, int col) {
        if (gameBoard[row][col] == '-') {
            gameBoard[row][col] = currentPlayer.getSymbol();
            currentPlayer = (currentPlayer.getSymbol() == 'X') ? new Player('O') : new Player('X');
            notifyObservers();
        }
    }


    public boolean checkForWin() {
        return  rowWinStrategy.checkForWin(gameBoard) ||
                colWinStrategy.checkForWin(gameBoard) ||
                diagonalWinStrategy.checkForWin(gameBoard);
    }

    public boolean checkGameOver() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (gameBoard[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public char[][] getGameBoard() {
        return gameBoard;
    }

    private TicTacToeBoard(){}

    public static TicTacToeBoard getInstance() {
        if(instance==null) instance=new TicTacToeBoard();
        return instance;
    }


    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(int index) {
        observers.remove(index);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(o->{
            o.update();
        });
    }
}
