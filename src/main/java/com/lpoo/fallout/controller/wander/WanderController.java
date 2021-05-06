package com.lpoo.fallout.controller.wander;

import com.lpoo.fallout.controller.Controller;
import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.wander.*;
import com.lpoo.fallout.view.Wander.WanderViewer;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WanderController implements Controller {
    private WanderModel map;
    private WanderViewer viewer;
    private final Game game;

    private final VaultBoyController vaultBoyController;

    public WanderController(Game game) {
        this.map = new RandomWanderFactory(10, 10, 4).createWanderModel();
        this.viewer = new WanderViewer(game.getGui(), map);
        this.game = game;
        this.vaultBoyController = new VaultBoyController(map.getVaultBoy());

    }

    @Override
    public void run() throws IOException {
        LanternaGUI.ACTION nextAction = this.game.getGui().getAction();
        if (nextAction == LanternaGUI.ACTION.QUIT) {
            this.game.clearControllers();
        } else {
            this.vaultBoyController.action(nextAction);
            this.viewer.draw();
        }
    }
}
