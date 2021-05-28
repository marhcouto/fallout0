package com.lpoo.fallout.view.battle;

import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.battle.BattleMenuModel;
import com.lpoo.fallout.model.wander.Position;
import com.lpoo.fallout.view.Viewer;
import com.lpoo.fallout.view.renderers.Renderer;
import com.lpoo.fallout.view.renderers.WordRenderer;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class BattleMenuViewer extends Viewer<BattleMenuModel, LanternaGUI> {
    private List<Renderer<?, LanternaGUI>> optionRendererList;
    private final int OPTIONS_PER_COLUMN = 2;
    private final int OPTIONS_PER_ROW = 2;

    public BattleMenuViewer(@NotNull BattleMenuModel menuModel) {
        super(menuModel);
        this.optionRendererList = new ArrayList<>();

        Position curPosition = new Position(10, 230); // Position of first option

        // Create renderers
        for (int i = 0; i < BattleMenuModel.OPTION.values().length; i++) {
            optionRendererList.add(new WordRenderer(BattleMenuModel.OPTION.valueOfIndex(i).label, curPosition));
            if (i % OPTIONS_PER_COLUMN == OPTIONS_PER_COLUMN - 1) {
                curPosition = new Position(curPosition.getColumn() + 150, curPosition.getRow() - 35 * (OPTIONS_PER_ROW - 1));
            } else {
                curPosition = new Position(curPosition.getColumn(), curPosition.getRow() + 35);
            }
        }
        // Build renderers image
        for (Renderer<?, LanternaGUI> renderer : optionRendererList)
            renderer.buildImage();
    }

    @Override
    protected void drawElements(LanternaGUI gui) {
        for (int i = 0; i < optionRendererList.size(); i++) {
            if (i == getModel().getSelectedIdx()) {
                optionRendererList.get(i).placeElement(gui, "#c21628", "#000000");
            } else {
                optionRendererList.get(i).placeElement(gui, "#FF8100", "#000000");
            }
        }
    }
}
