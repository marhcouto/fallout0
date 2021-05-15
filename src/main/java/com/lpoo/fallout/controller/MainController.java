package com.lpoo.fallout.controller;

import com.lpoo.fallout.gui.LanternaGUI;

public abstract class MainController<T> {
    private final T model;

    public MainController(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Game game, LanternaGUI.ACTION action, long time);
}
