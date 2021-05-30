package com.lpoo.fallout.model.wander.element;

import com.lpoo.fallout.model.wander.Position;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.Positive;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

public class VaultBoyTest {

    @Property
    void testExperienceGain(@ForAll @Positive Integer enemyLevel) {
        VaultBoy vaultBoy = new VaultBoy(Mockito.any(Position.class));

        Integer unusedLevelPoints = vaultBoy.getUnusedLevelPoints();
        System.out.println("BEFORE:" + vaultBoy.getUnusedLevelPoints());
        Assertions.assertTrue(vaultBoy.calculateExpGain(enemyLevel) > 0);
        if ((int) ((float) enemyLevel / vaultBoy.getLevel() * 50) + vaultBoy.getExpPoints() >= 100) {
            System.out.println((int) ((float) enemyLevel / vaultBoy.getLevel() * 50) + vaultBoy.getExpPoints());
            System.out.println("AFTER:" + vaultBoy.getUnusedLevelPoints());
            Assertions.assertTrue(unusedLevelPoints < vaultBoy.getUnusedLevelPoints());
        }
        Assertions.assertTrue(unusedLevelPoints <= vaultBoy.getUnusedLevelPoints());
    }

}
