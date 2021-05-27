package com.lpoo.fallout.view.renderers;

import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.wander.Position;

public class WordRenderer extends GroupRenderer<String>  {

    public WordRenderer(String model, Position position) {
        super(model, position);
    }

    @Override
    public void buildImage() {
        Integer row = getPosition().getRow();
        Integer column = getPosition().getColumn();
        Integer noWords = 0;

        for(int i = 0; i < getModel().length(); i++) {
            Character tempChar = getModel().charAt(i);
            if (tempChar.equals(' ')) {
                noWords++;
                continue;
            } else if (tempChar.equals('\n')) {
                row += 20;
                noWords = 0;
                continue;
            }
            addRenderer(new FileSpriteRenderer("characters/" + tempChar + ".txt",
                    new Position(noWords * 18 + column, row)));
            noWords++;
        }
        for (Renderer<?, LanternaGUI> renderer : getRendererList())
            renderer.buildImage();
    }
}
