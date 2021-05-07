package com.lpoo.fallout.controller.wander;

import com.lpoo.fallout.model.Position;

public interface MovingEngine {
    Position move(Position oldPosition);
}
