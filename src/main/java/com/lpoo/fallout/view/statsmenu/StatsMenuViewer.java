package com.lpoo.fallout.view.statsmenu;

import com.googlecode.lanterna.TerminalSize;
import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.LanternaDrawable;
import com.lpoo.fallout.model.statsmenu.StatsMenuModel;
import com.lpoo.fallout.model.wander.Attributes;
import com.lpoo.fallout.model.wander.Position;
import com.lpoo.fallout.view.Viewer;
import com.lpoo.fallout.view.renderers.StringRenderer;

public class StatsMenuViewer extends Viewer<StatsMenuModel, LanternaGUI> {
    public StatsMenuViewer(StatsMenuModel model) {
        super(model);
    }

    @Override
    protected void drawElements(LanternaGUI gui) {
        int columns = gui.getTerminal().getScreen().getTerminalSize().getColumns();
        int rows = gui.getTerminal().getScreen().getTerminalSize().getRows();
        TerminalSize terminalSize = gui.getTerminal().getScreen().getTerminalSize();

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if ((i == 0) || (i == columns - 1) || (j == 0) || (j == rows - 1)) {
                    gui.placeDrawable(new LanternaDrawable("#999999", "#808080", "X"), new Position(i, j));
                } else {
                    gui.placeDrawable(new LanternaDrawable("#808080", "#808080", " "), new Position(i, j));
                }
            }
        }

        new StringRenderer("LEVEL: " + getModel().getVaultBoy().getLevel(), StringRenderer.ALIGN.LEFT, 1, 1, terminalSize).placeElement(gui, "#000000", "#808080");
        StringBuilder stringBuilder = new StringBuilder();
        int curRow = 2;
        for (Attributes.OPTION option: Attributes.OPTION.values()) {
            stringBuilder.append(option.label);
            stringBuilder.append(": ");
            stringBuilder.append(getModel().getVaultBoy().getAttributes().getValue(option));
            new StringRenderer(stringBuilder.toString(), StringRenderer.ALIGN.LEFT, curRow, 1, terminalSize).placeElement(gui, "#000000", "#808080");
            curRow++;
            stringBuilder.setLength(0);
        }
        new StringRenderer("HEALTH POTIONS: " + getModel().getVaultBoy().getInventory().getNoPotions(), StringRenderer.ALIGN.LEFT, 7, 1, terminalSize).placeElement(gui, "#000000", "#808080");

        int curN = 0;
        for (int i = getModel().getLowerLimit(); i < getModel().getLowerLimit() + getModel().getNumberOfOptions(); i++) {
            if (i == getModel().getSelectedIdx()) {
                new StringRenderer(StatsMenuModel.OPTION.valueOfIndex(i).label, StringRenderer.ALIGN.CENTER, 12 + curN, 1, terminalSize).placeElement(gui, "#666633", "#808080");
            } else {
                new StringRenderer(StatsMenuModel.OPTION.valueOfIndex(i).label, StringRenderer.ALIGN.CENTER, 12 + curN, 1, terminalSize).placeElement(gui, "#000000", "#808080");
            }
            curN++;
        }
    }
}
