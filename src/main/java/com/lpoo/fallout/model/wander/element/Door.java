package com.lpoo.fallout.model.wander.element;

import com.lpoo.fallout.model.wander.Position;

public class Door extends Element {
    private final String arenaFileName;
    private final Position correspondingPosition;

    public Door(Position position, String arenaFileName, Position correspondingPosition) {
        super(position);
        this.correspondingPosition = correspondingPosition;
        this.arenaFileName = arenaFileName;
    }

    public String getArenaFileName() {
        return arenaFileName;
    }

    public Position getCorrespondingPosition() {
        return correspondingPosition;
    }
}
