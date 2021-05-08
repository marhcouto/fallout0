package com.lpoo.fallout.model;

import com.lpoo.fallout.model.wander.Position;
import org.jetbrains.annotations.NotNull;

public class LanternaDrawable {
    Position position;
    private final String foregroundColor;
    private final String backgroundColor;
    private final String img;

    public LanternaDrawable(@NotNull String foregroundColor, @NotNull String backgroundColor, @NotNull String img) {
        this(new Position(0, 0), foregroundColor, backgroundColor, img);
    }

    public LanternaDrawable(@NotNull Position position, @NotNull String foregroundColor, @NotNull String backgroundColor, @NotNull String img) {
        this.foregroundColor = foregroundColor;
        this.backgroundColor = backgroundColor;
        this.img = img;
        this.position = position;
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

    public Position getPosition() {
        return position;
    }
}
