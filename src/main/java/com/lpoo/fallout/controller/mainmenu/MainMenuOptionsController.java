package com.lpoo.fallout.controller.mainmenu;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.OptionMenuController;
import com.lpoo.fallout.controller.mainmenu.command.*;
import com.lpoo.fallout.gui.GUI;
import com.lpoo.fallout.model.filehandling.FileHandler;
import com.lpoo.fallout.model.mainmenu.MainMenuModel;

import java.util.HashMap;
import java.util.Map;

public class MainMenuOptionsController extends OptionMenuController<MainMenuModel> {
    private int usedPoints;
    private static final int MAX_AVAILABLE_POINTS = 16;
    private Map<MainMenuModel.OPTION, MainMenuCommand> commandMap;

    public MainMenuOptionsController(MainMenuModel model) {
        super(model);
        this.commandMap = createCommands(this);
        this.usedPoints = 8;
    }

    public static Map<MainMenuModel.OPTION, MainMenuCommand> createCommands(MainMenuOptionsController controller) {
        Map<MainMenuModel.OPTION, MainMenuCommand> result = new HashMap<>();
        result.put(MainMenuModel.OPTION.STRENGTH, new StrengthCommand(controller));
        result.put(MainMenuModel.OPTION.AGILITY, new AgilityCommand(controller));
        result.put(MainMenuModel.OPTION.INTELLIGENCE, new IntelligenceCommand(controller));
        result.put(MainMenuModel.OPTION.LUCK, new LuckCommand(controller));
        result.put(MainMenuModel.OPTION.NEXT, new NextCommand(controller, new FileHandler()));
        return result;
    }

    public boolean incrementUsedPoints() {
        if (usedPoints < MAX_AVAILABLE_POINTS) {
            usedPoints++;
            return true;
        }
        return false;
    }

    public void decrementUsedPoints() {
        if (usedPoints > 0) {
            usedPoints--;
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action) {
        switch (action) {
            case DOWN: {
                super.step(game, GUI.ACTION.DOWN);
                break;
            }
            case UP: {
                super.step(game, GUI.ACTION.UP);
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
            case ENTER: {
                commandMap.get(getModel().getSelectedOption()).activate(game);
                break;
            }
        }
    }
}
