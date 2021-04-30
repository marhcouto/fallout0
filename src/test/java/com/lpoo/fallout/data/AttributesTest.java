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
    void testValidChange1() {
        Attributes attributes1 = new Attributes(5, 5, 5, 5);
        Attributes attributes2 = new Attributes(-10, -20, 10, 0);

        baseAttributes.changeAttributes(attributes1);

        Assertions.assertEquals(15, baseAttributes.getStrength());
        Assertions.assertEquals(15, baseAttributes.getAgility());
        Assertions.assertEquals(15, baseAttributes.getIntelligence());
        Assertions.assertEquals(15, baseAttributes.getLuck());

        baseAttributes.changeAttributes(attributes2);
        Assertions.assertEquals(5, baseAttributes.getStrength());
        Assertions.assertEquals(-5, baseAttributes.getAgility());
        Assertions.assertEquals(25, baseAttributes.getIntelligence());
        Assertions.assertEquals(15, baseAttributes.getLuck());
    }
}