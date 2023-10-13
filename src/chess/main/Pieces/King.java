package chess.main.Pieces;

import chess.main.ChessMain;

public class King {

    public static boolean sw = true;

    public static void kingMoves(char color, int x, int y) {
        sw = !sw;
        Integer[][] moves = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

        for (Integer[] move : moves) {
            try {
                int newx = x + move[0];
                int newy = y + move[1];

                String cell = ChessMain.chessBoard[newy][newx];
                int cellThreat = (color == 'W') ? ChessMain.chessBoardThreatsB[newy][newx]
                        : ChessMain.chessBoardThreatsW[newy][newx];
                if (cell.charAt(0) == ' ' && cellThreat == 0) {
                    cell = (cell.charAt(2) == '_' ? cell.replace('_', '*') : cell.replace('*', '_'));
                    ChessMain.chessBoard[newy][newx] = cell;
                }
            } catch (Exception e) {
            }
        }
        if (!sw)
            ChessMain.generateBoard();
    }

}
