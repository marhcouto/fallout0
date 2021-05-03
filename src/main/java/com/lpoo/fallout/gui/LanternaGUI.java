package com.lpoo.fallout.gui;

import com.googlecode.lanterna.TextColor;
import com.lpoo.fallout.model.LanternaDrawable;

import java.io.IOException;

public class LanternaGUI {
    private final LanternaTerminal terminal;
    private enum DRAW_STATUS {
        CLEAN,
        DIRTY
    }
    private DRAW_STATUS currentStatus;

    public LanternaGUI(LanternaTerminal terminal) throws IOException {
        this.terminal = terminal;
        currentStatus = DRAW_STATUS.DIRTY;
    }

    public void draw() throws IOException{
        terminal.getScreen().refresh();
        currentStatus = DRAW_STATUS.DIRTY;
    }

    public void placeDrawable(LanternaDrawable drawable) {
        if (currentStatus == DRAW_STATUS.DIRTY) {
            terminal.getScreen().clear();
            currentStatus = DRAW_STATUS.CLEAN;
        }
        terminal.getGraphics().setBackgroundColor(TextColor.Factory.fromString(drawable.getBackgroundColor()));
        terminal.getGraphics().setForegroundColor(TextColor.Factory.fromString(drawable.getForegroundColor()));
        terminal.getGraphics().putString(drawable.getPosition().getColumn(), drawable.getPosition().getRow(), drawable.getChar());
    }

    public LanternaTerminal getTerminal() {
        return terminal;
    }
}
