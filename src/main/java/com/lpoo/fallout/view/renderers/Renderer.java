package com.lpoo.fallout.view.renderers;

import com.lpoo.fallout.gui.LanternaGUI;

public abstract class Renderer<T> {
    T model;

    public Renderer(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void placeElement(LanternaGUI gui);
}