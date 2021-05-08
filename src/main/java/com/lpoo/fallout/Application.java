package com.lpoo.fallout;

import com.lpoo.fallout.controller.Game;

import java.io.*;

public class Application {

    public static void main(String[] args) {
        try {
            Game game = new Game();
            game.run();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

