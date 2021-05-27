package com.lpoo.fallout.view.renderers;

import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.battle.BattleStats;
import com.lpoo.fallout.model.wander.Position;

public class StatusBarRenderer extends Renderer<BattleStats, LanternaGUI> {
    private HealthBarRenderer healthBarRenderer;
    private WordRenderer hpWord;
    private FrameSpriteRenderer frame;

    public StatusBarRenderer(BattleStats model, Position position) {
        super(model, position);
    }

    @Override
    public void placeElement(LanternaGUI gui, String foregroundColour, String backgroundColour) {
        healthBarRenderer.placeElement(gui, foregroundColour, backgroundColour);
        hpWord.placeElement(gui, "#FFFFFF", "#000000");
        frame.placeElement(gui, "#FFFFFF", "#000000");
    }

    @Override
    public void buildImage() {
        this.hpWord = new WordRenderer("hp", new Position(115 + getPosition().getColumn(), 20 + getPosition().getRow()));
        this.healthBarRenderer = new HealthBarRenderer(getModel().getHealthPoints(), new Position(getPosition().getColumn() + 5, getPosition().getRow() + 20));
        this.frame = new FrameSpriteRenderer(new Position(160, 36), getPosition());
        this.frame.buildImage();
        this.hpWord.buildImage();
        this.healthBarRenderer.buildImage();
    }

    public void updateHealthBar(Integer hp) {
        this.healthBarRenderer.updateHP(hp);
    }
}
