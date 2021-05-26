package com.lpoo.fallout.view.renderers;

import com.lpoo.fallout.model.wander.Position;

public class HealthBarRenderer extends SpriteRenderer<Integer> {
    private final Integer startingHP;

    public HealthBarRenderer(Integer model, Position referencePosition) {
        super(model, referencePosition);
        this.startingHP = model;
    }

    @Override
    public void buildImage() {

        // Health bar
        for (int j = 0; j < 3; j++) {
            for (int i = 3 - j; i < 105 + j; i++)
                addCharacter(new Position(i, j), '#');
        }
        addCharacter(new Position(1, 3), '#');
        addCharacter(new Position(2, 3), '#');
        for (int i = 3; i < 105; i++)
            addCharacter(new Position(i, 3), '-');
        addCharacter(new Position(105, 3), '#');
        addCharacter(new Position(106, 3), '#');
        for (int j = 4; j < 8; j++) {
            addCharacter(new Position(0, j), '#');
            addCharacter(new Position(1, j), '#');
            addCharacter(new Position(2, j), '|');
            addCharacter(new Position(105, j), '|');
            addCharacter(new Position(106, j), '#');
            addCharacter(new Position(107, j), '#');
        }

        addCharacter(new Position(1, 8), '#');
        addCharacter(new Position(2, 8), '#');
        for (int i = 3; i < 105; i++)
            addCharacter(new Position(i, 8), '-');
        addCharacter(new Position(105, 8), '#');
        addCharacter(new Position(106, 8), '#');
        for (int j = 2; j >= 0; j--) {
            for (int i = 3 - j; i < 105 + j; i++)
                addCharacter(new Position(i, 11 - j), '#');
        }
    }

    public void updateHP(Integer currentHP) {
        // Health Points
        for (int i = 4; i < currentHP / startingHP * 100 + 4 && startingHP != 0; i++) {
            addCharacter(new Position(i, 5), 'O');
            addCharacter(new Position(i, 6), 'O');
        }
    }
}
