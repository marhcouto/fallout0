package com.lpoo.fallout.gui;

import com.lpoo.fallout.model.Element;

public interface DrawableFactory <T extends Drawable<? extends GUI>> {
    T getDrawable(Element element);
}