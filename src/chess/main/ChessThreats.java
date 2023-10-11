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

	public static Integer isKingCell(char color, int x, int y) {

		if (color == 'W') {
			if (x == ChessPieces.kingXb && y == ChessPieces.kingYb) {
				return 1;
			} else
				return 0;
		} else if (color == 'B') {
			if (x == ChessPieces.kingXw && y == ChessPieces.kingYw) {
				return 1;
			} else
				return 0;
		}
		return 0;

	}

}
