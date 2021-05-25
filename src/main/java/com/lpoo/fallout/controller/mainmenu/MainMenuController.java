package com.lpoo.fallout.controller.mainmenu;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.MainController;
import com.lpoo.fallout.controller.mainmenu.command.*;
import com.lpoo.fallout.gui.GUI;
import com.lpoo.fallout.model.mainmenu.MainMenuModel;

import java.util.HashMap;
import java.util.Map;

public class MainMenuController extends MainController<MainMenuModel> {
    private static final int MAX_AVAILABLE_POINTS = 8;
    private Map<MainMenuModel.OPTION, MainMenuCommand> commandMap;
    private int usedPoints;

    private static Map<MainMenuModel.OPTION, MainMenuCommand> createCommands(MainMenuController controller) {
        Map<MainMenuModel.OPTION, MainMenuCommand> result = new HashMap<>();
        result.put(MainMenuModel.OPTION.STRENGTH, new StrengthCommand(controller));
        result.put(MainMenuModel.OPTION.AGILITY, new AgilityCommand(controller));
        result.put(MainMenuModel.OPTION.INTELLIGENCE, new IntelligenceCommand(controller));
        result.put(MainMenuModel.OPTION.LUCK, new LuckCommand(controller));
        result.put(MainMenuModel.OPTION.NEXT, new NextCommand(controller));
        return result;
    }

    public MainMenuController(MainMenuModel model) {
        super(model);
        commandMap = createCommands(this);
        usedPoints = 0;
    }

    public boolean incrementUsedPoints() {
        if (usedPoints < MAX_AVAILABLE_POINTS) {
            usedPoints++;
            return true;
        }
        return false;
    }

    public void decrementUsedPoints() {
        usedPoints--;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        switch (action) {
            case UP: {
                getModel().decrementOption();
                break;
            }
            case DOWN: {
                getModel().incrementOption();
                break;
            }
            case LEFT: {
                commandMap.get(getModel().getSelected()).left();
                break;
            }
            case RIGHT: {
                commandMap.get(getModel().getSelected()).right();
                break;
            }
            case ENTER: {
                commandMap.get(getModel().getSelected()).activate(game);
                break;
            }
            case QUIT: {
                game.clearControllers();
                break;
            }
            default: {
                break;
            }
        }
    }
}
