package chess.main.Pieces;

import chess.main.ChessMain;
import chess.main.ChessPieces;
import chess.main.ChessThreats;

public class Pawn {
	
    static boolean sw = true;
	public static Integer[] movesW = {0,0,0,0,0,0,0,0}; //TODO: this is a stupid idea and will break if a pawn from the other column goest in front on a pawn that didnt move yet
	public static Integer[] movesB = {0,0,0,0,0,0,0,0};

    public static void pawnMoves(char color,int x, int y) {
		int modifier = (color == 'B') ? -1 : 1; // if black reverses vertical direction of the pawn, because black move down 
		sw = !sw;
		boolean piecePSCheck = (ChessMain.chessPsThreats[y][x] > 0) ? true : false;
		try {
			if (!piecePSCheck) {
				boolean check = (color=='W') ? ChessPieces.kingWCheck : ChessPieces.kingBCheck;
				String cellUp = ChessMain.chessBoard[y-(1*modifier)][x];
				Integer cellUpThreat = ChessMain.chessBoardThreats[y-(1*modifier)][x];
				System.out.println("test");
				if ((!check && cellUp.charAt(0) == ' ') || (check && cellUpThreat > 0 && cellUp.charAt(0) == ' ')) { //Checks if there is a space on a cell above
					System.out.println("test2");
					cellUp = ((cellUp.charAt(2)=='_') ? cellUp.replace('_', '*') : cellUp.replace('*', '_')); // selects and unselects free cells
					ChessMain.chessBoard[y-(1*modifier)][x] = cellUp; // returning gotten data to the cell

					// The same but for 2 cell movement at first move
					String cellUp2 = ChessMain.chessBoard[y-(2*modifier)][x];
					Integer cellUpThreat2 = ChessMain.chessBoardThreats[y-(2*modifier)][x]; 
					if (((!check && cellUp2.charAt(0) == ' ') || (check && cellUpThreat2 > 0 && cellUp2.charAt(0) == ' ')) && (color == 'W')? movesW[x] == 0 : movesB[x] == 0) {
						cellUp2 = (cellUp2.charAt(2)=='_' ? cellUp2.replace('_', '*') : cellUp2.replace('*', '_'));
						ChessMain.chessBoard[y-(2*modifier)][x] = cellUp2;}
				}}
			else{
				String cellUp = ChessMain.chessBoard[y-(1*modifier)][x];
				Integer cellUpPsThreat = ChessMain.chessPsThreats[y-(1*modifier)][x];
				if (cellUpPsThreat > 0 && cellUp.charAt(0) == ' ') { //Checks if there is a space on a cell above
				cellUp = ((cellUp.charAt(2)=='_') ? cellUp.replace('_', '*') : cellUp.replace('*', '_')); // selects and unselects free cells
				ChessMain.chessBoard[y-(1*modifier)][x] = cellUp; // returning gotten data to the cell

				// The same but for 2 cell movement at first move
				String cellUp2 = ChessMain.chessBoard[y-(2*modifier)][x];
				Integer cellUpPsThreat2 = ChessMain.chessPsThreats[y-(2*modifier)][x];
				if (cellUpPsThreat2 > 0 && (cellUp2.charAt(0)==' ') && ((color == 'W')? movesW[x] == 0 : movesB[x] == 0)) {
					System.out.println(cellUp2);
					cellUp2 = (cellUp2.charAt(2)=='_' ? cellUp2.replace('_', '*') : cellUp2.replace('*', '_'));
					ChessMain.chessBoard[y-(2*modifier)][x] = cellUp2;}
			}}
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
    	
		Integer[] cellMove = ChessMain.chessBoardThreats[y-1];

		if (ChessThreats.isKingCell(color, x-1, y-(1*modifier)))
			cellMove[x-1] += 1;
		if (ChessThreats.isKingCell(color, x+1, y-(1*modifier))) 
			cellMove[x+1] += 1;
		ChessMain.chessBoardThreats[y-1] = cellMove;
    }
    
}
