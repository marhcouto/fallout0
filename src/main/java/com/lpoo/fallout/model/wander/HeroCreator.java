package com.lpoo.fallout.model.wander;

import com.lpoo.fallout.model.wander.element.VaultBoy;

public class HeroCreator {


    public VaultBoy createHero() {
        Position pos = new Position(5, 5);
        return new VaultBoy(pos);
    }
}