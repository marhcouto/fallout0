package com.lpoo.fallout.controller.battle;

import org.jetbrains.annotations.NotNull;

public interface Observable<T>{
    void subscribe(@NotNull T newObserver);
    void unsubscribe(@NotNull T oldObserver);
}
