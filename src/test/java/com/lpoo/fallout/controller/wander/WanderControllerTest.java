package com.lpoo.fallout.controller.wander;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.gui.GUI;
import com.lpoo.fallout.model.wander.Arena;
import com.lpoo.fallout.model.wander.Position;
import com.lpoo.fallout.model.wander.WanderModel;
import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import com.lpoo.fallout.model.wander.element.Wall;
import com.lpoo.fallout.states.BattleState;
import com.lpoo.fallout.states.WanderState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

class WanderControllerTest {
    /*Game game;

    @BeforeEach
    void setUp() {
        game = Mockito.mock(Game.class);
    }

    @Test
    void noBattle() {
        Arena arena = new Arena(Arrays.asList(new Wall(new Position(1, 0))), Arrays.asList(new Enemy(new Position(2, 0), Enemy.TYPE.RAT)), "Teste");
        WanderModel model = new WanderModel(new VaultBoy(new Position(0, 0)), arena);
        WanderController controller = new WanderController(model);

        game.pushState(new WanderState(model));

        controller.step(game, GUI.ACTION.NONE, 0);

        Mockito.verify(game, Mockito.times(1)).pushState(Mockito.any(WanderState.class));
        Mockito.verify(game, Mockito.never()).pushState(Mockito.any(BattleState.class));
    }

    @Test
    void battle() {
        Arena arena = new Arena(new ArrayList<>(), Arrays.asList(new Enemy(new Position(2, 0), Enemy.TYPE.RAT)), "Name");
        WanderModel model = new WanderModel(new VaultBoy(new Position(0, 0)), arena);
        WanderController controller = new WanderController(model);

        game.pushState(new WanderState(model));

        controller.step(game, GUI.ACTION.NONE, 0);
        Mockito.verify(game, Mockito.times(1)).pushState(Mockito.any(WanderState.class));
        Mockito.verify(game, Mockito.times(1)).pushState(Mockito.any(BattleState.class));
    }*/
}