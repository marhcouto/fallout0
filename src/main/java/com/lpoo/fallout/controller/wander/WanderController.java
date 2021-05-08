package com.lpoo.fallout.controller.wander;

import com.lpoo.fallout.controller.Controller;
import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.wander.*;
import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import com.lpoo.fallout.view.wander.WanderViewer;

import java.io.IOException;

public class WanderController implements Controller {
    private WanderModel map;
    private WanderViewer viewer;
    private final Game game;

    private final VaultBoyController vaultBoyController;
    private final EnemyController enemyController;

    public WanderController(Game game) {
        //this.map = new RandomWanderFactory(10, 10, 4).createWanderModel();
        this.map = new FileWanderFactory("arena1", new VaultBoy(new Position(5, 5),
                new Attributes(1, 1, 1, 1))).createWanderModel();
        this.enemyController = new EnemyController(map);
        this.viewer = new WanderViewer(game.getGui(), map);
        this.game = game;
        this.vaultBoyController = new VaultBoyController(map);

    }

    @Override
    public void run() throws IOException {
        LanternaGUI.ACTION nextAction = this.game.getGui().getAction();
        // System.out.println(nextAction);
        if (nextAction == LanternaGUI.ACTION.QUIT) {
            this.game.clearControllers();
        } else {
            //this.enemyController.moveEnemies();
            this.vaultBoyController.action(nextAction);
            this.viewer.draw();
        }
    }
}
