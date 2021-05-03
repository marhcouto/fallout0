package com.lpoo.fallout.model;

public class Equipment {
    private final Attributes attributes;
    private final String name;

    public Equipment(String name, Attributes attributes) {
        this.attributes = attributes;
        this.name = name;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public String getName() {
        return name;
    }
}
