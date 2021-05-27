package com.lpoo.fallout.view.battle;

import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.battle.BattleModel;
import com.lpoo.fallout.model.wander.Position;
import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.view.Viewer;
import com.lpoo.fallout.view.renderers.FileSpriteRenderer;
import com.lpoo.fallout.view.renderers.HealthBarRenderer;
import com.lpoo.fallout.view.renderers.StatusBarRenderer;
import com.lpoo.fallout.view.renderers.WordRenderer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BattleViewer extends Viewer<BattleModel, LanternaGUI> {
    private static final Map<Enemy.TYPE, String> drawableMap = new HashMap<>();
    private final FileSpriteRenderer enemyRenderer;
    private final FileSpriteRenderer vaultBoyRenderer;
    private final StatusBarRenderer statusBarRendererVB;
    private final StatusBarRenderer statusBarRendererEN;

    static {
        drawableMap.put(Enemy.TYPE.SCORPION, "SCORPION2.txt");
        drawableMap.put(Enemy.TYPE.SNAKE, "SNAKE.txt");
        drawableMap.put(Enemy.TYPE.RAT, "RAT.txt");
    }

    public BattleViewer(BattleModel model) {
        super(model);

        this.enemyRenderer = new FileSpriteRenderer(drawableMap.get(this.getModel().getFightingEnemy().getType()), new Position(380, 50));
        this.vaultBoyRenderer = new FileSpriteRenderer("VAULTBOY3.txt", new Position(20, 50));
        this.statusBarRendererVB = new StatusBarRenderer(this.getModel().getCharacterStats().get(this.getModel().getVaultBoy()),
                new Position(5, 5));
        this.statusBarRendererEN = new StatusBarRenderer(this.getModel().getCharacterStats().get(this.getModel().getFightingEnemy()),
                new Position(435, 5));
        this.enemyRenderer.buildImage();
        this.vaultBoyRenderer.buildImage();
        this.statusBarRendererVB.buildImage();
        this.statusBarRendererEN.buildImage();
    }

    @Override
    protected void drawElements(LanternaGUI gui) {
        statusBarRendererVB.updateHealthBar(getModel().getCharacterStats().get(getModel().getVaultBoy()).getHealthPoints());
        statusBarRendererEN.updateHealthBar(getModel().getCharacterStats().get(getModel().getFightingEnemy()).getHealthPoints());
        enemyRenderer.placeElement(gui);
        vaultBoyRenderer.placeElement(gui);
        statusBarRendererVB.placeElement(gui);
        statusBarRendererEN.placeElement(gui);
    }
}
