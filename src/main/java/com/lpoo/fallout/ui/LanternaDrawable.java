package com.lpoo.fallout.ui;

import com.lpoo.fallout.data.Position;

public class LanternaDrawable implements Drawable<LanternaGUI>{
    private final String foregroundColor;
    private final String backgroudColor;
    private final String img;
    private final Position position;

    public LanternaDrawable(Position position, String foregroundColor, String backgroudColor, String img) {
        this.foregroundColor = foregroundColor;
        this.backgroudColor = backgroudColor;
        this.img = img;
        this.position = position;
    }

    public String getForegroundColor() {
        return foregroundColor;
    }

    public String getBackgroudColor() {
        return backgroudColor;
    }

    public String getChar() {
        return img;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public void pushDraw(LanternaGUI gui) {
        gui.placeChar(this);
    }
}
