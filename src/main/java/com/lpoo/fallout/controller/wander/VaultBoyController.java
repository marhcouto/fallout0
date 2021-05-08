package com.lpoo.fallout.controller.wander;

import com.lpoo.fallout.model.wander.Position;
import com.lpoo.fallout.model.wander.WanderModel;

import static com.lpoo.fallout.gui.LanternaGUI.ACTION;

public class VaultBoyController {
    private final WanderModel model;

    public VaultBoyController(WanderModel model) {
        this.model = model;
    }


    public void moveVaultBoy(Position position) {
        if (model.getArena().isSpaceEmpty(position))
            model.getVaultBoy().setPosition(position);
    }
}
