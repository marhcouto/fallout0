package com.lpoo.fallout.gui;



import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.lpoo.fallout.model.LanternaDrawable;

import java.io.IOException;

public class LanternaGUI {
    private final LanternaTerminal terminal;

    public enum ACTION {UP, DOWN, LEFT, RIGHT, QUIT, UTIL_E, UTIL2, UTIL3, NONE}

    private enum DRAW_STATUS {
        CLEAN,
        DIRTY
    }
    private DRAW_STATUS currentStatus;

    public LanternaGUI(LanternaTerminal terminal) {
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

    public ACTION getAction() throws IOException {

        KeyStroke keyStroke = terminal.getScreen().pollInput();
        if (keyStroke == null)
            return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'e') return ACTION.UTIL_E;

        return ACTION.NONE;
    }

    public LanternaTerminal getTerminal() {
        return terminal;
    }
}
