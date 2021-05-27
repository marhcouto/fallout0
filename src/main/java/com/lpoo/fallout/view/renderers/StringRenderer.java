package com.lpoo.fallout.view.renderers;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.LanternaDrawable;
import com.lpoo.fallout.model.wander.Position;

public class StringRenderer extends Renderer<String, LanternaGUI> {
    public StringRenderer(String model, StringRenderer.ALIGN alignment, Integer row, Integer frameWidth, TerminalSize size) {
        super(model, new Position(0, 0));
        super.setPosition(getCenterPosition(row, alignment, frameWidth, size));
    }

    @Override
    public void placeElement(LanternaGUI gui, String foregroundColour, String backgroundColour) {
        int curColumn = getPosition().getColumn();

        for (char c: getModel().toCharArray()) {
            gui.placeDrawable(new LanternaDrawable(foregroundColour, backgroundColour, Character.toString(c)), new Position(curColumn, getPosition().getRow()));
            curColumn++;
        }
    }

    private Position getCenterPosition(Integer row, ALIGN alignment, Integer frameWidth, TerminalSize terminalSize) {
        switch (alignment) {
            case CENTER: {
                return new Position((int)Math.ceil(((float)terminalSize.getColumns() - (frameWidth * 2)) / 2 - ((float)getModel().length() / 2)), row);
            }
            case LEFT: {
                return new Position(frameWidth, row);
            }
            case RIGHT:
                return new Position((terminalSize.getColumns() - frameWidth) - getModel().length(), row);
            default:
                return new Position(frameWidth, row);
        }
    }

    @Override
    public void buildImage() {}

    public enum ALIGN {CENTER, LEFT, RIGHT}
}
