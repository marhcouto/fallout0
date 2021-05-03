package com.lpoo.fallout.gui;

import java.io.IOException;

public interface GUI {
    DrawableFactory<? extends Drawable<? extends GUI>> getDrawableFactory();
    void draw() throws IOException;
}