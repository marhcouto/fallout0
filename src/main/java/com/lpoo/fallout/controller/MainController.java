package com.lpoo.fallout.controller;

import java.io.IOException;

public abstract class MainController {
    private final Game game;

    public MainController(Game game)  {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public abstract void run() throws IOException;
    public abstract void react() throws IOException;
}
