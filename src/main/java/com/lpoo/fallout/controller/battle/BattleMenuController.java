package com.lpoo.fallout.controller.battle;

import com.lpoo.fallout.controller.Command;
import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.OptionMenuController;
import com.lpoo.fallout.controller.battle.Attack.AttackCommand;
import com.lpoo.fallout.gui.GUI;
import com.lpoo.fallout.model.battle.BattleMenuModel;
import com.lpoo.fallout.model.battle.TurnModel;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BattleMenuController extends OptionMenuController<BattleMenuModel> {
    private final Map<BattleMenuModel.OPTION, Command<TurnModel>> activationHandlers;
    private final TurnModel currentTurn;

    public BattleMenuController(BattleMenuModel model, TurnModel currentTurn) {
        super(model);
        activationHandlers = createCommands(this);
        this.currentTurn = currentTurn;
    }

    public static Map<BattleMenuModel.OPTION, Command<TurnModel>> createCommands(BattleMenuController controller) {
        Map<BattleMenuModel.OPTION, Command<TurnModel>> result = new HashMap<>();
        result.put(BattleMenuModel.OPTION.ATTACK, new AttackCommand(new Random()));
        return result;
    }

    @Override
    public void step(Game game, GUI.ACTION action) {
        switch (action) {
            case RIGHT: {
                getModel().rightSelectedIdx();
                break;
            }
            case LEFT: {
                getModel().leftSelectedIdx();
                break;
            }
            case UP: {
                getModel().decreaseSelectedIdx();
                break;
            }
            case DOWN: {
                getModel().increaseSelectedIdx();
                break;
            }
            case ENTER: {
                activationHandlers.get(getModel().getSelectedOption()).activate(currentTurn);
            }
        }
    }
}
