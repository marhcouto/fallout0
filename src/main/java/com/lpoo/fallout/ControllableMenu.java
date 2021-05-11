package com.lpoo.fallout;

import com.lpoo.fallout.model.Option;

public interface ControllableMenu <T> {
    void selectUp();
    void selectDown();
    Option<T> getSelectedOption();
    Integer getSelectedOptionIndex();
}
