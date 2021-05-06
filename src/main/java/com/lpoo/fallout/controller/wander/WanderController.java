package com.lpoo.fallout.controller.wander;

import com.lpoo.fallout.controller.Controller;
import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.wander.*;
import com.lpoo.fallout.view.Wander.WanderViewer;

import java.io.IOException;

import static com.lpoo.fallout.gui.LanternaGUI.ACTION.*;

public class WanderController implements Controller {
    private WanderModel arena;
    private WanderViewer viewer;
    private final Game game;

    private final HeroController heroController;


    public WanderController(Game game) {
        this.arena = new RandomWanderFactory(10, 10, 4).createWanderModel();
        this.viewer = new WanderViewer(game.getGui(), arena);
        this.game = game;
        this.heroController = new HeroController(arena.getHero());

    }

    @Override
    public void run() throws IOException {
        while(true) {
            this.heroController.action(this.game.getGui().getAction());
        }
    }
}
