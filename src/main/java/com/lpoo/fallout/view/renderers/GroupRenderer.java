package com.lpoo.fallout.view.renderers;

import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.wander.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class GroupRenderer<M> extends Renderer<M, LanternaGUI> {
    private final List<Renderer<?, LanternaGUI>> rendererList;

    public GroupRenderer(M model, Position position) {
        super(model, position);
        this.rendererList = new ArrayList<>();
    }

    @Override
    public void placeElement(LanternaGUI gui, String foregroundColour, String backgroundColour) {
        for (Renderer<?, LanternaGUI> renderer : rendererList)
            renderer.placeElement(gui, foregroundColour, backgroundColour);
    }

    public List<Renderer<?, LanternaGUI>> getRendererList() {
        return rendererList;
    }

    protected void addRenderer(Renderer<?, LanternaGUI> renderer) {
        rendererList.add(renderer);
    }
}
