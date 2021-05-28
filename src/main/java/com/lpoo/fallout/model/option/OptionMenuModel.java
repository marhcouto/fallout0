package com.lpoo.fallout.model.option;

public abstract class OptionMenuModel<E extends Enum<E>> {
    private int selected;
    private int numberOfOptions;
    private int lowerLimit;

    public OptionMenuModel(int numberOfOptions, int lowerLimit) {
        if (numberOfOptions == 0) {
            throw new InvalidNumberOfOptions();
        }
        this.lowerLimit = lowerLimit;
        this.numberOfOptions = numberOfOptions;
    }

    protected void setNumberOfOptions(int numberOfOptions) {
        this.numberOfOptions = numberOfOptions;
    }

    protected void setLowerLimit(int lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public int getNumberOfOptions() {
        return numberOfOptions;
    }

    public int getLowerLimit() {
        return lowerLimit;
    }

    public OptionMenuModel(int numberOfOptions) {
        this(numberOfOptions, 0);
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
        if (selected > lowerLimit) {
            selected--;
        }
    }
}
