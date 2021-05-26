package com.lpoo.fallout.controller;

import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.gui.LanternaTerminal;
import com.lpoo.fallout.model.mainmenu.MainMenuModel;
import com.lpoo.fallout.states.MainMenuState;
import com.lpoo.fallout.states.State;

import java.io.IOException;
import java.util.Stack;

public class Game {
    private Stack<State> states;
    private static final Integer FPS = 24;
    private final long frameTime;
    private LanternaGUI gui;

    public Game() throws IOException, ClassNotFoundException {
        // Stack for the controllers
        states = new Stack<>();

        frameTime = 1000/60;

        this.gui = new LanternaGUI(new LanternaTerminal(30, 18, 40));
        this.pushController(new MainMenuState(new MainMenuModel()));
    }

    public void pushController(State newController) {
        states.push(newController);
    }
    public void popController() {
        states.pop();
    }
    public void clearControllers() {
        states.clear();
    }
    public State topController() {
        return states.peek();
    }
    public LanternaGUI getGui() {
        return gui;
    }

    public static Integer getFps() {
        return FPS;
    }

    public void run() throws IOException, InterruptedException {
        while (!states.empty()) {
            long startTime = System.currentTimeMillis();
            states.peek().step(this, startTime);

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

    public void changeGui (LanternaGUI newGUI) throws IOException {
        gui.getTerminal().getScreen().close();
        this.gui = newGUI;
    }
}
