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
    }
}