package com.lpoo.fallout.controller.wander;

import com.lpoo.fallout.model.wander.Position;
import com.lpoo.fallout.model.wander.WanderModel;

import static com.lpoo.fallout.gui.LanternaGUI.ACTION;

public class VaultBoyController {
    private final WanderModel model;

    public VaultBoyController(WanderModel model) {
        this.model = model;
    }

    public void action(ACTION act) {
        switch (act) {
            case UP: {
                moveVaultBoy(model.getVaultBoy().getPosition().up());
                break;
            }
            case LEFT: {
                moveVaultBoy(model.getVaultBoy().getPosition().left());
                break;
            }
            case DOWN: {
                moveVaultBoy(model.getVaultBoy().getPosition().down());
                break;
            }
            case RIGHT: {
                moveVaultBoy(model.getVaultBoy().getPosition().right());
                break;
            }
            default:
                break;
        }
    }

    private void moveVaultBoy(Position position) {
        if (model.isEmpty(position))
            model.getVaultBoy().setPosition(position);
    }
}
