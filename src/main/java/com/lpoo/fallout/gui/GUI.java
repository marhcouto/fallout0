package com.lpoo.fallout.gui;

import com.lpoo.fallout.model.wander.Position;

import java.io.IOException;

public interface GUI<T> {
    void draw() throws IOException;
    void placeDrawable(T drawable, Position position);
    ACTION getAction() throws IOException;

    enum ACTION {UP, DOWN, LEFT, RIGHT, QUIT, UTIL_E, UTIL2, UTIL3, NONE, ENTER}
}
