package com.lpoo.fallout.model;

import com.lpoo.fallout.model.wander.Position;
import org.jetbrains.annotations.NotNull;

public class LanternaDrawable {
    private final String foregroundColor;
    private final String backgroundColor;
    private final String img;

    public LanternaDrawable(@NotNull String foregroundColor, @NotNull String backgroundColor, @NotNull String img) {
        this.foregroundColor = foregroundColor;
        this.backgroundColor = backgroundColor;
        this.img = img;
    }

    public String getForegroundColor() {
        return foregroundColor;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public String getChar() {
        return img;
    }
}
