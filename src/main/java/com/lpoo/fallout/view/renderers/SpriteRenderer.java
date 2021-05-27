package com.lpoo.fallout.view.renderers;

import com.lpoo.fallout.gui.GUI;
import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.LanternaDrawable;
import com.lpoo.fallout.model.wander.Position;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class SpriteRenderer<M> extends Renderer<M, LanternaGUI> {
    private final Map<Position, Character> image;

    public SpriteRenderer(M model, Position position) {
        super(model, position);
        this.image = new HashMap<>();
    }

    @Override
    public void placeElement(LanternaGUI gui, String foregroundColour, String backgroundColour) {
        for (Map.Entry<Position, Character> pixel : image.entrySet()) {
            Position actualPosition = new Position(pixel.getKey().getColumn() + getPosition().getColumn(), pixel.getKey().getRow() + getPosition().getRow());
            gui.placeDrawable(new LanternaDrawable(foregroundColour, backgroundColour, pixel.getValue().toString()), actualPosition);
        }
    }

    public Map<Position, Character> getImage() {
        return image;
    }

    protected void addCharacter(Position position, Character character) {
        image.put(position, character);
    }

    protected void removeCharacter(Position position) {
        image.remove(position);
    }
}
