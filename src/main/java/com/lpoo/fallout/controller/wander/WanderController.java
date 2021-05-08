package com.lpoo.fallout.controller.wander;

import com.lpoo.fallout.controller.Controller;
import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.filehandling.FileWanderModelFactory;
import com.lpoo.fallout.model.wander.*;
import com.lpoo.fallout.view.wander.WanderViewer;

import java.io.IOException;

public class WanderController implements Controller {
    private WanderModel model;
    private WanderViewer viewer;
    private final Game game;

    private final VaultBoyController vaultBoyController;
    private final EnemyController enemyController;

    public WanderController(Game game) throws IOException, ClassNotFoundException {
        this.model = new FileWanderModelFactory().createWanderModel();
        this.enemyController = new EnemyController(model);
        this.viewer = new WanderViewer(game.getGui(), model);
        this.game = game;
        this.vaultBoyController = new VaultBoyController(model);

    }

    @Override
    public void run() throws IOException {
        this.react();
        this.enemyController.moveEnemies();
        this.viewer.draw();
    }

    @Override
    public void react() throws IOException {
        LanternaGUI.ACTION nextAction = this.game.getGui().getAction();
        switch (nextAction) {
            case UP: {
                this.vaultBoyController.moveVaultBoy(this.model.getVaultBoy().getPosition().up());
            }
            case DOWN: {
                this.vaultBoyController.moveVaultBoy(this.model.getVaultBoy().getPosition().down());
            }
            case RIGHT: {
                this.vaultBoyController.moveVaultBoy(this.model.getVaultBoy().getPosition().right());
            }
            case LEFT: {
                this.vaultBoyController.moveVaultBoy(this.model.getVaultBoy().getPosition().left());
            }
            case NONE: {
                break;
            }
            case QUIT: {
                this.game.clearControllers();
            }
        }
    }
}
