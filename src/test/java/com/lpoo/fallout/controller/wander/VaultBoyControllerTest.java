package com.lpoo.fallout.controller.wander;

import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.wander.Attributes;
import com.lpoo.fallout.model.wander.Position;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import com.lpoo.fallout.model.wander.element.Wall;
import com.lpoo.fallout.model.wander.WanderModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class VaultBoyControllerTest {
    VaultBoyController controller;
    WanderModel model;

    @BeforeEach
    void setUp() {
        model = new WanderModel(new VaultBoy(new Position(1, 0)));
        model.setWalls(Arrays.asList(new Wall(new Position(0, 0)), new Wall(new Position(1, 1))));
        controller = new VaultBoyController(model);
    }

    @Test
    void checkCollisionWithWall() {
        controller.action(LanternaGUI.ACTION.LEFT);
        Assertions.assertEquals(new Position(1, 0), model.getVaultBoy().getPosition());
    }

}