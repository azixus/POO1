package engine.pieces;

import chess.PlayerColor;
import engine.Board;
import engine.Square;

public class Knight extends Piece {
    public Knight(PlayerColor playerColor) {
        super(playerColor);
    }
    @Override
    public boolean hasPieceOnMouvement(Board board, int toX, int toY) {
        return false;
    }

    @Override
    public boolean move(Board board, int fromX, int fromY, int toX, int toY) {
        return false;
    }

    @Override
    public boolean attack(Board board, int fromX, int fromY, int toX, int toY) {
        return false;
    }
}
