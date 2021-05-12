package com.lpoo.fallout.view.mainmenu;

import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.LanternaDrawable;
import com.lpoo.fallout.model.mainmenu.MainMenuModel;
import com.lpoo.fallout.model.wander.Position;
import com.lpoo.fallout.view.StringViewer;
import com.lpoo.fallout.view.Viewer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainMenuViewer implements Viewer {
    private LanternaGUI gui;
    private MainMenuModel model;
    private static String WELCOME_MESSAGE = "WELCOME TO FALLOUT!";

    public MainMenuViewer(LanternaGUI gui, MainMenuModel model) {
        this.gui = gui;
        this.model = model;
    }

    @Override
    public void draw() throws IOException {
        int columns = gui.getTerminal().getScreen().getTerminalSize().getColumns();
        int rows = gui.getTerminal().getScreen().getTerminalSize().getRows();

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if ((i == 0) || (i == columns - 1) || (j == 0) || (j == rows - 1)) {
                    gui.placeDrawable(new LanternaDrawable("#FF8100", "#E3BF9A", "X"), new Position(i, j));
                } else {
                    gui.placeDrawable(new LanternaDrawable("#FF8100", "#E3BF9A", " "), new Position(i, j));
                }
            }
        }

        new StringViewer(gui, "#66503a", "#E3BF9A", WELCOME_MESSAGE, StringViewer.ALIGN.CENTER, 3, 1).draw();
        List<String> formatedOptions = getFormatedOptions();

        for (int i = 0; i < formatedOptions.size(); i++) {
            if (i == model.getSelectedIndex()) {
                new StringViewer(gui, "#FF0000", "#E3BF9A", formatedOptions.get(i), StringViewer.ALIGN.CENTER, 8 + i, 1).draw();
            } else {
                new StringViewer(gui, "#66503a", "#E3BF9A", formatedOptions.get(i), StringViewer.ALIGN.CENTER, 8 + i, 1).draw();
            }
        }

        gui.draw();
    }

    List<String> getFormatedOptions() {
        List<String> resList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (MainMenuModel.OPTION option: MainMenuModel.OPTION.values()) {
            stringBuilder.append(option.label);
            if (model.getValue(option) != -1) {
                stringBuilder.append(" <");
                stringBuilder.append(model.getValue(option));
                stringBuilder.append(">");
            }
            resList.add(stringBuilder.toString());
            stringBuilder.setLength(0);
        }
        return resList;
    }
}
