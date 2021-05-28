package com.lpoo.fallout.view.battle;

import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.battle.BattleModel;
import com.lpoo.fallout.model.wander.Position;
import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.view.Viewer;
import com.lpoo.fallout.view.renderers.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BattleViewer extends Viewer<BattleModel, LanternaGUI> {
    private static final Map<Enemy.TYPE, String> drawableMap = new HashMap<>();
    private final List<Renderer<?, LanternaGUI>> rendererList;
    public final BattleMenuViewer battleMenuViewer;
    private WordRenderer message;

    static {
        drawableMap.put(Enemy.TYPE.SCORPION, "SCORPION.txt");
        drawableMap.put(Enemy.TYPE.SNAKE, "SNAKE.txt");
        drawableMap.put(Enemy.TYPE.RAT, "RAT.txt");
    }

    public BattleViewer(BattleModel model) {
        super(model);

        // Add renderers
        this.rendererList = new ArrayList<>();
        this.rendererList.add(new FileSpriteRenderer(drawableMap.get(this.getModel().getBattleInfo().getFightingEnemy().getType()), new Position(390, 50)));
        this.rendererList.add(new FileSpriteRenderer("VAULTBOY3.txt", new Position(20, 50)));
        this.rendererList.add(new StatusBarRenderer(this.getModel().getBattleInfo().getCharacterStats(getModel().getBattleInfo().getVaultBoy()),
                new Position(5, 5)));
        this.rendererList.add(new StatusBarRenderer(this.getModel().getBattleInfo().getCharacterStats(getModel().getBattleInfo().getFightingEnemy()), new Position(435, 5)));
        this.rendererList.add(new FrameSpriteRenderer(new Position(370, 70), new Position(5, 220)));
        this.rendererList.add(new FrameSpriteRenderer(new Position(215, 70), new Position(380, 220)));
        this.message = new WordRenderer(getModel().getBattleInfo().getTurn().getOutcome().getMessageDescriptor(), new Position(385, 230)); // Message

        // Build renderers image
        for (Renderer<?, LanternaGUI> renderer : rendererList)
            renderer.buildImage();
        this.message.buildImage();

        // Option menu
        battleMenuViewer = new BattleMenuViewer(model.getMenuModel());
    }

    private void changeMessage() {
        if (getModel().getBattleInfo().getTurn().getOutcome().isUnseen()) {
            getModel().getBattleInfo().getTurn().getOutcome().setUnseen(false);
            message = new WordRenderer(getModel().getBattleInfo().getTurn().getOutcome().getMessageDescriptor(), new Position(385, 230));
            message.buildImage();
        }
    }

    @Override
    protected void drawElements(LanternaGUI gui) {

        // Change the message
        changeMessage();

        // Draw renderers
        for (Renderer<?, LanternaGUI> renderer : rendererList)
            renderer.placeElement(gui, "#FFFFFF", "#000000");

        message.placeElement(gui, "#FFE34C", "#000000");

        battleMenuViewer.drawElements(gui);
    }
}
