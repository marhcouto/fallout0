package com.lpoo.fallout.controllerInBattle;

import com.lpoo.fallout.data.*;
import com.lpoo.fallout.data.Character;

public class CharacterController {
    private final Character character;
    private IngameStats stats;

    public CharacterController(Character character) {
        this.character = character;
        this.stats = new IngameStats(character);
    }

}
