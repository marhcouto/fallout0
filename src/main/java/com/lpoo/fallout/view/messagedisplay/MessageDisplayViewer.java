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
        for (int i = 0; i < terminalSize.getRows(); i++) {
            gui.placeDrawable(new LanternaDrawable("#FFFFFF", "#000000", "X"), new Position(0, i));
            gui.placeDrawable(new LanternaDrawable("#FFFFFF", "#000000", "X"), new Position(terminalSize.getColumns() - 1, i));
        }
        for (int i = 1; i < terminalSize.getColumns() - 1; i++) {
            gui.placeDrawable(new LanternaDrawable("#FFFFFF", "#000000", "X"), new Position(i, 0));
            gui.placeDrawable(new LanternaDrawable("#FFFFFF", "#000000", "X"), new Position(i, terminalSize.getRows() - 1));
        }

        int curRow = INITIAL_MESSAGE_ROW;
        for (String message: getModel().getMessages()) {
            new StringRenderer(message, StringRenderer.ALIGN.CENTER, curRow, 1, terminalSize).placeElement(gui, "#FFFFFF", "#000000");
            curRow++;
        }
        new StringRenderer("PRESS <ENTER> TO CONTINUE!", StringRenderer.ALIGN.CENTER, curRow + 2, 1, terminalSize).placeElement(gui, "#FFFFFF", "#000000");
    }
}
