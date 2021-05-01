package com.lpoo.fallout.ui;

import com.lpoo.fallout.data.Position;

public class LCharacter {
    private final String foregroundColor;
    private final String backgroudColor;
    private final String imgChar;
    private final Position position;

    public LCharacter(Position position, String foregroundColor, String backgroudColor, String imgChar) {
        this.foregroundColor = foregroundColor;
        this.backgroudColor = backgroudColor;
        this.imgChar = imgChar;
        this.position = position;
    }

    public String getForegroundColor() {
        return foregroundColor;
    }

    public String getBackgroudColor() {
        return backgroudColor;
    }

    public String getImgChar() {
        return imgChar;
    }

    public Position getPosition() {
        return position;
    }
}
