package com.lpoo.fallout.model;

public class Wall extends Element{
    public Wall (Position position) {
        super(position);
    }

    @Override
    protected LanternaDrawable imageCreator() {
        return new LanternaDrawable("Blue", "Black", "#");
    }
}