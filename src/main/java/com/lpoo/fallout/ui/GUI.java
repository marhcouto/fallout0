package com.lpoo.fallout.ui;

public interface GUI {
    DrawableFactory<? extends Drawable<? extends GUI>> getDrawableFactory();
    void draw();
}