package chess.main.Pieces;

import chess.main.ChessMain;
import chess.main.ChessMain.pointer;

public class Pawn {
	
	
	public static String[][] chessBoardBuffer = new String[8][8];
	

	
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
		} else if (color == 'B') { //--------------------------------------------------------------------------
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
        
    public static void PawnThreats(char color, int x, int y, boolean switch_) {
    	for (int y1 = 0; y1 < 8; y1++) {
			for (int x1 = 0;x1<8;x1++) {
				chessBoardBuffer[y1][x1] = "";
			}
		}
		if (color == 'W') {
			try {
				ChessMain.chessBoardThreatsW[y-1][x-1] += 1;}
			catch (Exception e) {}
			try {
				ChessMain.chessBoardThreatsW[y-1][x+1] += 1;
			} catch (Exception e) {}
		} else if (color == 'B') {
			try {
				ChessMain.chessBoardThreatsB[y+1][x-1] += 1;}
			catch (Exception e) {}
			try {
				ChessMain.chessBoardThreatsB[y+1][x+1] += 1;
			} catch (Exception e) {}
		}
    }
		
    
}
