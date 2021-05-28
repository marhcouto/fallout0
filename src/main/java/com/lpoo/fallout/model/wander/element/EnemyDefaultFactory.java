package com.lpoo.fallout.model.wander.element;

import com.lpoo.fallout.model.wander.Attributes;
import com.lpoo.fallout.model.wander.CharacterInfo;
import com.lpoo.fallout.model.wander.Position;
import org.jetbrains.annotations.NotNull;

public class EnemyDefaultFactory implements EnemyFactory {

    private static @NotNull Enemy createRat(@NotNull Position enemyPosition) {
        Attributes ratDefaultAttributes = new Attributes(2, 2, 2, 2);
        return new Enemy(enemyPosition, new CharacterInfo(ratDefaultAttributes, 0, 2), 5, 1, Enemy.TYPE.RAT);
    }

    private static @NotNull Enemy createScorpion(@NotNull Position enemyPosition) {
        Attributes defaultScorpAttributes = new Attributes(5, 5, 5, 5);
        return new Enemy(enemyPosition, new CharacterInfo(defaultScorpAttributes, 0, 5), 8, 1, Enemy.TYPE.SCORPION);
    }

    private static @NotNull Enemy createSnake(@NotNull Position enemyPosition) {
        Attributes defaultSnakeAttributes = new Attributes(5, 8, 5, 6);
        return new Enemy(enemyPosition, new CharacterInfo(defaultSnakeAttributes, 0, 8), 12, 2, Enemy.TYPE.SNAKE);
    }

    @Override
    public @NotNull Enemy createEnemy(@NotNull Enemy.TYPE enemyType, @NotNull Position enemyPosition) {
        switch (enemyType) {
            case RAT: {
                return createRat(enemyPosition);
            }
            case SCORPION: {
                return createScorpion(enemyPosition);
            }
            case SNAKE: {
                return createSnake(enemyPosition);
            }
            default: {
                return null; //Explodes app
            }
        }
    }
}
