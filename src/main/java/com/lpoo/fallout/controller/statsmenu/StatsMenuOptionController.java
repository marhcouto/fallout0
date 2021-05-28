package com.lpoo.fallout.controller.statsmenu;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.OptionMenuController;
import com.lpoo.fallout.controller.statsmenu.command.LevelUpCommand;
import com.lpoo.fallout.controller.statsmenu.command.ResetCommand;
import com.lpoo.fallout.gui.GUI;
import com.lpoo.fallout.model.statsmenu.StatsMenuModel;

import java.util.HashMap;
import java.util.Map;

public class StatsMenuOptionController extends OptionMenuController<StatsMenuModel> {
    private final Map<StatsMenuModel.OPTION, StatsMenuCommand> commandMap;

    public StatsMenuOptionController(StatsMenuModel model) {
        super(model);
        commandMap = createCommands(model);
    }

    public static Map<StatsMenuModel.OPTION, StatsMenuCommand> createCommands(StatsMenuModel model) {
        Map<StatsMenuModel.OPTION, StatsMenuCommand> result = new HashMap<>();
        result.put(StatsMenuModel.OPTION.SPEND_POINTS, new LevelUpCommand(model));
        result.put(StatsMenuModel.OPTION.RESET, new ResetCommand(model));
        return result;
    }

    @Override
    public void step(Game game, GUI.ACTION action) {
        if (action == GUI.ACTION.ENTER) {
            commandMap.get(StatsMenuModel.OPTION.valueOfIndex(getModel().getSelectedIdx())).activate(game);
        } else {
            super.step(game, action);
        }
    }
}
