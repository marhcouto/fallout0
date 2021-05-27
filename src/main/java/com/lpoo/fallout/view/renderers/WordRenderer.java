package com.lpoo.fallout.view.renderers;

import com.lpoo.fallout.model.wander.Position;

public class WordRenderer extends GroupRenderer<String>  {

    public WordRenderer(String model, Position position) {
        super(model, position);
    }

    @Override
    public void buildImage() {
        for(int i = 0; i < getModel().length(); i++) {
            Character tempChar = getModel().charAt(i);
            addRenderer(new FileSpriteRenderer("characters/" + tempChar.toString() + ".txt",
                    new Position(i * 20 + getPosition().getColumn(), getPosition().getRow())));
            getRendererList().get(i).buildImage();
        }
    }
}
