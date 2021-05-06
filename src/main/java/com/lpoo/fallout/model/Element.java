package com.lpoo.fallout.model;

public abstract class Element {
    private Position position;
    protected final LanternaDrawable image;

    public Element(Position position) {
        this.position = position;
        this.image = this.imageCreator();
    }

    public Position getPosition() {
        return position;
    }
    public LanternaDrawable getImage() {
        return image;
    }
    public void setPosition(Position position) {
        this.position = position;
    }

    protected abstract LanternaDrawable imageCreator();
}
