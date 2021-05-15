package com.lpoo.fallout.view.renderers;

import com.lpoo.fallout.gui.GUI;

public abstract class Renderer<M, I extends GUI<?>> {
    M model;

    public Renderer(M model) {
        this.model = model;
    }

    public M getModel() {
        return model;
    }

    public abstract void placeElement(I gui);
}