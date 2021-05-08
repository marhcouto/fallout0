package com.lpoo.fallout;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.model.Position;
import com.lpoo.fallout.model.Wall;

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

