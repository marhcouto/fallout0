package com.lpoo.fallout.view.battleoutcome;

import com.googlecode.lanterna.TerminalSize;
import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.LanternaDrawable;
import com.lpoo.fallout.model.battleoutcome.BattleOutcomeModel;
import com.lpoo.fallout.model.wander.Position;
import com.lpoo.fallout.view.Viewer;
import com.lpoo.fallout.view.renderers.StringRenderer;

public class BattleOutcomeViewer extends Viewer<BattleOutcomeModel, LanternaGUI> {
    public BattleOutcomeViewer(BattleOutcomeModel model) {
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
        new StringRenderer(getModel().getMessage(), StringRenderer.ALIGN.CENTER, 5, 1, terminalSize).placeElement(gui, "#FFFFFF", "#000000");
        new StringRenderer("PRESS <ENTER> TO CONTINUE!", StringRenderer.ALIGN.CENTER, 7, 1, terminalSize).placeElement(gui, "#FFFFFF", "#000000");
    }
}
