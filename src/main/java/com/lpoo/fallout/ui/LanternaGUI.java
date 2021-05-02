package com.lpoo.fallout.ui;

import com.googlecode.lanterna.TextColor;

import java.io.IOException;

public class LanternaGUI implements GUI{
    private final LanternaTerminal terminal;
    private enum DRAW_STATUS {
        CLEAN,
        DIRTY
    }
    private DRAW_STATUS currentStatus;

    public LanternaGUI() throws IOException {
        terminal = new LanternaTerminal();
        currentStatus = DRAW_STATUS.DIRTY;
    }

    @Override
    public DrawableFactory<? extends Drawable<? extends GUI>> getDrawableFactory() {
        return new LanternaDrawableFactory();
    }

    @Override
    public void draw() throws IOException{
        terminal.getScreen().refresh();
    }

    public void placeChar(LanternaDrawable drawable) {
        if (currentStatus == DRAW_STATUS.DIRTY) {
            terminal.getScreen().clear();
        }
        terminal.getGraphics().setBackgroundColor(TextColor.Factory.fromString(drawable.getForegroundColor()));
        terminal.getGraphics().setForegroundColor(TextColor.Factory.fromString(drawable.getBackgroudColor()));
        terminal.getGraphics().putString(drawable.getPosition().getColumn(), drawable.getPosition().getRow(), drawable.getChar());
    }
}
