package com.lpoo.fallout.model.wander;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AttributesTest {
    private Attributes baseAttributes;

    @BeforeEach
    public void setUpAttributes() {
        baseAttributes = new Attributes(10, 10, 10, 10);
    }

    @Test
    public void testGreaterThanAttributes() {
        baseAttributes.setLuck(0);
        Attributes a1 = new Attributes(1, 2, 3, 15);
        Attributes a2 = new Attributes(1, 2, 10, -15);

        Assertions.assertTrue(baseAttributes.greaterThan(a2));
        Assertions.assertFalse(baseAttributes.greaterThan(a1));
    }
}