package com.lpoo.fallout.gui;

import java.io.IOException;

public interface GUIFactory<T extends GUI> {
    T createGUI(int width, int height) throws IOException;
}
