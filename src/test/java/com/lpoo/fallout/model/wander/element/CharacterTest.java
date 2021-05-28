package com.lpoo.fallout.model.wander.element;

import com.lpoo.fallout.model.wander.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CharacterTest {
    @Test
    void onePointIntersectionAttackRadius() {
        Character character1 = Mockito.mock(Character.class, Mockito.CALLS_REAL_METHODS); //Testing abstract class needs mock
        Character character2 = Mockito.mock(Character.class, Mockito.CALLS_REAL_METHODS);
        Mockito.when(character1.getPosition()).thenReturn(new Position(0, 0));
        Mockito.when(character2.getPosition()).thenReturn(new Position(10, 0));
        Mockito.when(character1.getAttackRadius()).thenReturn(5);
        Mockito.when(character2.getAttackRadius()).thenReturn(5);

        Assertions.assertTrue(character1.insideAttackRadius(character2));
    }

    @Test
    void insideAttackRadius() {
        Character character1 = Mockito.mock(Character.class, Mockito.CALLS_REAL_METHODS); //Testing abstract class needs mock
        Character character2 = Mockito.mock(Character.class, Mockito.CALLS_REAL_METHODS);
        Mockito.when(character1.getPosition()).thenReturn(new Position(0, 0));
        Mockito.when(character2.getPosition()).thenReturn(new Position(5, 0));
        Mockito.when(character1.getAttackRadius()).thenReturn(5);
        Mockito.when(character2.getAttackRadius()).thenReturn(3);

        Assertions.assertTrue(character1.insideAttackRadius(character2));
    }

    @Test
    void outsideAttackRadius() {
        Character character1 = Mockito.mock(Character.class, Mockito.CALLS_REAL_METHODS); //Testing abstract class needs mock
        Character character2 = Mockito.mock(Character.class, Mockito.CALLS_REAL_METHODS);
        Mockito.when(character1.getPosition()).thenReturn(new Position(0, 0));
        Mockito.when(character2.getPosition()).thenReturn(new Position(10, 0));
        Mockito.when(character1.getAttackRadius()).thenReturn(3);
        Mockito.when(character2.getAttackRadius()).thenReturn(3);

        Assertions.assertFalse(character1.insideAttackRadius(character2));
    }

}