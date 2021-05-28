package com.lpoo.fallout.states;

import com.lpoo.fallout.controller.MainController;
import com.lpoo.fallout.controller.statsmenu.StatsMenuController;
import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.statsmenu.StatsMenuModel;
import com.lpoo.fallout.view.Viewer;
import com.lpoo.fallout.view.statsmenu.StatsMenuViewer;
import org.jetbrains.annotations.NotNull;

public class StatsMenuState extends State<StatsMenuModel> {
    public StatsMenuState(StatsMenuModel model) {
        super(model);
    }

    @Override
    public @NotNull StatsMenuModel getModel() {
        return super.getModel();
    }

    @Override
    protected @NotNull MainController<StatsMenuModel> getController() {
        return new StatsMenuController(getModel());
    }

    @Override
    protected @NotNull Viewer<StatsMenuModel, LanternaGUI> getViewer() {
        return new StatsMenuViewer(getModel());
    }
}
