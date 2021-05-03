package com.lpoo.fallout.model;

import java.util.Objects;

public class Position {
    private final Integer row;
    private final Integer column;

    public Position(Integer column, Integer row) {
        this.row = row;
        this.column = column;
    }

    public Integer getRow() {
        return row;
    }
    public Integer getColumn() {
        return column;
    }

    public Position left() { return new Position(this.getColumn() - 1, this.getRow()); }
    public Position down() {
        return new Position(this.getColumn(), this.getRow() + 1);
    }
    public Position up() { return new Position(this.getColumn(), this.getRow() - 1); }
    public Position right() { return new Position(this.getColumn() + 1, this.getRow()); }

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
}