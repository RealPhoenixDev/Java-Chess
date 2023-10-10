package chess.main.Pieces;

import chess.main.ChessMain;
import chess.main.ChessMain.pointer;

public class Pawn {
    
    static boolean sw = true;
    public static void PawnMoves(char color,int x, int y) {
		sw = !sw;
		if (color == 'W') { // Logic for white pawns
			try {
                String cellUp = ChessMain.chessBoard[y-1][x];
                String cellUp2 = ChessMain.chessBoard[y-2][x];
				if (cellUp.charAt(0) == ' ') { //Checks if there is a space on a cell above
					cellUp = ((cellUp.charAt(2)=='_') ? cellUp.replace('_', '*') : cellUp.replace('*', '_')); // selects and unselects free cells
					if (cellUp2.charAt(0) == ' ' || y == 6) {
						cellUp2 = (cellUp2.charAt(2)=='_' ? cellUp2.replace('_', '*') : cellUp2.replace('*', '_'));
					}
				}
			}catch (IndexOutOfBoundsException e) {}
				
			try {
                String cellUpLeft = ChessMain.chessBoard[y-1][x-1];
				if (cellUpLeft.charAt(0) == 'B' || cellUpLeft.charAt(1) == 'F') {
					cellUpLeft = (cellUpLeft.charAt(2)=='_' ? cellUpLeft.replace('_', '*') : cellUpLeft.replace('*', '_'));
					
				} 
				
			} catch (IndexOutOfBoundsException e) {}
			try {	
                String cellUpRight = ChessMain.chessBoard[y-1][x+1];
				if (cellUpRight.charAt(0) == 'B' || cellUpRight.charAt(1) == 'F') {
					cellUpRight = (cellUpRight.charAt(2)=='_' ? cellUpRight.replace('_', '*') : cellUpRight.replace('*', '_'));
					
				}
			} catch (IndexOutOfBoundsException e) {}
		} if (color == 'B') { //--------------------------------------------------------------------------
            try {
                String cellDown = ChessMain.chessBoard[y+1][x];
                String cellDown2 = ChessMain.chessBoard[y+2][x];
                if (cellDown.charAt(0) == ' ') {
                    cellDown = (cellDown.charAt(2)=='_' ? cellDown.replace('_', '*') : cellDown.replace('*', '_'));
                    if (cellDown2.charAt(0) == ' ' || y == 1) {
                        cellDown2 = (cellDown2.charAt(2)=='_' ? cellDown2.replace('_', '*') : cellDown2.replace('*', '_'));
                    }
                }
            }catch (IndexOutOfBoundsException e) {}

            try {
                String cellDownLeft = ChessMain.chessBoard[y+1][x-1];
                if (cellDownLeft.charAt(0) == 'W' || cellDownLeft.charAt(1) == 'F') {
                    cellDownLeft = (cellDownLeft.charAt(2)=='_' ? cellDownLeft.replace('_', '*') : cellDownLeft.replace('*', '_'));
                }
                
            } catch (IndexOutOfBoundsException e) {}

            try {
                String cellDownRight = ChessMain.chessBoard[y+1][x+1];
                if (cellDownRight.charAt(0) == 'W' || cellDownRight.charAt(1) == 'F') {
                    cellDownRight = (cellDownRight.charAt(2)=='_' ? cellDownRight.replace('_', '*') : cellDownRight.replace('*', '_'));
                }
            } catch (IndexOutOfBoundsException e) {}
         }
        
    
}
