package com.woopaca.javachess.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.woopaca.javachess.chess.pieces.Piece.Type;
import static com.woopaca.javachess.chess.pieces.Piece.Color;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("기물 테스트")
public class PieceTest {

    @DisplayName("색상을 갖는 기물이 생성되어야 한다.")
    @Test
    void create() {
        verifyPiece(Piece.createWhitePawn(), Color.WHITE, Type.PAWN.getWhiteRepresentation());
        verifyPiece(Piece.createBlackPawn(), Color.BLACK, Type.PAWN.getBlackRepresentation());

        verifyPiece(Piece.createWhiteKnight(), Color.WHITE, Type.KNIGHT.getWhiteRepresentation());
        verifyPiece(Piece.createBlackKnight(), Color.BLACK, Type.KNIGHT.getBlackRepresentation());

        verifyPiece(Piece.createWhiteRook(), Color.WHITE, Type.ROOK.getWhiteRepresentation());
        verifyPiece(Piece.createBlackRook(), Color.BLACK, Type.ROOK.getBlackRepresentation());

        verifyPiece(Piece.createWhiteBishop(), Color.WHITE, Type.BISHOP.getWhiteRepresentation());
        verifyPiece(Piece.createBlackBishop(), Color.BLACK, Type.BISHOP.getBlackRepresentation());

        verifyPiece(Piece.createWhiteQueen(), Color.WHITE, Type.QUEEN.getWhiteRepresentation());
        verifyPiece(Piece.createBlackQueen(), Color.BLACK, Type.QUEEN.getBlackRepresentation());

        verifyPiece(Piece.createWhiteKing(), Color.WHITE, Type.KING.getWhiteRepresentation());
        verifyPiece(Piece.createBlackKing(), Color.BLACK, Type.KING.getBlackRepresentation());
    }

    void verifyPiece(final Piece piece, final Color color, final char representation) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }

    @DisplayName("기물의 색상을 확인할 수 있다.")
    @Test
    void checkColor() {
        Piece whitePawn = Piece.createWhitePawn();
        Piece blackPawn = Piece.createBlackPawn();
        assertThat(whitePawn.isWhite()).isTrue();
        assertThat(whitePawn.isBlack()).isFalse();
        assertThat(blackPawn.isBlack()).isTrue();
        assertThat(blackPawn.isWhite()).isFalse();
    }

    @DisplayName("각 기물의 표현 문자를 조회할 수 있다.")
    @Test
    void getRepresentationPerPiece() {
        assertThat(Type.PAWN.getWhiteRepresentation()).isEqualTo('♙');
        assertThat(Type.PAWN.getBlackRepresentation()).isEqualTo('♟');
    }

    @DisplayName("색상과 타입을 지정해 기물을 생성할 수 있다.")
    @Test
    void create_piece() {
        verifyPieces(Piece.createWhitePawn(), Piece.createBlackPawn(), Type.PAWN);
        verifyPieces(Piece.createWhiteKnight(), Piece.createBlackKnight(), Type.KNIGHT);
        verifyPieces(Piece.createWhiteRook(), Piece.createBlackRook(), Type.ROOK);
        verifyPieces(Piece.createWhiteBishop(), Piece.createBlackBishop(), Type.BISHOP);
        verifyPieces(Piece.createWhiteQueen(), Piece.createBlackQueen(), Type.QUEEN);
        verifyPieces(Piece.createWhiteKing(), Piece.createBlackKing(), Type.KING);

        Piece blank = Piece.createBlank();
        assertThat(blank.isWhite()).isFalse();
        assertThat(blank.isBlack()).isFalse();
        assertThat(blank.getType()).isEqualTo(Type.NO_PIECE);
    }

    private void verifyPieces(Piece whitePiece, Piece blackPiece, Type type) {
        assertThat(whitePiece.isWhite()).isTrue();
        assertThat(whitePiece.getType()).isEqualTo(type);

        assertThat(blackPiece.isBlack()).isTrue();
        assertThat(blackPiece.getType()).isEqualTo(type);
    }

}
