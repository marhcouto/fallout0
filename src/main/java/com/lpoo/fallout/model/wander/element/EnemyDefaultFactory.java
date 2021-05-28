package com.lpoo.fallout.model.wander.element;

import com.lpoo.fallout.model.wander.Attributes;
import com.lpoo.fallout.model.wander.Inventory;
import com.lpoo.fallout.model.wander.Position;
import com.lpoo.fallout.model.wander.Weapon;
import org.jetbrains.annotations.NotNull;

public class EnemyDefaultFactory implements EnemyFactory {

    private static @NotNull Enemy createRat(@NotNull Position enemyPosition) {
        Weapon defaultRatWeapon = new Weapon(2, "Teeth", new Attributes());
        Attributes ratDefaultAttributes = new Attributes(2, 2, 2, 2);
        return new Enemy(enemyPosition, ratDefaultAttributes, new Inventory(0, defaultRatWeapon), 5, 1, Enemy.TYPE.RAT);
    }

    private static @NotNull Enemy createScorpion(@NotNull Position enemyPosition) {
        Weapon defaultScorpWeapon = new Weapon(5, "Stinger", new Attributes());
        Attributes defaultScorpAttributes = new Attributes(5, 5, 5, 5);
        return new Enemy(enemyPosition, defaultScorpAttributes, new Inventory(0, defaultScorpWeapon), 8, 1, Enemy.TYPE.SCORPION);
    }

    private static @NotNull Enemy createSnake(@NotNull Position enemyPosition) {
        Weapon defaultSnakeWeapon = new Weapon(8, "Fang", new Attributes());
        Attributes defaultSnakeAttributes = new Attributes(5, 8, 5, 6);
        return new Enemy(enemyPosition, defaultSnakeAttributes, new Inventory(0, defaultSnakeWeapon), 12, 2, Enemy.TYPE.SNAKE);
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
