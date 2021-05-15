package com.lpoo.fallout.states;

import com.lpoo.fallout.controller.MainController;
import com.lpoo.fallout.controller.wander.WanderController;
import com.lpoo.fallout.model.wander.WanderModel;
import com.lpoo.fallout.view.Viewer;
import com.lpoo.fallout.view.wander.WanderViewer;

public class WanderState extends State<WanderModel> {
    public WanderState(WanderModel model) {
        super(model);
    }

    @Override
    protected Viewer<WanderModel> getViewer() {
        return new WanderViewer(getModel());
    }

    @Override
    protected MainController<WanderModel> getController() {
        return new WanderController(getModel());
    }
}
