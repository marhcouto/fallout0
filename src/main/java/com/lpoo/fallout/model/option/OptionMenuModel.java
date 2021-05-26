package com.lpoo.fallout.model.option;

public abstract class OptionMenuModel<E extends Enum<E>> {
    private int selected;
    private int numberOfOptions;

    public OptionMenuModel(int numberOfOptions) {
        if (numberOfOptions == 0) {
            throw new InvalidNumberOfOptions();
        }
        this.numberOfOptions = numberOfOptions;
    }

    public abstract E getSelectedOption();

    public int getSelectedIdx() {
        return selected;
    }

    public void increaseSelectedIdx() {
        if (selected < ( numberOfOptions - 1 )) {
            selected++;
        }
    }

    public void setSelectedIdx(int selectedIdx) {
        if (selectedIdx >= 0 && selectedIdx < numberOfOptions) {
            this.selected = selectedIdx;
        }
    }

    public void decreaseSelectedIdx() {
        if (selected > 0) {
            selected--;
        }
    }
}
