package com.lpoo.fallout.view.wander;

import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.LanternaDrawable;
import com.lpoo.fallout.model.wander.Position;
import com.lpoo.fallout.model.wander.element.Wall;
import com.lpoo.fallout.model.wander.WanderModel;
import com.lpoo.fallout.view.Viewer;

import java.util.HashMap;
import java.util.Map;

public class WanderViewer extends Viewer<WanderModel, LanternaGUI> {
    private static final Map<Enemy.TYPE, LanternaDrawable> drawableMap = new HashMap<>();

    static {
        drawableMap.put(Enemy.TYPE.RAT, new LanternaDrawable("#00FF00", "#000000", "g"));
        drawableMap.put(Enemy.TYPE.SCORPION, new LanternaDrawable("#FF00FF", "#000000", "h"));
        drawableMap.put(Enemy.TYPE.SNAKE, new LanternaDrawable("#FF00FF", "#000000", "i"));
    }

    public WanderViewer(WanderModel model) {
        super(model);
    }

    @Override
    protected void drawElements(LanternaGUI gui) {
        for (Map.Entry<Position, Wall> wall: getModel().getArena().getWallMap().entrySet())
            gui.placeDrawable(new LanternaDrawable( "#00FF00", "#000000", "#"), wall.getValue().getPosition());

        for (Enemy enemy: getModel().getArena().getEnemies())
            gui.placeDrawable(drawableMap.get(enemy.getType()), enemy.getPosition());

        gui.placeDrawable(new LanternaDrawable( "#FFFFFF", "#000000", "k"), getModel().getVaultBoy().getPosition());
    }

}
