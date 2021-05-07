package com.lpoo.fallout.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import com.lpoo.fallout.model.wander.*;

public class FileWanderFactoryTest {
    private FileWanderFactory factory;

    @BeforeEach
    public void createFactory() {
        this.factory = new FileWanderFactory("arena.txt", new VaultBoy(new Position(2, 2), new Attributes(1, 2, 1, 1)));
    }

    @Test
    public void readingFileTest() {
        Assertions.assertDoesNotThrow(() -> this.factory.readFromFile(), "An exceptions was thrown when it should not");
    }
}
