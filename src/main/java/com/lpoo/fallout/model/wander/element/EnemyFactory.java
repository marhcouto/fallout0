package com.lpoo.fallout.model.wander.element;

import com.lpoo.fallout.model.wander.Position;
import org.jetbrains.annotations.NotNull;

public interface EnemyFactory {
    @NotNull Enemy createEnemy(@NotNull Enemy.TYPE enemyType, @NotNull Position enemyPosition);
}
