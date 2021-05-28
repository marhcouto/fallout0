package com.lpoo.fallout.view.statsmenu.levelup;

import com.googlecode.lanterna.TerminalSize;
import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.LanternaDrawable;
import com.lpoo.fallout.model.mainmenu.MainMenuModel;
import com.lpoo.fallout.model.statsmenu.levelup.LevelUpModel;
import com.lpoo.fallout.model.wander.Attributes;
import com.lpoo.fallout.model.wander.Position;
import com.lpoo.fallout.view.Viewer;
import com.lpoo.fallout.view.renderers.StringRenderer;

import java.util.ArrayList;
import java.util.List;

public class LevelUpMenuView extends Viewer<LevelUpModel, LanternaGUI> {
    public LevelUpMenuView(LevelUpModel model) {
        super(model);
    }

    @Override
    protected void drawElements(LanternaGUI gui) {
        int columns = gui.getTerminal().getScreen().getTerminalSize().getColumns();
        int rows = gui.getTerminal().getScreen().getTerminalSize().getRows();

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if ((i == 0) || (i == columns - 1) || (j == 0) || (j == rows - 1)) {
                    gui.placeDrawable(new LanternaDrawable("#000000", "#808080", "X"), new Position(i, j));
                } else {
                    gui.placeDrawable(new LanternaDrawable("#808080", "#808080", " "), new Position(i, j));
                }
            }
        }

        TerminalSize terminalSize = gui.getTerminal().getScreen().getTerminalSize();

        new StringRenderer("REMAINING LEVELS: " + (getModel().getVaultBoy().getUnusedLevelPoints() - getModel().getUsedLevel()), StringRenderer.ALIGN.LEFT, 1, 1, terminalSize).placeElement(gui, "#000000", "#808080");

        List<String> formattedOptions = getFormattedOptions();

        for (int i = 0; i < formattedOptions.size(); i++) {
            if (i == getModel().getSelectedIdx()) {
                new StringRenderer(formattedOptions.get(i), StringRenderer.ALIGN.CENTER, 8 + i, 1, terminalSize).placeElement(gui, "#666633", "#808080");
            } else {
                new StringRenderer(formattedOptions.get(i), StringRenderer.ALIGN.CENTER, 8 + i, 1, terminalSize).placeElement(gui, "#000000", "#808080");
            }
        }
    }

    private List<String> getFormattedOptions() {
        List<String> resList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (MainMenuModel.OPTION option: MainMenuModel.OPTION.values()) {
            stringBuilder.append(option.label);
            if (Attributes.OPTION.contains(option.label)) {
                stringBuilder.append(" <");
                int attributeValue = getModel().getNewAttributes().getValue(Attributes.OPTION.valueOf(option.label)) + getModel().getVaultBoy().getAttributes().getValue(Attributes.OPTION.valueOf(option.label));
                stringBuilder.append(attributeValue);
                stringBuilder.append(">");
            }
            resList.add(stringBuilder.toString());
            stringBuilder.setLength(0);
        }
        return resList;
    }
}
