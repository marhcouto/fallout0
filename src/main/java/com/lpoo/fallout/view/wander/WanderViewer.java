package com.lpoo.fallout.view.wander;

import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.LanternaDrawable;
import com.lpoo.fallout.model.wander.Position;
import com.lpoo.fallout.model.wander.element.Wall;
import com.lpoo.fallout.model.wander.WanderModel;
import com.lpoo.fallout.view.Viewer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WanderViewer implements Viewer {
    private final LanternaGUI gui;
    private final WanderModel model;
    private static final Map<Enemy.TYPE, LanternaDrawable> drawableMap = new HashMap<>();

    static {
        drawableMap.put(Enemy.TYPE.RAT, new LanternaDrawable("#00FF00", "#FF00FF", "R"));
        drawableMap.put(Enemy.TYPE.SCORPION, new LanternaDrawable("#FF00FF", "#00FF00", "S"));
    }

    public WanderViewer(LanternaGUI gui, WanderModel model) {
        this.gui = gui;
        this.model = model;
    }

    @Override
    public void draw() throws IOException {

        for (Map.Entry<Position, Wall> wall: model.getWalls().entrySet())
            gui.placeDrawable(new LanternaDrawable( "#000000", "#00FF00", "#"), wall.getValue().getPosition());

        for (Enemy enemy: model.getEnemies())
            gui.placeDrawable(drawableMap.get(enemy.getType()), enemy.getPosition());

        gui.placeDrawable(new LanternaDrawable( "#000000", "#0000FF", "W"), model.getVaultBoy().getPosition());
        gui.draw();
    }
}
