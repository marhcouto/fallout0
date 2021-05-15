package com.lpoo.fallout.states;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.MainController;
import com.lpoo.fallout.gui.GUI;
import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.view.Viewer;

import java.io.IOException;

public abstract class State<T> {
    private final T model;
    private final MainController<T> controller;
    private final Viewer<T, LanternaGUI> viewer;

    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }

    protected abstract Viewer<T, LanternaGUI> getViewer();
    protected abstract MainController<T> getController();

    public T getModel() {
        return model;
    }

    public void step(Game game, long time) throws IOException {
        GUI.ACTION action = game.getGui().getAction();
        controller.step(game, action, time);
        viewer.draw(game.getGui());
    }
}
