package com.lpoo.fallout.model.wander;

import com.lpoo.fallout.model.wander.element.VaultBoy;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class WanderModel {
    private final VaultBoy vaultBoy;
    private Arena arena;

    public WanderModel(@NotNull VaultBoy vaultBoy, @NotNull Arena arena) {
        this.vaultBoy = vaultBoy;
        this.arena = arena;
    }

    public VaultBoy getVaultBoy() {
        return vaultBoy;
    }

    public Arena getArena() {
        return arena;
    }

    public void setArena(Arena arena) {
        this.arena = arena;
    }

}
