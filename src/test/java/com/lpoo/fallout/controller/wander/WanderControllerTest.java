package com.lpoo.fallout.controller.wander;

import com.lpoo.fallout.model.wander.Attributes;
import com.lpoo.fallout.model.wander.Position;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import com.lpoo.fallout.model.wander.element.Wall;
import com.lpoo.fallout.model.wander.WanderModel;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;

class WanderControllerTest {
    @BeforeEach
    void setUp() {
        WanderModel model = new WanderModel(new VaultBoy(new Position(1, 0), new Attributes(0, 0, 0, 0)));
        model.setWalls(Arrays.asList(new Wall(new Position(0, 0)), new Wall(new Position(1, 1))));
    }

}