package com.lpoo.fallout.model.option;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class OptionMenuModelTest {
    public enum OPTION {TEST1, TEST2}
    OptionMenuModel optionMenuModel;

    @BeforeEach
    void setUp() {
        optionMenuModel = Mockito.mock(OptionMenuModel.class, Mockito.CALLS_REAL_METHODS);
        Mockito.when(optionMenuModel.getNumberOfOptions()).thenReturn(OPTION.values().length);
        Mockito.when(optionMenuModel.getLowerLimit()).thenReturn(0);
    }

    @Test
    void increaseSelectedIdxValid() {
        optionMenuModel.increaseSelectedIdx();
        Assertions.assertEquals(1, optionMenuModel.getSelectedIdx());
    }

    @Test
    void increaseSelectedIdxPastEnd() {
        optionMenuModel.increaseSelectedIdx();
        optionMenuModel.increaseSelectedIdx();
        Assertions.assertEquals(1, optionMenuModel.getSelectedIdx());
    }

    @Test
    void decreaseSelectedIdxPastBegin() {
        optionMenuModel.decreaseSelectedIdx();
        Assertions.assertEquals(0, optionMenuModel.getSelectedIdx());
    }

    @Test
    void normalWork() {
        optionMenuModel.increaseSelectedIdx();
        Assertions.assertEquals(1, optionMenuModel.getSelectedIdx());

        optionMenuModel.decreaseSelectedIdx();
        Assertions.assertEquals(0, optionMenuModel.getSelectedIdx());
    }
}