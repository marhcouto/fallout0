package com.lpoo.fallout.controller.wander;

import com.lpoo.fallout.controller.Controller;
import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.battle.BattleController;
import com.lpoo.fallout.model.wander.Position;
import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import com.lpoo.fallout.model.wander.element.Wall;
import com.lpoo.fallout.model.wander.WanderModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.*;

class WanderControllerTest {
    Game game;

    @BeforeEach
    void setUp() throws IOException {
        game = new Game();
    }

    @Test
    void noBattle() throws IOException {
        WanderModel model = new WanderModel(new VaultBoy(new Position(0, 0)));
        Map<Position, Wall> wallMap = new HashMap<>();
        wallMap.put(new Position(1, 0), new Wall(new Position(1, 0)));
        model.setEnemies(Arrays.asList(new Enemy(new Position(2, 0), Enemy.TYPE.RAT)));
        model.setWalls(Arrays.asList(new Wall(new Position(1, 0))));
        WanderController controller = new WanderController(game, model);

        controller.run();

        Assertions.assertEquals(WanderController.class, game.topController().getClass());
    }

    @Test
    void battle() throws IOException{
        WanderModel model = new WanderModel(new VaultBoy(new Position(0, 0)));
        Map<Position, Wall> wallMap = new HashMap<>();
        wallMap.put(new Position(1, 0), new Wall(new Position(1, 0)));
        model.setEnemies(Arrays.asList(new Enemy(new Position(2, 0), Enemy.TYPE.RAT)));
        WanderController controller = new WanderController(game, model);

        controller.run();

        Assertions.assertEquals(BattleController.class, game.topController().getClass());
    }
}