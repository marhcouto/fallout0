package com.lpoo.fallout.model.levelup;

import com.lpoo.fallout.model.wander.element.VaultBoy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LevelUpModelTest {
    LevelUpModel model;

    @BeforeEach
    void setUp() {
        VaultBoy mockedVaultBoy = Mockito.mock(VaultBoy.class);
        Mockito.when(mockedVaultBoy.getUnusedLevelPoints()).thenReturn(1);

        model = new LevelUpModel(mockedVaultBoy);
    }

    @Test
    void useLevelValid() {
        model.useLevel();
        Assertions.assertEquals(1, model.getUsedLevel());
    }

    @Test
    void useLevelInvalid() {
        model.useLevel();
        model.useLevel();

        Assertions.assertEquals(1, model.getUsedLevel());
    }

    @Test
    void freeLevelValid() {
        model.useLevel();
        model.freeLevel();

        Assertions.assertEquals(0, model.getUsedLevel());
    }

    @Test
    void freeLevelInvalid() {
        model.freeLevel();
        Assertions.assertEquals(0, model.getUsedLevel());
    }
}