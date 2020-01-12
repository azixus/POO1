package engine.pieces;

import chess.PieceType;
import chess.PlayerColor;
import engine.Move;
import engine.MovementType;
import engine.Square;

import java.util.ArrayList;

public class King extends Piece {
    /**
     * Constructor of the King
     * @param playerColor color of the player that owns the piece
     */
    public King(PlayerColor playerColor) {
        super(playerColor);
    }

    /**
     * Override that returns a KING;
     * @return type of the piece
     */
    @Override
    public PieceType getPieceType() {
        return PieceType.KING;
    }

    /**
     * Generate a valid Move for a King
     * @param from source Square
     * @param to destination Square
     * @return a Move if possible, false otherwise.
     */
    @Override
    public Move move(Square from, Square to) {
        int deltaX = Math.abs(to.getPosX() - from.getPosX());
        int deltaY = Math.abs(to.getPosY() - from.getPosY());

        if ((deltaX == 1 && deltaY == 0) || (deltaX == 0 && deltaY == 1) || (deltaX == 1 && deltaY == 1)) {
            ArrayList<MovementType> move = new ArrayList<>();
            move.add(MovementType.MOVE);
            move.add(MovementType.ATTACK);
            return new Move(from, to, false, move);
        }

        if ((to.getPosX() - from.getPosX() == 3 && deltaY == 0)) {
            ArrayList<MovementType> move = new ArrayList<>();
            move.add(MovementType.SMALLCASTLING);
            return new Move(from, to, false, move);
        }

        if ((to.getPosX() - from.getPosX() == -4 && deltaY == 0)) {
            ArrayList<MovementType> move = new ArrayList<>();
            move.add(MovementType.BIGCASTLING);
            return new Move(from, to, false, move);
        }
        return null;
    }

    /**
     * Return the name of the piece
     * @return String containing the name
     */
    @Override
    public String toString() {
        return "King";
    }
}
