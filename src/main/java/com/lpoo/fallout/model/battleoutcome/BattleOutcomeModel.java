package com.lpoo.fallout.model.battleoutcome;

import org.jetbrains.annotations.NotNull;

public class BattleOutcomeModel {
    private String message;

    public BattleOutcomeModel(@NotNull String message) {
        this.message = message;
    }

    public @NotNull String getMessage() {
        return message;
    }
}
