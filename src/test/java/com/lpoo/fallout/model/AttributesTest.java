package com.lpoo.fallout.model;

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
    public void testValidChange() {
        Attributes attributes1 = new Attributes(5, 5, 5, 5);
        Attributes attributes2 = new Attributes(-10, -20, 10, 0);


        Assertions.assertDoesNotThrow(() -> baseAttributes.changeAttributes(attributes1), "An exception was thrown when it should not\n");

        Assertions.assertEquals(15, baseAttributes.getStrength());
        Assertions.assertEquals(15, baseAttributes.getAgility());
        Assertions.assertEquals(15, baseAttributes.getIntelligence());
        Assertions.assertEquals(15, baseAttributes.getLuck());

        Assertions.assertThrows(Attributes.InvalidAttributesForChangeException.class, () ->
            baseAttributes.changeAttributes(attributes2), "An exception was not thrown when it should\n");
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