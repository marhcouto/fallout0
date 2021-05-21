package com.lpoo.fallout.model.mainmenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainMenuModelTest {
    private MainMenuModel model;

    @BeforeEach
    void createModel() {
        model = new MainMenuModel();
    }

    @Test
    void testUpOnLimit() {
        model.decrementOption();
        Assertions.assertEquals(0, model.getSelectedIndex());
    }

    @Test
    void testNormalMovement() {
        model.incrementOption();
        Assertions.assertEquals(1, model.getSelectedIndex());
        model.decrementOption();
        Assertions.assertEquals(0, model.getSelectedIndex());
    }

    @Test
    void testUnderLimit() {
        for (int i = 0; i <= MainMenuModel.OPTION.values().length; i++) {
            model.incrementOption();
        }
        int optionValue = model.getSelectedIndex();
        model.incrementOption();
        Assertions.assertEquals(optionValue, model.getSelectedIndex());
    }
}