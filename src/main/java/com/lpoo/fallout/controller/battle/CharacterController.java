package com.lpoo.fallout.controller.battle;

import com.lpoo.fallout.model.*;
import com.lpoo.fallout.model.Character;

public class CharacterController {
    private final Character character;
    private InGameStats stats;

    public CharacterController(Character character) {
        this.character = character;
        this.stats = new InGameStats(character);
    }

}
