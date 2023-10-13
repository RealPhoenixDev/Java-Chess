package chess.main;

public class ChessThreats {

	
	

	public static void KingThreats(char color, int x, int y, boolean switch_) {
		// try { // UP
		// if (color=='W') {
		// ChessMain.chessBoardThreatsW[y-1][x] += 1;
		// } else ChessMain.chessBoardThreatsB[y-1][x] += 1;
		// } catch (Exception e) {}
		// try { // UP LEFT
		// if (color=='W') {
		// ChessMain.chessBoardThreatsW[y-1][x-1] += 1;
		// } else ChessMain.chessBoardThreatsB[y-1][x-1] += 1;
		// } catch (Exception e) {}
		// try { // LEFT
		// if (color=='W') {
		// ChessMain.chessBoardThreatsW[y][x-1] += 1;
		// } else ChessMain.chessBoardThreatsB[y][x-1] += 1;
		// } catch (Exception e) {}
		// try { // DOWN LEFT
		// if (color=='W') {
		// ChessMain.chessBoardThreatsW[y+1][x-1] += 1;
		// } else ChessMain.chessBoardThreatsB[y+1][x-1] += 1;
		// } catch (Exception e) {}
		// try { // DOWN
		// if (color=='W') {
		// ChessMain.chessBoardThreatsW[y+1][x] += 1;
		// } else ChessMain.chessBoardThreatsB[y+1][x] += 1;
		// } catch (Exception e) {}
		// try { // DOWN RIGHT
		// if (color=='W') {
		// ChessMain.chessBoardThreatsW[y+1][x+1] += 1;
		// } else ChessMain.chessBoardThreatsB[y+1][x+1] += 1;
		// } catch (Exception e) {}
		// try { // RIGHT
		// if (color=='W') {
		// ChessMain.chessBoardThreatsW[y][x+1] += 1;
		// } else ChessMain.chessBoardThreatsB[y][x+1] += 1;
		// } catch (Exception e) {}
		// try { // UP RIGHT
		// if (color=='W') {
		// ChessMain.chessBoardThreatsW[y-1][x+1] += 1;
		// } else ChessMain.chessBoardThreatsB[y-1][x+1] += 1;
		// } catch (Exception e) {}
	}

	public static boolean isKingCell(char color, int x, int y) {

		if (color == 'W') {
			
			if (ChessPieces.kingXb-x ==0 && ChessPieces.kingYb-y==0) {
				return true;
			} else
				return false;
		} else if (color == 'B') {
			if (x - ChessPieces.kingXw == 0 && y - ChessPieces.kingYw==0) {
				return true;
			} else
				return false;
		}
		return false;

	}

	public static boolean isKingNear(char color, int x, int y) {

		if (color == 'W') {
			
			if (Math.abs(ChessPieces.kingXb-x) <=1 && Math.abs(ChessPieces.kingYb-y)<=1) {
				return true;
			} else
				return false;
		} else if (color == 'B') {
			if (Math.abs(x - ChessPieces.kingXw)  <=1 && Math.abs(y - ChessPieces.kingYw)<=1) {
				return true;
			} else
				return false;
		}
		return false;

	}

}
