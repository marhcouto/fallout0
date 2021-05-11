package com.lpoo.fallout.model.mainmenu;

import com.lpoo.fallout.ControllableMenu;
import com.lpoo.fallout.model.Option;
import com.lpoo.fallout.model.wander.Attributes;

import java.util.ArrayList;
import java.util.List;

public class MainMenuModel implements ControllableMenu <Integer> {
    private final List<Option<Integer>> availableOptions;
    private int selectedOption;

    public MainMenuModel() {
        availableOptions = new ArrayList<>();
        availableOptions.add(new Option<>("Strength", 0));
        availableOptions.add(new Option<>("Agility", 0));
        availableOptions.add(new Option<>("Intelligence", 0));
        availableOptions.add(new Option<>("Luck", 0));
        availableOptions.add(new Option<>("Let's GO", -1));

        selectedOption = 0;
    }

    public Option<Integer> getSelectedOption() {
        return availableOptions.get(selectedOption);
    }

    @Override
    public Integer getSelectedOptionIndex() {
        return selectedOption;
    }

    public void incrementOption() {
        if (selectedOption < (availableOptions.size() - 1)) {
            Integer curVal = availableOptions.get(selectedOption).getValue();
            availableOptions.get(selectedOption).setValue(curVal + 1);
        }
    }

    public boolean nextButtonSelected() {
        return (selectedOption == (availableOptions.size() - 1));
    }

    public void decrementOption() {
        if (selectedOption < (availableOptions.size() - 1)) {
            Integer curVal = availableOptions.get(selectedOption).getValue();
            availableOptions.get(selectedOption).setValue(curVal - 1);
        }
    }

    @Override
    public void selectUp() {
        if (selectedOption > 0)
            selectedOption -= 1;
    }

    @Override
    public void selectDown() {
        if (selectedOption < (availableOptions.size() - 1))
            selectedOption += 1;
    }

    public List<String> getFormatedOptions() {
        List<String> resList = new ArrayList<>();

        for (Option<Integer> option: availableOptions) {
            StringBuffer buffer = new StringBuffer(option.getName());
            if (option.getValue() != -1) {
                buffer.append(" <");
                buffer.append(option.getValue().toString());
                buffer.append(">");
            }
            resList.add(buffer.toString());
        }
        return resList;
    }
}
