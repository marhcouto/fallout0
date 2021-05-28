package com.lpoo.fallout.controller;

import com.lpoo.fallout.gui.GUI;
import com.lpoo.fallout.model.option.OptionMenuModel;

public abstract class OptionMenuController <T extends OptionMenuModel<? extends Enum>> {
    private final T model;

    public OptionMenuController(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void step(Game game, GUI.ACTION action) {
        switch (action) {
            case UP: {
                model.decreaseSelectedIdx();
                break;
            }
            case DOWN: {
                model.increaseSelectedIdx();
                break;
            }
            default: {
                break;
            }
        }
    }
}
