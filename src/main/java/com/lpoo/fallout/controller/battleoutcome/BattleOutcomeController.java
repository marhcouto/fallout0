package com.lpoo.fallout.controller.battleoutcome;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.MainController;
import com.lpoo.fallout.gui.GUI;
import com.lpoo.fallout.model.battleoutcome.BattleOutcomeModel;

public class BattleOutcomeController extends MainController<BattleOutcomeModel> {
    public BattleOutcomeController(BattleOutcomeModel model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        switch(action) {
            case QUIT: {
                game.clearStates();
                break;
            }
            case ENTER: {
                game.popState();
                break;
            }
            default: {
                break;
            }
        }
    }
}
