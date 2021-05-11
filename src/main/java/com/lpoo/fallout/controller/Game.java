package com.lpoo.fallout.controller;

import com.lpoo.fallout.controller.mainmenu.MainMenuMainController;
import com.lpoo.fallout.controller.wander.WanderMainController;
import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.gui.LanternaTerminal;

import java.io.IOException;
import java.util.Stack;

public class Game {
    private Stack<MainController> controllers;
    private static final Integer FPS = 24;
    private final long frameTime;
    private final LanternaGUI gui;

    public Game() throws IOException, ClassNotFoundException {
        // Stack for the controllers
        controllers = new Stack<>();

        frameTime = 1000/60;

        this.gui = new LanternaGUI(new LanternaTerminal(25, 25));
        this.pushController(new MainMenuMainController(this));
    }

    public void pushController(MainController newController) {
        controllers.push(newController);
    }
    public void popController() {
        controllers.pop();
    }
    public void clearControllers() {
        controllers.clear();
    }
    public MainController topController() {
        return controllers.peek();
    }
    public LanternaGUI getGui() {
        return gui;
    }

    public static Integer getFps() {
        return FPS;
    }

    public void run() throws IOException, InterruptedException {
        while (!controllers.empty()) {
            long startTime = System.currentTimeMillis();
            controllers.peek().run();

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;
            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        gui.getTerminal().getScreen().close();
    }
}
