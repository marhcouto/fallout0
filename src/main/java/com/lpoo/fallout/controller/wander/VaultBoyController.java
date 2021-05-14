package com.lpoo.fallout.controller.wander;

import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.wander.Position;
import com.lpoo.fallout.model.wander.WanderModel;

public class VaultBoyController {
    private final WanderModel model;

    public VaultBoyController(WanderModel model) {
        this.model = model;
    }

    public void moveVaultBoy(Position position) {
        if (model.getArena().isSpaceEmpty(position))
            model.getVaultBoy().setPosition(position);
    }

    public void move(LanternaGUI.ACTION action) {
        switch (action) {
            case UP: {
                this.moveVaultBoy(this.model.getVaultBoy().getPosition().up());
                break;
            }
            case DOWN: {
                this.moveVaultBoy(this.model.getVaultBoy().getPosition().down());
                break;
            }
            case RIGHT: {
                this.moveVaultBoy(this.model.getVaultBoy().getPosition().right());
                break;
            }
            case LEFT: {
                this.moveVaultBoy(this.model.getVaultBoy().getPosition().left());
                break;
            }
            default: {
                break;
            }
        }
    }
}
