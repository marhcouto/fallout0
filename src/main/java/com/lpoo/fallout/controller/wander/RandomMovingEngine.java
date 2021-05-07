package com.lpoo.fallout.controller.wander;

import com.lpoo.fallout.model.Position;

import java.util.Random;

public class RandomMovingEngine implements MovingEngine {
    private Random random;

    RandomMovingEngine() {
        random = new Random();
    }

    @Override
    public Position move(Position oldPosition) {
        int pickedDirection = random.nextInt() % 4;
        switch (pickedDirection) {
            case 0: {
                return oldPosition.up();
            }
            case 1: {
                return  oldPosition.down();
            }
            case 2: {
                return oldPosition.left();
            }
            default: {
                return oldPosition.right();
            }
        }
    }
}
