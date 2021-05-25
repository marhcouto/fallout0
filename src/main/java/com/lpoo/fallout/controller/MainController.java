package com.lpoo.fallout.controller;

import com.lpoo.fallout.gui.GUI;

public abstract class MainController<T> {
    private final T model;

    public MainController(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Game game, GUI.ACTION action, long time);
}
