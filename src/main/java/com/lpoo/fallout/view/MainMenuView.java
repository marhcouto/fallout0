package com.lpoo.fallout.view;

import com.lpoo.fallout.gui.LanternaTerminal;
import com.lpoo.fallout.gui.SingleCharGUI;
import com.sun.tools.javac.Main;

import java.io.IOException;

public class MainMenuView implements GameView {
    private final SingleCharGUI gui;

    public MainMenuView(LanternaTerminal terminal) throws IOException {
        gui = new SingleCharGUI(terminal);
    }

    @Override
    public void draw() {
        //TODO: Quando este método é chamado os dados deste estado são desenhados.
        // O construtor pode receber estruturas para desenhar.
    }
}
