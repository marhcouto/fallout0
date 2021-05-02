package com.lpoo.fallout;

import com.lpoo.fallout.gui.LanternaTerminal;
import com.lpoo.fallout.view.GameView;
import com.lpoo.fallout.view.MainMenuView;

import java.io.IOException;

public class Game {
    private LanternaTerminal terminal; //TODO: provavelmente é um singleton porque se criarmos outro terminal a janela vai fechar e abrir a meio do jogo e fica feio
    private GameView view;
    //TODO: Aqui há de estar um controller tmb

    public static void main(String[] args) throws IOException {
        System.out.println("Hello Fallout!");
    }

    public void start() {
        view = new MainMenuView();
    }
}
