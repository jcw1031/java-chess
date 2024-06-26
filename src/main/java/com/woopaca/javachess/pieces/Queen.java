package com.woopaca.javachess.pieces;

import java.util.List;

public class Queen extends Piece {

    protected Queen(Color color) {
        super(color, Type.QUEEN);
    }

    @Override
    public List<Direction> getDirections() {
        return Direction.everyDirection();
    }

}
