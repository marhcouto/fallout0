package com.lpoo.fallout.model.wander;

import com.lpoo.fallout.model.wander.element.Enemy;

import java.util.Comparator;

public class EnemyComparator implements Comparator<Enemy> {
    private Position referencePosition;

    EnemyComparator(Position referencePosition) {
        this.referencePosition = referencePosition;
    }

    @Override
    public int compare(Enemy firstEnemy, Enemy secondEnemy) {
        double firstEnemyDist = firstEnemy.getPosition().getDist(referencePosition);
        double secondEnemyDist = secondEnemy.getPosition().getDist(referencePosition);
        return Double.compare(firstEnemyDist, secondEnemyDist);
    }
}
