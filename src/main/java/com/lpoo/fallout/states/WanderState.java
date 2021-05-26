package com.lpoo.fallout.states;

import com.lpoo.fallout.controller.MainController;
import com.lpoo.fallout.controller.wander.WanderController;
import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.wander.WanderModel;
import com.lpoo.fallout.view.Viewer;
import com.lpoo.fallout.view.wander.WanderViewer;
import org.jetbrains.annotations.NotNull;

public class WanderState extends State<WanderModel> {
    public WanderState(WanderModel model) {
        super(model);
    }

    @Override
    protected @NotNull Viewer<WanderModel, LanternaGUI> getViewer() {
        return new WanderViewer(getModel());
    }

    @Override
    protected @NotNull MainController<WanderModel> getController() {
        return new WanderController(getModel());
    }
}
