package com.lpoo.fallout;

import com.lpoo.fallout.controller.Game;

import java.io.IOException;

public class Application {

    public static void main(String[] args) {
        System.out.println("Hello Fallout!");
        try {
            Game game = new Game();
            game.run();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

