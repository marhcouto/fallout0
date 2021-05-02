package com.lpoo.fallout.gui;

import com.lpoo.fallout.data.Position;

public class LanternaSingleCharDrawable implements Drawable<SingleCharGUI>, LanternaChar {
    private final String foregroundColor;
    private final String backgroundColor;
    private final String img;
    private final Position position;

    public LanternaSingleCharDrawable(Position position, String foregroundColor, String backgroundColor, String img) {
        this.foregroundColor = foregroundColor;
        this.backgroundColor = backgroundColor;
        this.img = img;
        this.position = position;
    }

    @Override
    public String getForegroundColor() {
        return foregroundColor;
    }

    @Override
    public String getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public String getChar() {
        return img;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void pushDraw(SingleCharGUI gui) {
        gui.placeChar(this);
    }
}
