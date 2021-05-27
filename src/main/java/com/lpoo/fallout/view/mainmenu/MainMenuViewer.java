package com.lpoo.fallout.view.mainmenu;

import com.googlecode.lanterna.TerminalSize;
import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.LanternaDrawable;
import com.lpoo.fallout.model.mainmenu.MainMenuModel;
import com.lpoo.fallout.model.wander.Position;
import com.lpoo.fallout.view.Viewer;
import com.lpoo.fallout.view.renderers.StringRenderer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainMenuViewer extends Viewer<MainMenuModel, LanternaGUI> {
    private static String WELCOME_MESSAGE = "WELCOME TO FALLOUT!";
    private List<StringRenderer> optionRenders;

    public MainMenuViewer(MainMenuModel model) {
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

        new StringRenderer(WELCOME_MESSAGE, StringRenderer.ALIGN.CENTER, 3, 1, terminalSize).placeElement(gui, "#000000", "#808080");
        List<String> formatedOptions = getFormatedOptions();

        for (int i = 0; i < formatedOptions.size(); i++) {
            if (i == getModel().getSelectedIdx()) {
                new StringRenderer(formatedOptions.get(i), StringRenderer.ALIGN.CENTER, 8 + i, 1, terminalSize).placeElement(gui, "#666633", "#808080");
            } else {
                new StringRenderer(formatedOptions.get(i), StringRenderer.ALIGN.CENTER, 8 + i, 1, terminalSize).placeElement(gui, "#000000", "#808080");
            }
        }
    }

    private List<String> getFormatedOptions() {
        List<String> resList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (MainMenuModel.OPTION option: MainMenuModel.OPTION.values()) {
            stringBuilder.append(option.label);
            if (getModel().getValue(option) != -1) {
                stringBuilder.append(" <");
                stringBuilder.append(getModel().getValue(option));
                stringBuilder.append(">");
            }
            resList.add(stringBuilder.toString());
            stringBuilder.setLength(0);
        }
        return resList;
    }
}
