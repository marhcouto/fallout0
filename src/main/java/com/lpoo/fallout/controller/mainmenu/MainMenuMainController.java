package com.lpoo.fallout.controller.mainmenu;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.MainController;
import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.mainmenu.MainMenuModel;
import com.lpoo.fallout.view.mainmenu.MainMenuViewer;

import java.io.IOException;

public class MainMenuMainController implements MainController {
    private static int MAX_AVAILABLE_POINTS = 8;
    private Game game;
    private MainMenuModel model;
    private MainMenuViewer viewer;
    private int availablePoints;

    public MainMenuMainController(Game game) {
        this.game = game;
        model = new MainMenuModel();
        viewer = new MainMenuViewer(game.getGui(), model);
        availablePoints = 8;
    }

    @Override
    public void react() throws IOException {
        LanternaGUI.ACTION nextAction = game.getGui().getAction();
        switch (nextAction) {
            case UP: {
                model.selectUp();
                break;
            }
            case DOWN: {
                model.selectDown();
                break;
            }
            case LEFT: {
                if (model.getSelectedOption().getValue() > 0) {
                    model.decrementOption();
                    availablePoints++;
                }
                break;
            }
            case RIGHT: {
                if (availablePoints > 0) {
                    model.incrementOption();
                    availablePoints--;
                }
                break;
            }
            case ENTER: {
                if (model.nextButtonSelected()) {

                }
                break;
            }
            default: {
                break;
            }
        }
    }

    @Override
    public void run() throws IOException, InterruptedException {
        react();
        viewer.draw();
    }
}
