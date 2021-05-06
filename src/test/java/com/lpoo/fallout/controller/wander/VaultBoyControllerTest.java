package com.lpoo.fallout.controller.wander;

import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.Attributes;
import com.lpoo.fallout.model.Position;
import com.lpoo.fallout.model.VaultBoy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VaultBoyControllerTest {
    VaultBoyController controller;

    @BeforeEach
    void setUp() {
        VaultBoy vaultBoy = new VaultBoy(new Position(0, 0), new Attributes(0, 0, 0, 0));
        controller = new VaultBoyController(vaultBoy);
    }

    @Test
    void action() {
        Assertions.assertEquals(new Position(0, 0), controller.getVaultBoy().getPosition());
        controller.action(LanternaGUI.ACTION.RIGHT);
        Assertions.assertEquals(new Position(1, 0), controller.getVaultBoy().getPosition());
        controller.action(LanternaGUI.ACTION.DOWN);
        Assertions.assertEquals(new Position(1, 1), controller.getVaultBoy().getPosition());
        controller.action(LanternaGUI.ACTION.UP);
        Assertions.assertEquals(new Position(1, 0), controller.getVaultBoy().getPosition());
        controller.action(LanternaGUI.ACTION.LEFT);
        Assertions.assertEquals(new Position(0, 0), controller.getVaultBoy().getPosition());
        controller.action(LanternaGUI.ACTION.NONE);
        Assertions.assertEquals(new Position(0, 0), controller.getVaultBoy().getPosition());
    }
}