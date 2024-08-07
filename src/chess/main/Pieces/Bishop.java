package chess.main.Pieces;

import chess.main.ChessMain;
import chess.main.ChessThreats;

public class Bishop {
    public static boolean sw = true;

    public static void bishopMoves(char color, int x, int y) {
        sw = !sw;

        // UP LEFT
        bishopMovesDirections(color, x, y, -1, -1);
        // DOWN LEFT
        bishopMovesDirections(color, x, y, -1, 1);
        // DOWN RIGHT
        bishopMovesDirections(color, x, y, 1, 1);
        // UP RIGHT
        bishopMovesDirections(color, x, y, 1, -1);

        if (!sw)
            ChessMain.generateBoard();
    }

    private static void bishopMovesDirections(char color, int x, int y, int xDir, int yDir) {
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

    public static void bishopThreats(char color, int x, int y) {
        // UP LEFT
        bishopThreatsDirection(color, x, y, -1, -1);
        // DOWN LEFT
        bishopThreatsDirection(color, x, y, -1, 1);
        // DOWN RIGHT
        bishopThreatsDirection(color, x, y, 1, 1);
        // UP RIGHT
        bishopThreatsDirection(color, x, y, 1, -1);

    }

    private static void bishopThreatsDirection(char color, int x, int y, int xDir, int yDir) {
        Integer[][] chessBoardBuffer = new Integer[8][8];
        int offsetx = 1 * xDir;
        int offsety = 1 * yDir;
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
                            if (color == 'W') {
                                ChessMain.chessBoardThreatsW = mergeArrrays(ChessMain.chessBoardThreatsW,
                                        chessBoardBuffer);
                                ChessMain.chessPsThreatsW = mergeArrrays(ChessMain.chessPsThreatsW,
                                        chessBoardBuffer);
                            } else {
                                ChessMain.chessBoardThreatsB = mergeArrrays(ChessMain.chessBoardThreatsB,
                                        chessBoardBuffer);
                                ChessMain.chessPsThreatsB = mergeArrrays(ChessMain.chessPsThreatsB,
                                        chessBoardBuffer);

                            }
                            break;
                        }
                        skip--;
                    } else if (skip == 1) {
                        if (ChessThreats.isKingCell(color, x + offsetx, y + offsety)){
                            cellDir++;
                            chessBoardBuffer[y + offsety][x + offsetx] = cellDir;
                            if (color == 'W') {
                                ChessMain.chessPsThreatsW = mergeArrrays(ChessMain.chessPsThreatsW,
                                        chessBoardBuffer);
                            } else {
                                ChessMain.chessPsThreatsB = mergeArrrays(ChessMain.chessPsThreatsB,
                                        chessBoardBuffer);
                            }
                            break;
                        }
                        skip--;
                    }
                }
                offsetx += 1 * Math.signum(offsetx);
                offsety += 1 * Math.signum(offsety);
            } 
        }catch (Exception e) {}

        try {
            for (int y1 = 0; y1 < 8; y1++)  for (int x1 = 0; x1 < 8; x1++) chessBoardBuffer[y1][x1] = 0;
            offsetx = xDir;
            offsety = yDir;
            Integer cellDir = chessBoardBuffer[y + offsety][x + offsetx];
            if (ChessThreats.isKingNear(color, x +offsetx, y + offsety)) {
                cellDir++;
                chessBoardBuffer[y + offsety][x + offsetx] = cellDir;
                if (color == 'W') {
                    ChessMain.chessBoardThreatsW = mergeArrrays(ChessMain.chessBoardThreatsW, chessBoardBuffer);
                } else ChessMain.chessBoardThreatsB = mergeArrrays(ChessMain.chessBoardThreatsB, chessBoardBuffer);
                } 
            } catch (Exception e) {}

            
    }

    private static Integer[][] mergeArrrays(Integer[][] arr1, Integer[][] arr2) {
        Integer[][] arr3 = new Integer[arr1.length][arr1[0].length];
        for (int i = 0; i < arr1.length; i++)
            for (int j = 0; j < arr1[0].length; j++)
                arr3[i][j] = arr1[i][j] + arr2[i][j];
        return arr3;
    }
}
