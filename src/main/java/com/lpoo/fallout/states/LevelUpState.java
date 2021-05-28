package com.lpoo.fallout.states;

import com.lpoo.fallout.controller.MainController;
import com.lpoo.fallout.controller.statsmenu.levelup.LevelUpController;
import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.statsmenu.levelup.LevelUpModel;
import com.lpoo.fallout.view.Viewer;
import com.lpoo.fallout.view.statsmenu.levelup.LevelUpMenuView;
import org.jetbrains.annotations.NotNull;

public class LevelUpState extends State<LevelUpModel> {
    public LevelUpState(LevelUpModel model) {
        super(model);
    }

    @Override
    public @NotNull LevelUpModel getModel() {
        return super.getModel();
    }

    @Override
    protected @NotNull Viewer<LevelUpModel, LanternaGUI> getViewer() {
        return new LevelUpMenuView(getModel());
    }

    @Override
    protected @NotNull MainController<LevelUpModel> getController() {
        return new LevelUpController(getModel());
    }
}
