package com.lpoo.fallout.view.renderers;

import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.wander.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class GroupRenderer<M> extends ImageRenderer<M> {
    private final List<ImageRenderer<?>> rendererList;

    public GroupRenderer(M model, Position position) {
        super(model, position);
        this.rendererList = new ArrayList<>();
    }

    @Override
    public void placeElement(LanternaGUI gui) {
        for (ImageRenderer<?> renderer : rendererList)
            renderer.placeElement(gui);
    }

    public List<ImageRenderer<?>> getRendererList() {
        return rendererList;
    }

    protected void addRenderer(ImageRenderer<?> renderer) {
        rendererList.add(renderer);
    }
}
