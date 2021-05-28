package com.lpoo.fallout.gui;

import java.io.IOException;

public class LanternaGUIFactory implements GUIFactory<LanternaGUI> {
    private int fontSize;

    public LanternaGUIFactory(int fontSize) {
        this.fontSize = fontSize;
    }

    @Override
    public LanternaGUI createGUI(int width, int height) throws IOException {
        return new LanternaGUI(new LanternaTerminal(width, height, fontSize));
    }
}
