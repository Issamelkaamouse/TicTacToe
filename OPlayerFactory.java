package org.example.design_patterns.tic_tac_toe_game;

public class OPlayerFactory implements PlayerFactory{
    @Override
    public Player createPlayer() {
        return new Player('O');
    }
}
