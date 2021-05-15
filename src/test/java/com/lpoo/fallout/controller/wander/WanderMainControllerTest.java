package com.lpoo.fallout.controller.wander;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.model.wander.Arena;
import com.lpoo.fallout.model.wander.Position;
import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import com.lpoo.fallout.model.wander.element.Wall;
import com.lpoo.fallout.model.wander.WanderModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

class WanderMainControllerTest {
    Game game;

    @BeforeEach
    void setUp() throws IOException, ClassNotFoundException {
        game = new Game();
    }

    @Test
    void noBattle() throws IOException {

        Arena arena = new Arena(Arrays.asList(new Wall(new Position(1, 0))), Arrays.asList(new Enemy(new Position(2, 0), Enemy.TYPE.RAT)), "Teste");
        WanderModel model = new WanderModel(new VaultBoy(new Position(0, 0)), arena);
        WanderMainController controller = new WanderMainController(game, model);

        controller.run();

        Assertions.assertEquals(WanderMainController.class, game.topController().getClass());
    }

    @Test
    void battle() throws IOException {
        Arena arena = new Arena(new ArrayList<Wall>(), Arrays.asList(new Enemy(new Position(2, 0), Enemy.TYPE.RAT)), "Name");
        WanderModel model = new WanderModel(new VaultBoy(new Position(0, 0)), arena);
        WanderMainController controller = new WanderMainController(game, model);

        controller.run();

        Assertions.assertEquals(BattleMainController.class, game.topController().getClass());
    }
}