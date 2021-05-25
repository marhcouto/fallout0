package com.lpoo.fallout.states;

import com.lpoo.fallout.controller.MainController;
import com.lpoo.fallout.controller.battle.BattleController;
import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.battle.BattleModel;
import com.lpoo.fallout.view.Viewer;
import com.lpoo.fallout.view.battle.BattleViewer;
import org.jetbrains.annotations.NotNull;

public class BattleState extends State <BattleModel> {
    public BattleState(BattleModel model) {
        super(model);
    }

    @Override
    public @NotNull BattleModel getModel() {
        return super.getModel();
    }

    @Override
    protected @NotNull MainController<BattleModel> getController() {
        return new BattleController(getModel());
    }

    @Override
    protected @NotNull Viewer<BattleModel, LanternaGUI> getViewer() {
        return new BattleViewer(getModel());
    }
}
