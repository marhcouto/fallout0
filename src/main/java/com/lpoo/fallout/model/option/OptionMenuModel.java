package com.lpoo.fallout.model.option;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class OptionMenuModel<T extends Option> {
    private List<T> options;
    private int selected;

    public OptionMenuModel(@NotNull List<T> options) {
        if (options.isEmpty()) {
            throw new InvalidNumberOfOptions();
        }
        this.options = options;
    }

    public T getSelectedOption() {
        return options.get(selected);
    }

    public int getSelectedIdx() {
        return selected;
    }

    protected void increaseSelectedIdx() {
        if (selected < (options.size() - 1)) {
            selected++;
        }
    }

    protected void decreseSelectedIdx() {
        if (selected > 0) {
            selected--;
        }
    }

    public abstract void move(DIRECTION direction);

    public enum DIRECTION {UP, DOWN, LEFT, RIGHT}
}
