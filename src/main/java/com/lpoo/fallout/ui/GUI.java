package com.lpoo.fallout.ui;

import java.io.IOException;

public interface GUI {
    DrawableFactory<? extends Drawable<? extends GUI>> getDrawableFactory();
    void draw() throws IOException;
}