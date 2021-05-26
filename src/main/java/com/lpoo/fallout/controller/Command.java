package com.lpoo.fallout.controller;

public interface Command<T> {
    void activate(T requestData);
}
