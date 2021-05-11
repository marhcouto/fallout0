package com.lpoo.fallout.model;

public class Option<T> {
    private final String name;
    private T value;

    public Option(String name, T value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public T getValue() {
        return value;
    }

    public Option<T> setValue(T value) {
        this.value = value;
        return this;
    }
}
