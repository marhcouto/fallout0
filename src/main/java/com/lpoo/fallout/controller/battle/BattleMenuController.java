package com.lpoo.fallout.controller.battle;

import com.lpoo.fallout.controller.Command;
import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.OptionMenuController;
import com.lpoo.fallout.controller.battle.command.DefendCommand;
import com.lpoo.fallout.controller.battle.command.IntimidateCommand;
import com.lpoo.fallout.controller.battle.command.NullData;
import com.lpoo.fallout.controller.battle.command.attack.AttackCommand;
import com.lpoo.fallout.gui.GUI;
import com.lpoo.fallout.model.battle.BattleMenuModel;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BattleMenuController extends OptionMenuController<BattleMenuModel> {
    private final Map<BattleMenuModel.OPTION, Command<NullData>> activationHandlers;

    public BattleMenuController(@NotNull BattleController owner, @NotNull BattleMenuModel model) {
        super(model);
        activationHandlers = createCommands(owner);
    }

    public static Map<BattleMenuModel.OPTION, Command<NullData>> createCommands(BattleController owner) {
        Map<BattleMenuModel.OPTION, Command<NullData>> result = new HashMap<>();
        result.put(BattleMenuModel.OPTION.ATTACK, new AttackCommand(owner.getModel().getTurn(), new Random()));
        result.put(BattleMenuModel.OPTION.DEFEND, new DefendCommand(owner, owner.getModel().getTurn()));
        result.put(BattleMenuModel.OPTION.INTIMIDATE, new IntimidateCommand(owner, owner.getModel().getTurn()));
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
                activationHandlers.get(getModel().getSelectedOption()).activate(new NullData());
                break;
            }
        }
    }
}
