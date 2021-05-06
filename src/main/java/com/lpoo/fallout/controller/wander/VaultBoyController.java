package com.lpoo.fallout.controller.wander;

import com.lpoo.fallout.model.VaultBoy;
import com.lpoo.fallout.model.Position;

import static com.lpoo.fallout.gui.LanternaGUI.ACTION;

public class VaultBoyController {
    private final VaultBoy vaultBoy;

    public VaultBoyController(VaultBoy vaultBoy) {
        this.vaultBoy = vaultBoy;
    }

    public VaultBoy getVaultBoy() {
        return vaultBoy;
    }

    public void action(ACTION act) {
        switch (act) {
            case UP: {
                moveVaultBoy(vaultBoy.getPosition().up());
                break;
            }
            case LEFT: {
                moveVaultBoy(vaultBoy.getPosition().left());
                break;
            }
            case DOWN: {
                moveVaultBoy(vaultBoy.getPosition().down());
                break;
            }
            case RIGHT: {
                moveVaultBoy(vaultBoy.getPosition().right());
                break;
            }
            default:
                break;
        }
    }

    public void moveVaultBoy(Position position) {
        vaultBoy.setPosition(position);
    }
}
