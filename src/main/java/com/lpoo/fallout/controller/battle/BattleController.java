package com.lpoo.fallout.controller.battle;

import com.lpoo.fallout.controller.MainController;
import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.battle.BattleModel;

public class BattleController extends MainController<BattleModel> {

    public BattleController(BattleModel model)  {
        super(model);
    }

    @Override
    public void step(Game game, LanternaGUI.ACTION action, long time) {
        switch (action) {
            case NONE: {
                break;
            }
            case QUIT: {
                game.clearControllers();
                break;
            }
            default: {
                //DO SOMETHING
                break;
            }
        }
    }

}
