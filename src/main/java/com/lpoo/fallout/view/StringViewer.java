package com.lpoo.fallout.view;

import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.LanternaDrawable;
import com.lpoo.fallout.model.wander.Position;

import java.io.IOException;

public class StringViewer implements Viewer{
    private String string;
    private String foregroundColour;
    private String backgroundColour;
    private LanternaGUI gui;
    private ALIGN alignment;
    private Integer row;
    private Integer frameWidth;

    public enum ALIGN {CENTER, LEFT, RIGHT}

    private int getCenterPosition() {
        switch (alignment) {
            case CENTER: {
                return ((gui.getTerminal().getScreen().getTerminalSize().getColumns() - (frameWidth * 2)) / 2) - (string.length() / 2);
            }
            case LEFT: {
                return frameWidth;
            }
            case RIGHT:
                return (gui.getTerminal().getScreen().getTerminalSize().getColumns() - frameWidth) - string.length();
        }
        return 0;
    }

    public StringViewer(LanternaGUI gui, String foregroundColour, String backgroundColour, String string, ALIGN alignment, Integer row, Integer frameWidth) {
        this.gui = gui;
        this.foregroundColour = foregroundColour;
        this.backgroundColour = backgroundColour;
        this.string = string;
        this.row = row;
        this.alignment = alignment;
        this.frameWidth = frameWidth;
    }

    @Override
    public void draw() throws IOException {
        int curColumn = getCenterPosition();

        for (char c: string.toCharArray()) {
            gui.placeDrawable(new LanternaDrawable(foregroundColour, backgroundColour, Character.toString(c)), new Position(curColumn, row));
            curColumn++;
        }
    }
}
