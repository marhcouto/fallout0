package com.lpoo.fallout.controller;

import java.util.Stack;

public class Game {
    private Stack<Controller> controllers;
    private static final Integer FPS = 60;
    private final long frameTime;

    public Game() {
        controllers = new Stack<>();
        frameTime = 1000/60;
    }

    public void pushController(Controller newController) {
        controllers.push(newController);
    }
    public void popController() {
        controllers.pop();
    }

    public void clearControllers() {
        controllers.clear();
    }

    public void run() {
        while (!controllers.empty()) {
            long startTime = System.currentTimeMillis();
            controllers.peek().run();

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;
            if (sleepTime > 0) try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
