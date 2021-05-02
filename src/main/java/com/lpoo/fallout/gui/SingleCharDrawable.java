package com.lpoo.fallout.gui;

import com.lpoo.fallout.data.Position;

public class SingleCharDrawable implements Drawable<SingleCharGUI> {
    private final String foregroundColor;
    private final String backgroundColor;
    private final String img;
    private final Position position;

    public SingleCharDrawable(Position position, String foregroundColor, String backgroundColor, String img) {
        this.foregroundColor = foregroundColor;
        this.backgroundColor = backgroundColor;
        this.img = img;
        this.position = position;
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

    public void pushDraw(SingleCharGUI gui) {
        gui.placeChar(this);
    }
}
