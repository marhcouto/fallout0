package com.lpoo.fallout.gui;

import com.lpoo.fallout.data.Element;

public interface DrawableFactory <T extends Drawable<? extends GUI>> {
    T getDrawable(Element element);
}