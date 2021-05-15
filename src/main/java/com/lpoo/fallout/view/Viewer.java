package com.lpoo.fallout.view;

import com.lpoo.fallout.gui.GUI;

import java.io.IOException;

public abstract class Viewer<M, I extends GUI<?>> {
    private final M model;

    public Viewer(M model) {
        this.model = model;
    }

    public M getModel() {
        return model;
    }

    public void draw(I gui) throws IOException {
        drawElements(gui);
        gui.draw();
    }

    protected abstract void drawElements(I gui);
}
