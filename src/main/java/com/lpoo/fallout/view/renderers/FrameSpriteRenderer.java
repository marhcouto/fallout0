package com.lpoo.fallout.view.renderers;

import com.lpoo.fallout.model.wander.Position;

public class FrameSpriteRenderer extends SpriteRenderer<Position> {


    public FrameSpriteRenderer(Position model, Position position) {
        super(model, position);
    }

    @Override
    public void buildImage() {
        // Enclosing box
        for (int i = 4; i <= model.getColumn() - 3; i++) {
            addCharacter(new Position(i, 0), '#');
            addCharacter(new Position(i, model.getRow()), '#');
        }
        for (int j = 4; j <= model.getRow() - 3; j++) {
            addCharacter(new Position(0, j), '#');
            addCharacter(new Position(model.getColumn(), j), '#');
        }
        for (int j = model.getRow() - 3, i = model.getColumn(); j <= model.getRow() && i >= model.getColumn() - 3; j++, i--) {
            addCharacter(new Position(i, j), '#');
        }
        for (int j = model.getRow() - 3, i = 0; j <= model.getRow() && i <= 3; j++, i++) {
            addCharacter(new Position(i, j), '#');
        }
        for (int j = 0, i = 3; j <= 3 && i >= 0; j++, i--) {
            addCharacter(new Position(i, j), '#');
        }
        for (int j = 0, i = model.getColumn() - 3; j <= 3 && i <= model.getColumn(); j++, i++) {
            addCharacter(new Position(i, j), '#');
        }
    }
}
