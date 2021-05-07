package com.lpoo.fallout.model;

import com.lpoo.fallout.model.Position;

public class LanternaDrawable {
    Position position;
    private final String foregroundColor;
    private final String backgroundColor;
    private final String img;

    public LanternaDrawable(Position position, String foregroundColor, String backgroundColor, String img) {
        this.foregroundColor = foregroundColor;
        this.backgroundColor = backgroundColor;
        this.img = img;
    }

    public String getForegroundColor() {
        return foregroundColor;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public String getChar() {
        return img;
    }

    public Position getPosition() {
        return position;
    }
}
