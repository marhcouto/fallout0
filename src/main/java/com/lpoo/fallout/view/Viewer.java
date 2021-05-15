package com.lpoo.fallout.view;

import com.lpoo.fallout.gui.LanternaGUI;

import java.io.IOException;

public abstract class Viewer<T> {
    private final T model;

    public Viewer(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void draw(LanternaGUI gui) throws IOException {
        drawElements(gui);
        gui.draw();
    }

    protected abstract void drawElements(LanternaGUI gui);
}
