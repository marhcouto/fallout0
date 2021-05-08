package com.lpoo.fallout.model.wander;

import java.io.Serializable;
import java.util.Objects;

public class Position implements Serializable {
    private final int row;
    private final int column;

    public Position(int column, int row) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }

    public Position left() { return new Position(this.getColumn() - 1, this.getRow()); }
    public Position down() {
        return new Position(this.getColumn(), this.getRow() + 1);
    }
    public Position up() { return new Position(this.getColumn(), this.getRow() - 1); }
    public Position right() { return new Position(this.getColumn() + 1, this.getRow()); }

    public double getDist(Position right) {
        return Math.sqrt(Math.pow(this.getColumn() - right.getColumn(), 2) + Math.pow(this.getRow() - right.getRow(), 2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(row, position.row) && Objects.equals(column, position.column);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public String
    toString() {
        return "Position{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }
}
