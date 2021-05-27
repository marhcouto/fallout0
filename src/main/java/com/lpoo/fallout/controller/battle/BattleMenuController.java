package com.lpoo.fallout.controller.battle;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.OptionMenuController;
import com.lpoo.fallout.controller.battle.command.BattleCommand;
import com.lpoo.fallout.controller.battle.command.CureCommand;
import com.lpoo.fallout.controller.battle.command.DefendCommand;
import com.lpoo.fallout.controller.battle.command.IntimidateCommand;
import com.lpoo.fallout.controller.battle.command.attack.AttackCommand;
import com.lpoo.fallout.gui.GUI;
import com.lpoo.fallout.model.battle.BattleMenuModel;
import com.lpoo.fallout.model.battle.BattleModel;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BattleMenuController extends OptionMenuController<BattleMenuModel> {
    private final Map<BattleMenuModel.OPTION, BattleCommand> activationHandlers;
    private final Observable<TurnObserver> observable;
    private final BattleModel battleModel;

    public BattleMenuController(@NotNull BattleController owner, @NotNull BattleMenuModel model) {
        super(model);
        this.observable = owner;
        this.battleModel = owner.getModel();
        this.activationHandlers = createCommands(owner);
    }

    public static Map<BattleMenuModel.OPTION, BattleCommand> createCommands(BattleController owner) {
        Map<BattleMenuModel.OPTION, BattleCommand> result = new HashMap<>();
        result.put(BattleMenuModel.OPTION.ATTACK, new AttackCommand(owner.getModel().getTurn(), new Random()));
        result.put(BattleMenuModel.OPTION.DEFEND, new DefendCommand(owner.getModel().getTurn()));
        result.put(BattleMenuModel.OPTION.INTIMIDATE, new IntimidateCommand(owner.getModel().getTurn()));
        result.put(BattleMenuModel.OPTION.CURE, new CureCommand(owner.getModel().getTurn()));
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
                new TurnEffect(2, activationHandlers.get(getModel().getSelectedOption()), observable);
                break;
            }
        }
    }
}
