package com.lpoo.fallout.states;

import com.lpoo.fallout.controller.MainController;
import com.lpoo.fallout.controller.battleoutcome.BattleOutcomeController;
import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.battleoutcome.BattleOutcomeModel;
import com.lpoo.fallout.view.Viewer;
import com.lpoo.fallout.view.battleoutcome.BattleOutcomeViewer;
import org.jetbrains.annotations.NotNull;

public class BattleOutcomeState extends State<BattleOutcomeModel> {
    public BattleOutcomeState(BattleOutcomeModel model) {
        super(model);
    }

    @Override
    protected @NotNull MainController<BattleOutcomeModel> getController() {
        return new BattleOutcomeController(getModel());
    }

    @Override
    public @NotNull BattleOutcomeModel getModel() {
        return super.getModel();
    }

    @Override
    protected @NotNull Viewer<BattleOutcomeModel, LanternaGUI> getViewer() {
        return new BattleOutcomeViewer(getModel());
    }
}
