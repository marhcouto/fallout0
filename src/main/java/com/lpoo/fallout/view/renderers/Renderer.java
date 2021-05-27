package com.lpoo.fallout.view.renderers;

import com.lpoo.fallout.gui.GUI;
import com.lpoo.fallout.model.wander.Position;

public abstract class Renderer<M, I extends GUI<?>> {
    private final M model;
    private Position position;

    public Renderer(M model, Position position) {
        this.model = model;
        this.position = position;
    }

    public M getModel() {
        return model;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public abstract void placeElement(I gui, String foregroundColour, String backgroundColour);

    public abstract void buildImage();
}