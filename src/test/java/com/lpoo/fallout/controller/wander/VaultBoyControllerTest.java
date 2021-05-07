package com.lpoo.fallout.controller.wander;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.model.Attributes;
import com.lpoo.fallout.model.Position;
import com.lpoo.fallout.model.VaultBoy;
import com.lpoo.fallout.model.Wall;
import com.lpoo.fallout.model.wander.WanderModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class VaultBoyControllerTest {
    VaultBoyController controller;

    @BeforeEach
    void setUp() {
        WanderModel model = new WanderModel(new VaultBoy(new Position(1, 0), new Attributes(0, 0, 0, 0)));
        model.setWalls(Arrays.asList(new Wall(new Position(0, 0)), new Wall(new Position(1, 1))));
        controller = new VaultBoyController(model);
    }

    @Test
    void checkColisionWithWall() {

    }

}