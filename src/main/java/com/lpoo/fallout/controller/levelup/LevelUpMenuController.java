package com.lpoo.fallout.controller.levelup;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.OptionMenuController;
import com.lpoo.fallout.controller.levelup.command.*;
import com.lpoo.fallout.gui.GUI;
import com.lpoo.fallout.model.levelup.LevelUpModel;

import java.util.HashMap;
import java.util.Map;

public class LevelUpMenuController extends OptionMenuController<LevelUpModel> {
    private Map<LevelUpModel.OPTION, LevelUpCommand> commandMap;

    public LevelUpMenuController(LevelUpModel model) {
        super(model);
        commandMap = createCommands(model);
    }

    public static Map<LevelUpModel.OPTION, LevelUpCommand> createCommands(LevelUpModel model) {
        Map<LevelUpModel.OPTION, LevelUpCommand> result = new HashMap<>();
        result.put(LevelUpModel.OPTION.STRENGTH, new StrengthCommand(model));
        result.put(LevelUpModel.OPTION.AGILITY, new AgilityCommand(model));
        result.put(LevelUpModel.OPTION.INTELLIGENCE, new IntelligenceCommand(model));
        result.put(LevelUpModel.OPTION.LUCK, new LuckCommand(model));
        result.put(LevelUpModel.OPTION.NEXT, new CommitCommand(model));
        return result;
    }

    @Override
    public void step(Game game, GUI.ACTION action) {
        switch (action) {
            case ENTER: {
                commandMap.get(getModel().getSelectedOption()).activate(game);
                break;
            }
            case LEFT: {
                commandMap.get(getModel().getSelectedOption()).left();
                break;
            }
            case RIGHT: {
                commandMap.get(getModel().getSelectedOption()).right();
                break;
            }
            default: {
                super.step(game, action);
                break;
            }
        }
    }
}
