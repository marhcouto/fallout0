package com.lpoo.fallout.view.renderers;

import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.wander.Position;

public abstract class ImageRenderer<M> extends Renderer<M, LanternaGUI> {
    private Position position;

    public ImageRenderer(M model, Position position) {
        super(model);
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public abstract void buildImage();
}
