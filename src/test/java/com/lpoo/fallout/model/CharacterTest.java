package com.lpoo.fallout.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CharacterTest {

    @Test
    public void canUseWeaponTest() {
        Character c = new Character(new Position(1, 2), new Attributes(2, 2, 3, 4), 1);
        Weapon w1 = new Weapon(20, "Adamant sword", new Attributes(2, 2, 2, 2));
        Weapon w2 = new Weapon(10, "Baboom", new Attributes(-1, 1, 1, 5));

        Assertions.assertTrue(c.canUseWeapon(w1));
        Assertions.assertFalse(c.canUseWeapon(w2));

    }
}