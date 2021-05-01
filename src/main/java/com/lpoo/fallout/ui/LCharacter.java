package com.lpoo.fallout.ui;

public class LCharacter {
    private final String foregroundColor;
    private final String backgroudColor;
    private final Character imgChar;

    public LCharacter(String foregroundColor, String backgroudColor, Character imgChar) {
        this.foregroundColor = foregroundColor;
        this.backgroudColor = backgroudColor;
        this.imgChar = imgChar;
    }

    public String getForegroundColor() {
        return foregroundColor;
    }

    public String getBackgroudColor() {
        return backgroudColor;
    }

    public Character getImgChar() {
        return imgChar;
    }
}
