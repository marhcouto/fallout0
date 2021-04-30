package com.lpoo.fallout.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Attr;

import javax.management.Attribute;

import static org.junit.jupiter.api.Assertions.*;

class AttributesTest {
    private Attributes baseAttributes;

    @BeforeEach
    void setUpAttributes() {
        baseAttributes = new Attributes(10, 10, 10, 10);
    }
    @Test
    void boostAttributes() {
        Attributes newAttributes = new Attributes(10, 5, 10, 5);
        baseAttributes.boostAttributes(newAttributes);

        Assertions.assertEquals(20, baseAttributes.getStrength());
        Assertions.assertEquals(15, baseAttributes.getAgility());
        Assertions.assertEquals(20, baseAttributes.getIntelligence());
        Assertions.assertEquals(15, baseAttributes.getLuck());
    }

    @Test
    void validRemoval() {
        Attributes frontierAttributes = new Attributes(10, 10, 10, 10);
        Attributes canAttributes = new Attributes(5, 5, 5, 5);
        Attributes cantAttributes = new Attributes(15, 15, 15, 15);

        Assertions.assertTrue(baseAttributes.validRemoval(frontierAttributes));
        Assertions.assertTrue(baseAttributes.validRemoval(canAttributes));
        Assertions.assertFalse(baseAttributes.validRemoval(cantAttributes));
    }

    @Test
    void removeAttributes() {
        Attributes attributes = new Attributes(5, 5, 5, 5);

        Assertions.assertTrue(baseAttributes.removeAttributes(attributes));

        Assertions.assertEquals(5, baseAttributes.getStrength());
        Assertions.assertEquals(5, baseAttributes.getAgility());
        Assertions.assertEquals(5, baseAttributes.getIntelligence());
        Assertions.assertEquals(5, baseAttributes.getLuck());
    }
}