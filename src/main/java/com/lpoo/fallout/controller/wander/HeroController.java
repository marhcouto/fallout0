package com.lpoo.fallout.controller.wander;

import com.lpoo.fallout.model.Hero;
import com.lpoo.fallout.model.Position;

import static com.lpoo.fallout.gui.LanternaGUI.ACTION;

public class HeroController {
    private final Hero hero;

    public HeroController(Hero hero) {
        this.hero = hero;
    }

    public Hero getHero() {
        return hero;
    }

    public void action(ACTION act) {

        switch (act) {
            case UP: {
                this.hero.setPosition(this.goUp());
                System.out.println(this.hero.getPosition().getColumn() + " " + this.hero.getPosition().getRow());
            }
            case NONE: {
                break;
            }
            default: {
                System.out.println(this.hero.getPosition().getColumn() + " " + this.hero.getPosition().getRow());
            }
        }
    }

    private Position goUp() {
        return new Position(this.hero.getPosition().getColumn(), this.hero.getPosition().getRow() - 1);
    }
}
