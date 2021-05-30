package com.lpoo.fallout.view.statsmenu;

import com.googlecode.lanterna.TerminalSize;
import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.LanternaDrawable;
import com.lpoo.fallout.model.levelup.LevelUpModel;
import com.lpoo.fallout.model.statsmenu.StatsMenuModel;
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
                    gui.placeDrawable(new LanternaDrawable("#FF8100", "#E3BF9A", "X"), new Position(i, j));
                } else {
                    gui.placeDrawable(new LanternaDrawable("#FF8100", "#E3BF9A", " "), new Position(i, j));
                }
            }
        }

        new StringRenderer("LEVEL: " + getModel().getVaultBoy().getLevel(), StringRenderer.ALIGN.LEFT, 1, 1, terminalSize).placeElement(gui, "#8f1628", "#E3BF9A");
        StringBuilder stringBuilder = new StringBuilder();
        int curRow = 2;
        for (LevelUpModel.OPTION option: LevelUpModel.OPTION.values()) {
            if (option != LevelUpModel.OPTION.NEXT) {
                stringBuilder.append(option.label);
                stringBuilder.append(": ");
                stringBuilder.append(LevelUpModel.getValue(getModel().getVaultBoy().getCharacterInfo().getAttributes(), option));
                new StringRenderer(stringBuilder.toString(), StringRenderer.ALIGN.LEFT, curRow, 1, terminalSize).placeElement(gui, "#8f1628", "#E3BF9A");
                curRow++;
                stringBuilder.setLength(0);
            }
        }
        new StringRenderer("HEALTH POTIONS: " + getModel().getVaultBoy().getCharacterInfo().getNoPotions(), StringRenderer.ALIGN.LEFT, 7, 1, terminalSize).placeElement(gui, "#8f1628", "#E3BF9A");

        int curN = 0;
        for (int i = getModel().getLowerLimit(); i < getModel().getLowerLimit() + getModel().getNumberOfOptions(); i++) {
            if (i == getModel().getSelectedIdx()) {
                new StringRenderer(StatsMenuModel.OPTION.valueOfIndex(i).label, StringRenderer.ALIGN.CENTER, 12 + curN, 1, terminalSize).placeElement(gui, "#c21628", "#E3BF9A");
            } else {
                new StringRenderer(StatsMenuModel.OPTION.valueOfIndex(i).label, StringRenderer.ALIGN.CENTER, 12 + curN, 1, terminalSize).placeElement(gui, "#FF8100", "#E3BF9A");
            }
            curN++;
        }
    }
}
