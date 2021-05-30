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

    public BattleMenuController(@NotNull BattleModel battleModel, @NotNull BattleMenuModel model) {
        super(model);
        this.observable = battleModel;
        this.activationHandlers = createCommands(battleModel);
    }

    public static Map<BattleMenuModel.OPTION, BattleCommand> createCommands(BattleModel model) {
        Map<BattleMenuModel.OPTION, BattleCommand> result = new HashMap<>();
        result.put(BattleMenuModel.OPTION.ATTACK, new AttackCommand(model.getBattleInfo().getTurn(), new Random()));
        result.put(BattleMenuModel.OPTION.DEFEND, new DefendCommand(model.getBattleInfo().getTurn()));
        result.put(BattleMenuModel.OPTION.INTIMIDATE, new IntimidateCommand(model.getBattleInfo().getTurn()));
        result.put(BattleMenuModel.OPTION.CURE, new CureCommand(model.getBattleInfo().getTurn(), model.getBattleInfo().getVaultBoy()));
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
                observable.subscribe(new TurnEffect(2, activationHandlers.get(getModel().getSelectedOption())));
                break;
            }
        }
    }
}
