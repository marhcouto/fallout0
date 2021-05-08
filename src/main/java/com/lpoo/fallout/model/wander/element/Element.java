package com.lpoo.fallout.model.wander.element;

import com.lpoo.fallout.model.wander.Position;

import java.io.Serializable;

public abstract class Element implements Serializable {
    private Position position;

    public Element(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o.getClass() != this.getClass()) return false;
        if (o == null) return false;

        Element e = (Element) o;
        return this.getPosition().equals(e.getPosition());
    }
}
