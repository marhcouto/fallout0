package com.lpoo.fallout.states;

import com.lpoo.fallout.controller.MainController;
import com.lpoo.fallout.controller.mainmenu.MainMenuController;
import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.mainmenu.MainMenuModel;
import com.lpoo.fallout.view.Viewer;
import com.lpoo.fallout.view.mainmenu.MainMenuViewer;

public class MainMenuState extends State<MainMenuModel> {
    public MainMenuState(MainMenuModel model) {
        super(model);
    }

    @Override
    protected MainController<MainMenuModel> getController() {
        return new MainMenuController(getModel());
    }

    @Override
    protected Viewer<MainMenuModel, LanternaGUI> getViewer() {
        return new MainMenuViewer(getModel());
    }

    @Override
    public MainMenuModel getModel() {
        return super.getModel();
    }
}
