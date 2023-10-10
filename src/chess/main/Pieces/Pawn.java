package chess.main.Pieces;

import chess.main.ChessMain;
import chess.main.ChessThreats;

public class Pawn {
	
	
	
	

	
    static boolean sw = true;
	public static Integer[] movesW = {0,0,0,0,0,0,0,0};
	public static Integer[] movesB = {0,0,0,0,0,0,0,0};

    public static void pawnMoves(char color,int x, int y) {
		int modifier = (color == 'B') ? -1 : 1; // if black reverses vertical direction of the pawn, because black move down 
		sw = !sw;
		try {
			String cellUp = ChessMain.chessBoard[y-(1*modifier)][x]; 
			if (cellUp.charAt(0) == ' ') { //Checks if there is a space on a cell above
				cellUp = ((cellUp.charAt(2)=='_') ? cellUp.replace('_', '*') : cellUp.replace('*', '_')); // selects and unselects free cells
				ChessMain.chessBoard[y-(1*modifier)][x] = cellUp; // returning gotten data to the cell
				// The same but for 2 cell movement at first move
				String cellUp2 = ChessMain.chessBoard[y-(2*modifier)][x];
				if ((cellUp2.charAt(0) == ' ' || y == 6) && (color == 'W')? movesW[x] == 0 : movesB[x] == 0) {
					cellUp2 = (cellUp2.charAt(2)=='_' ? cellUp2.replace('_', '*') : cellUp2.replace('*', '_'));
					ChessMain.chessBoard[y-(2*modifier)][x] = cellUp2;
				}
			}
		} catch (IndexOutOfBoundsException e) {}
		
		Integer[] sides = {-1,1};
		for (int side : sides) {
			try {
				String cellUpLeft = ChessMain.chessBoard[y-(1*modifier)][x-(1*side)];
				if (cellUpLeft.charAt(0) == 'B' || cellUpLeft.charAt(1) == 'F') {
					cellUpLeft = (cellUpLeft.charAt(2)=='_' ? cellUpLeft.replace('_', '*') : cellUpLeft.replace('*', '_'));
					ChessMain.chessBoard[y-(1*modifier)][x-(1*side)] = cellUpLeft;}
			} catch (IndexOutOfBoundsException e) {}
		}
		
		if (!sw) ChessMain.generateBoard();
	}
        
    public static void pawnThreats(char color, int x, int y) {
		int modifier = (color == 'B') ? -1 : 1; // if black reverses vertical direction of the pawn, because black move down 
    	
		Integer[] cellMove = (color == 'W') ? ChessMain.chessBoardThreatsW[y-1] : ChessMain.chessBoardThreatsB[y+1];

			if (ChessThreats.isKingCell(color, x-1, y-(1*modifier)) == 1)
				cellMove[x-1] += 1;
			if (ChessThreats.isKingCell(color, x+1, y-(1*modifier)) == 1) 
				cellMove[x+1] += 1;
		
				if (color == 'W') {
					ChessMain.chessBoardThreatsW[y-1] = cellMove;
				} else ChessMain.chessBoardThreatsB[y+1] = cellMove;
    }
		
    
}
