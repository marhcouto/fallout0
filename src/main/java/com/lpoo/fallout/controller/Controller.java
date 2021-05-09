package com.lpoo.fallout.controller;

import java.io.IOException;

public abstract class Controller {
    private final Game game;

    public Controller(Game game)  {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public abstract void run() throws IOException;
    public abstract void react() throws IOException;
}
