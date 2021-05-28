package com.lpoo.fallout.view.messagedisplay;

import com.googlecode.lanterna.TerminalSize;
import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.LanternaDrawable;
import com.lpoo.fallout.model.messagedisplay.MessageDisplayModel;
import com.lpoo.fallout.model.wander.Position;
import com.lpoo.fallout.view.Viewer;
import com.lpoo.fallout.view.renderers.StringRenderer;

public class MessageDisplayViewer extends Viewer<MessageDisplayModel, LanternaGUI> {
    private final int INITIAL_MESSAGE_ROW = 5;

    public MessageDisplayViewer(MessageDisplayModel model) {
        super(model);
    }

    @Override
    protected void drawElements(LanternaGUI gui) {
        TerminalSize terminalSize = gui.getTerminal().getScreen().getTerminalSize();
        int columns = terminalSize.getColumns();
        int rows = terminalSize.getRows();

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if ((i == 0) || (i == columns - 1) || (j == 0) || (j == rows - 1)) {
                    gui.placeDrawable(new LanternaDrawable("#FF8100", "#E3BF9A", "X"), new Position(i, j));
                } else {
                    gui.placeDrawable(new LanternaDrawable("#FF8100", "#E3BF9A", " "), new Position(i, j));
                }
            }
        }

        int curRow = INITIAL_MESSAGE_ROW;
        for (String message: getModel().getMessages()) {
            new StringRenderer(message, StringRenderer.ALIGN.CENTER, curRow, 1, terminalSize).placeElement(gui, "#8f1628", "#E3BF9A");
            curRow++;
        }
        new StringRenderer("PRESS <ENTER> TO CONTINUE!", StringRenderer.ALIGN.CENTER, curRow + 2, 1, terminalSize).placeElement(gui, "#c21628", "#E3BF9A");
    }
}
