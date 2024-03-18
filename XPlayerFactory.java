package org.example.design_patterns.tic_tac_toe_game;

public class XPlayerFactory implements PlayerFactory{
    @Override
    public Player createPlayer() {
        return new Player('X');
    }
}
