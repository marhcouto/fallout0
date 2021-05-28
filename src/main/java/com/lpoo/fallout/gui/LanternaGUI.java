package com.lpoo.fallout.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.lpoo.fallout.model.LanternaDrawable;
import com.lpoo.fallout.model.wander.Position;

import java.io.IOException;

public class LanternaGUI implements GUI<LanternaDrawable> {
    private final LanternaTerminal terminal;
    private DRAW_STATUS currentStatus;

    public LanternaGUI(LanternaTerminal terminal) {
        this.terminal = terminal;
        currentStatus = DRAW_STATUS.DIRTY;
    }

    public void draw() throws IOException {
        terminal.getScreen().refresh();
        currentStatus = DRAW_STATUS.DIRTY;
    }

    public void placeDrawable(LanternaDrawable drawable, Position position) {
        if (currentStatus == DRAW_STATUS.DIRTY) {
            terminal.getScreen().clear();
            currentStatus = DRAW_STATUS.CLEAN;
        }
        terminal.getGraphics().setBackgroundColor(TextColor.Factory.fromString(drawable.getBackgroundColor()));
        terminal.getGraphics().setForegroundColor(TextColor.Factory.fromString(drawable.getForegroundColor()));
        terminal.getGraphics().putString(position.getColumn(), position.getRow(), drawable.getChar());
    }

    @Override
    public GUI.ACTION getAction() throws IOException {
        KeyStroke keyStroke = terminal.getScreen().pollInput();
        if (keyStroke == null)
            return GUI.ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return GUI.ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return GUI.ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return GUI.ACTION.LEFT;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return GUI.ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return GUI.ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'e') return GUI.ACTION.UTIL_E;
        if (keyStroke.getKeyType() == KeyType.Enter) return GUI.ACTION.ENTER;
        if (keyStroke.getKeyType() == KeyType.EOF) return GUI.ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Escape) return GUI.ACTION.ESCAPE;

        return GUI.ACTION.NONE;
    }

    public LanternaTerminal getTerminal() {
        return terminal;
    }

    private enum DRAW_STATUS {
        CLEAN,
        DIRTY
    }
}
