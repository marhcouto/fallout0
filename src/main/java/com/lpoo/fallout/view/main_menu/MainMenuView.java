package com.lpoo.fallout.view.main_menu;

import com.lpoo.fallout.gui.LanternaTerminal;
import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.view.GameView;

import java.io.IOException;

public class MainMenuView implements GameView {
    private final LanternaGUI gui;

    public MainMenuView(LanternaTerminal terminal) throws IOException {
        gui = new LanternaGUI(terminal);
    }

    @Override
    public void draw() {
        //TODO: Quando este método é chamado os dados deste estado são desenhados.
        // O construtor pode receber estruturas para desenhar.
    }
}
