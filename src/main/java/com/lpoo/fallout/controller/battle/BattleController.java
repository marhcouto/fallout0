package com.lpoo.fallout.controller.battle;

import com.lpoo.fallout.controller.MainController;
import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.gui.GUI;
import com.lpoo.fallout.model.battle.BattleModel;
import com.lpoo.fallout.model.battle.TurnModel;

public class BattleController extends MainController<BattleModel> {

    public BattleController(BattleModel model)  {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        TurnModel curTurn = getModel().getTurn();
        if (action == GUI.ACTION.QUIT) {
            game.clearControllers();
        } else {
            new BattleMenuController(getModel().getMenuModel(), curTurn).step(game, action);
        }
        getModel().changeTurn();
    }

}
