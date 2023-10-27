package chess.main.Pieces;

import chess.main.ChessMain;
import chess.main.ChessThreats;

public class Queen {
    public static boolean sw = true;

    public static void queenMoves(char color, int x, int y) {
        sw = !sw;

        // UP
        queenMovesDirection(color, x, y, 0, -1);
        // UP LEFT
        queenMovesDirection(color, x, y, -1, -1);
        // LEFT
        queenMovesDirection(color, x, y, -1, 0);
        // DOWN LEFT
        queenMovesDirection(color, x, y, -1, 1);
        // DOWN
        queenMovesDirection(color, x, y, 0, 1);
        // DOWN RIGHT
        queenMovesDirection(color, x, y, 1, 1);
        // RIGHT
        queenMovesDirection(color, x, y, 1, 0);
        // UP RIGHT
        queenMovesDirection(color, x, y, 1, -1);

        if (!sw)
            ChessMain.generateBoard();
    }

    private static void queenMovesDirection(char color, int x, int y, int xDir, int yDir) {
        int offsetx = 1 * xDir;
        int offsety = 1 * yDir;
        try {
            while (ChessMain.chessBoard[y + offsety][x + offsetx].charAt(0) == ' ') {
                String cellDir = ChessMain.chessBoard[y + offsety][x + offsetx];
                cellDir = (cellDir.charAt(2) == '_' ? cellDir.replace('_', '*') : cellDir.replace('*', '_'));
                ChessMain.chessBoard[y + offsety][x + offsetx] = cellDir;
                offsetx += 1 * Math.signum(offsetx);
                offsety += 1 * Math.signum(offsety);
            }
            String cellDir = ChessMain.chessBoard[y + offsety][x + offsetx];
            if (cellDir.charAt(0) == ((color == 'W') ? 'B' : 'W')) {
                cellDir = (cellDir.charAt(2) == '_' ? cellDir.replace('_', '*') : cellDir.replace('*', '_'));
                ChessMain.chessBoard[y + offsety][x + offsetx] = cellDir;
            }
        } catch (Exception e) {
        }
    }

    public static void queenThreats(char color, int x, int y) {
        // UP
        queenThreatsDirection(color, x, y, 0, -1);
        // UP LEFT
        queenThreatsDirection(color, x, y, -1, -1);
        // LEFT
        queenThreatsDirection(color, x, y, -1, 0);
        // DOWN LEFT
        queenThreatsDirection(color, x, y, -1, 1);
        // DOWN
        queenThreatsDirection(color, x, y, 0, 1);
        // DOWN RIGHT
        queenThreatsDirection(color, x, y, 1, 1);
        // RIGHT
        queenThreatsDirection(color, x, y, 1, 0);
        // UP RIGHT
        queenThreatsDirection(color, x, y, 1, -1);

    }

    private static void queenThreatsDirection(char color, int x, int y, int xDir, int yDir) {
        Integer[][] chessBoardBuffer = new Integer[8][8];
        int offsetx = xDir;
        int offsety = yDir;
        int skip = 2;

        for (int y1 = 0; y1 < 8; y1++) // generating buffer array, it is used for checking for king threats locally and
                                       // only pushing to main board if needed.
            for (int x1 = 0; x1 < 8; x1++)
                chessBoardBuffer[y1][x1] = 0;
        // Actual threat logic
        try {
            while (skip > 0) {
                Integer cellDir = chessBoardBuffer[y + offsety][x + offsetx];

                if (ChessMain.chessBoard[y + offsety][x + offsetx].charAt(0) == ' ') {
                    cellDir++;
                    chessBoardBuffer[y + offsety][x + offsetx] = cellDir;
                } else {
                    if (skip == 2) {
                        cellDir++;
                        chessBoardBuffer[y + offsety][x + offsetx] = cellDir;
                        if (ChessThreats.isKingCell(color, x + offsetx, y + offsety)) {
                            ChessMain.chessBoardThreats = mergeArrrays(ChessMain.chessBoardThreats,chessBoardBuffer);
                            ChessMain.chessPsThreats = mergeArrrays(ChessMain.chessPsThreats,chessBoardBuffer);
                        }
                        skip--;
                    } else if (skip == 1) {
                        if (ChessThreats.isKingCell(color, x + offsetx, y + offsety)) {
                            cellDir++;
                            chessBoardBuffer[y + offsety][x + offsetx] = cellDir;
                            ChessMain.chessPsThreats = mergeArrrays(ChessMain.chessPsThreats,chessBoardBuffer);
                        }
                        skip--;
                    }
                }
                offsetx += Math.signum(offsetx);
                offsety += Math.signum(offsety);
            }
        } catch (Exception e) {}
        try {
            for (int y1 = 0; y1 < 8; y1++)  for (int x1 = 0; x1 < 8; x1++) chessBoardBuffer[y1][x1] = 0;
            offsetx = xDir;
            offsety = yDir;
            Integer cellDir = chessBoardBuffer[y + offsety][x + offsetx];
            if (ChessThreats.isKingNear(color, x +offsetx, y + offsety)) {
                System.out.println(cellDir);
                if (ChessMain.chessBoardThreats[y + offsety][x + offsetx]==0) cellDir++;
                chessBoardBuffer[y + offsety][x + offsetx] = cellDir;
                ChessMain.chessBoardThreats = mergeArrrays(ChessMain.chessBoardThreats, chessBoardBuffer);}
            } catch (Exception e) {}
    }

    private static Integer[][] mergeArrrays(Integer[][] arr1, Integer[][] arr2) {
        Integer[][] arr3 = new Integer[arr1.length][arr1[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                arr3[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return arr3;
    }
}
