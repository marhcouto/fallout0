package com.lpoo.fallout.model.wander;

import com.lpoo.fallout.model.Attributes;
import com.lpoo.fallout.model.VaultBoy;
import com.lpoo.fallout.model.Position;

public class HeroCreator {


    public VaultBoy createHero() {
        Attributes attr = new Attributes(1, 1, 1, 1);
        Position pos = new Position(5, 5);
        return new VaultBoy(pos, attr);
    }
}