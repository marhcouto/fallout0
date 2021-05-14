package com.lpoo.fallout.controller.mainmenu;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.MainController;
import com.lpoo.fallout.controller.mainmenu.command.*;
import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.mainmenu.MainMenuModel;
import com.lpoo.fallout.view.mainmenu.MainMenuViewer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainMenuController extends MainController {
    private static final int MAX_AVAILABLE_POINTS = 8;
    private Map<MainMenuModel.OPTION, MainMenuCommand> commandMap;
    private MainMenuModel model;
    private MainMenuViewer viewer;
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

    public MainMenuController(Game game) {
        super(game);
        commandMap = createCommands(this);
        model = new MainMenuModel();
        viewer = new MainMenuViewer(getGame().getGui(), model);
        commandMap = createCommands(this);
        usedPoints = 0;
    }

    @Override
    public void react() throws IOException {
        LanternaGUI.ACTION nextAction = getGame().getGui().getAction();
        switch (nextAction) {
            case UP: {
                model.decrementOption();
                break;
            }
            case DOWN: {
                model.incrementOption();
                break;
            }
            case LEFT: {
                commandMap.get(model.getSelected()).left();
                break;
            }
            case RIGHT: {
                commandMap.get(model.getSelected()).right();
                break;
            }
            case ENTER: {
                commandMap.get(model.getSelected()).activate();
                break;
            }
            case QUIT: {
                getGame().clearControllers();
                break;
            }
            default: {
                break;
            }
        }
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

    public MainMenuModel getModel() {
        return model;
    }

    @Override
    public void run() throws IOException {
        react();
        viewer.draw();
    }
}
