package org.example.design_patterns.tic_tac_toe_game;

public interface Board {
    public void startGame();
    char[][] getGameBoard();
    public void registerObserver(Observer o);
    public void removeObserver(int index);
    public void notifyObservers();
}
