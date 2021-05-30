package com.lpoo.fallout.model.battle;

import com.lpoo.fallout.model.wander.Attributes;
import com.lpoo.fallout.model.wander.CharacterInfo;
import com.lpoo.fallout.model.wander.element.Character;

import net.jqwik.api.*;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

public class BattleStatsTest {

    @Property
    void testInvalidValues(@ForAll("notTooBigInt") Integer level, @ForAll("notTooBigInt") Integer strength, @ForAll("notTooBigInt") Integer damage,
                  @ForAll("notTooBigInt") Integer inteligence, @ForAll("notTooBigInt") Integer luck, @ForAll("notTooBigInt") Integer agility) {

        Character character = Mockito.mock(Character.class);
        CharacterInfo characterInfo = Mockito.mock(CharacterInfo.class);
        Attributes attributes = Mockito.mock(Attributes.class);
        Mockito.when(character.getLevel()).thenReturn(level);
        Mockito.when(characterInfo.getWeaponDamage()).thenReturn(damage);
        Mockito.when(character.getCharacterInfo()).thenReturn(characterInfo);
        Mockito.when(characterInfo.getAttributes()).thenReturn(attributes);
        Mockito.when(attributes.getAgility()).thenReturn(agility);
        Mockito.when(attributes.getIntelligence()).thenReturn(inteligence);
        Mockito.when(attributes.getLuck()).thenReturn(luck);
        Mockito.when(attributes.getStrength()).thenReturn(strength);

        BattleStats battleStats = new BattleStats(character);

        Assertions.assertTrue(battleStats.getBaseDamage() >= 0);
        Assertions.assertTrue(battleStats.getHealthPoints() >= 15);
        Assertions.assertTrue(battleStats.getCritRatio() >= 0.10);
        Assertions.assertTrue(battleStats.getDodgeChance() >= 0.15);
        Assertions.assertTrue(battleStats.getMissChance() >= 0.05);
        Assertions.assertTrue(battleStats.getMissChance() <= 0.25);
        Assertions.assertTrue(battleStats.getDodgeChance() <= 0.75);
        Assertions.assertTrue(battleStats.getCritRatio() <= 0.75);
    }

    @Provide
    Arbitrary<Integer> notTooBigInt() {
        return Arbitraries.integers().filter(n -> n < 1000 && n >= 0);
    }
}

