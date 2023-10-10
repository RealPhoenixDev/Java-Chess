package chess.main.Pieces;

import chess.main.ChessMain;
import chess.main.ChessThreats;

public class Knight {
    static boolean sw = true;

    public static void knightMoves(char color,int x, int y) {
		sw = !sw;
			// UP

        Integer[][] moves = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};

        for (Integer[] moves_ : moves) {
            int x_ = x + moves_[0];
            int y_ = y + moves_[1];
            if (x_ > 7 || x_ < 0 || y_ > 7 || y_ < 0) {
                continue;
            }
            String cellMove = ChessMain.chessBoard[y_][x_];
            if (cellMove.charAt(0) == ((color == 'W') ? 'B' : 'W') || cellMove.charAt(0) == ' ') {
                cellMove = (cellMove.charAt(2)=='_') ? cellMove.replace('_', '*') : cellMove.replace('*', '_');
                ChessMain.chessBoard[y_][x_] = cellMove;
        }
    }
		if (!sw) ChessMain.generateBoard();	
	}



    public static void knightThreats(char color, int x, int y) {
		    Integer[][] moves = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};

        for (Integer[] moves_ : moves) {
            int x_ = x + moves_[0];
            int y_ = y + moves_[1];
            if (x_ > 7 || x_ < 0 || y_ > 7 || y_ < 0) {
                continue;
            }
            Integer cellMove = (color == 'W') ? ChessMain.chessBoardThreatsW[y_][x_] : ChessMain.chessBoardThreatsB[y_][x_];
            if (ChessThreats.isKingCell(color, x_, y_) == 1) {
                cellMove++;
                if (color == 'W') {
                    ChessMain.chessBoardThreatsW[y_][x_] += 1;
                } else ChessMain.chessBoardThreatsB[y_][x_] += 1;
            }
            
        }
    }

}
