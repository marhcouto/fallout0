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
        Integer resultExp = (int) ((float) enemyLevel / vaultBoy.getLevel() * 50) + vaultBoy.getExpPoints();
        Assertions.assertTrue(vaultBoy.calculateExpGain(enemyLevel) > 0);
        if ( resultExp >= 100)
            Assertions.assertTrue(unusedLevelPoints < vaultBoy.getUnusedLevelPoints());
        Assertions.assertTrue(unusedLevelPoints <= vaultBoy.getUnusedLevelPoints());

    }
}
