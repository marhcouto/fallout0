package com.lpoo.fallout.model.option;

import org.jetbrains.annotations.NotNull;

public abstract class Option {
    private final String description;

    public Option(@NotNull String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
