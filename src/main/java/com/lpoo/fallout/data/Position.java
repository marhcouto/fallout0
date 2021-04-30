package com.lpoo.fallout.data;

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

    public Position left() {
        //TODO temos de decidir se este if fica aqui ou vai para o controller
        if (this.column > 0) {
            return new Position(this.getColumn() - 1, this.getRow());
        }
        return this;
    }
}
