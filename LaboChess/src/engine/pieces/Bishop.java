package engine.pieces;


import chess.PieceType;
import chess.PlayerColor;
import engine.Board;
import engine.Square;
import java.lang.Math.*;

public class Bishop extends Piece {
    public Bishop(PlayerColor playerColor) {
        super(playerColor);
    }

    public String textValue(){
        return toString();
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.BISHOP;
    }

    @Override
    public boolean hasPieceOnMouvement(Board board, int fromX, int fromY, int toX, int toY) {
        int moveX = fromX - toX;
        int moveY = fromY - toY;
        //Is on the diagonal that is up postive
        if(moveX < 0 && moveY < 0){
            for(int i = fromX + 1, j = fromY + 1; i < toX && j < toY; i++, j++){
                if(board.getPiece(i,j) != null)
                    return true;
            }
        }
        //Is on the diagonal that is down positive
        if(moveX < 0 && moveY > 0){
            for(int i = fromX + 1, j = fromY - 1; i < toX && j > toY; i++, j--){
                if(board.getPiece(i,j) != null)
                    return true;
            }
        }
        //Is on the diagonal that is up negative
        if(moveX > 0 && moveY < 0){
            for(int i = fromX - 1, j = fromY + 1; i > toX && j < toY; i--, j++){
                if(board.getPiece(i,j) != null)
                    return true;
            }
        }
        //Is on the diagonal that is down negative
        if(moveX > 0 && moveY > 0){
            for(int i = fromX - 1, j = fromY - 1; i > toX && j > toY; i--, j--){
                if(board.getPiece(i,j) != null)
                    return true;
            }
        }
        return false;
    }

    @Override
    public boolean move(Board board, int fromX, int fromY, int toX, int toY) {
        int moveX = fromX - toX;
        int moveY = fromY - toY;
        //To move in diagonal the difference between fromY and toY as to be the same as the difference between fromX and toX
        if(Math.abs(moveX) == Math.abs(moveY)) {
            return !hasPieceOnMouvement(board, fromX, fromY, toX, toY);
        }
        return false;
    }

    @Override
    public boolean attack(Board board, int fromX, int fromY, int toX, int toY) {
        if(move(board, fromX, fromY, toX, toY))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Bishop";
    }
}
