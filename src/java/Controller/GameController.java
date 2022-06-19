package Controller;

import View.GameScreen;
import View.MainFrame;
import model.ApplyRules;
import model.Game;

public class GameController {
    private static GameController game_controller = null;

    private GameController() {}

    public static GameController getInstance() {
        if (game_controller == null) {
            game_controller = new GameController();
        } 
        return game_controller;
    }

    public void createPlayers()
    {
        ApplyRules.createPlayers();
    }

}
