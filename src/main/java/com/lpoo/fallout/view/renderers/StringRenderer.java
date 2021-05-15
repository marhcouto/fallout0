package com.lpoo.fallout.view.renderers;

import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.LanternaDrawable;
import com.lpoo.fallout.model.wander.Position;

public class StringRenderer extends Renderer<String, LanternaGUI> {
    private String foregroundColour;
    private String backgroundColour;
    private StringRenderer.ALIGN alignment;
    private Integer row;
    private Integer frameWidth;

    public StringRenderer(String model, String foregroundColour, String backgroundColour, StringRenderer.ALIGN alignment, Integer row, Integer frameWidth) {
        super(model);
        this.foregroundColour = foregroundColour;
        this.backgroundColour = backgroundColour;
        this.row = row;
        this.alignment = alignment;
        this.frameWidth = frameWidth;
    }

    @Override
    public void placeElement(LanternaGUI gui) {
        int curColumn = getCenterPosition(gui);

        for (char c: getModel().toCharArray()) {
            gui.placeDrawable(new LanternaDrawable(foregroundColour, backgroundColour, Character.toString(c)), new Position(curColumn, row));
            curColumn++;
        }
    }

    private int getCenterPosition(LanternaGUI gui) {
        switch (alignment) {
            case CENTER: {
                return ((gui.getTerminal().getScreen().getTerminalSize().getColumns() - (frameWidth * 2)) / 2) - (getModel().length() / 2);
            }
            case LEFT: {
                return frameWidth;
            }
            case RIGHT:
                return (gui.getTerminal().getScreen().getTerminalSize().getColumns() - frameWidth) - getModel().length();
        }
        return 0;
    }

    public enum ALIGN {CENTER, LEFT, RIGHT}
}
