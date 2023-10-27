package chess.main;

public class ChessPieces {

	static boolean sw = true;
	int king_moves_W = 8;
	int king_moves_B = 8;

	public static int kingXw = 0;
	public static int kingYw = 0;

	public static int kingXb = 0;
	public static int kingYb = 0;

	public void CreatePiece(char name, char color, int x, int y) {
		ChessMain.chessBoard[y][x] = Character.toString(color) + Character.toString(name) + "_";

		if (name == 'K') {
			if (color == 'W') {
				kingXw = x;
				kingYw = y;
			} else {
				kingXb = x;
				kingYb = y;
			}
		}
	}

	public static void GetPiecePath(int x, int y) {
		char name = ChessMain.chessBoard[y][x].charAt(1);
		char color = ChessMain.chessBoard[y][x].charAt(0);

		if (name == 'P') {
			chess.main.Pieces.Pawn.pawnMoves(color, x, y);
		} else if (name == 'R') {
			chess.main.Pieces.Rook.rookMoves(color, x, y);
		} else if (name == 'B') {
			chess.main.Pieces.Bishop.bishopMoves(color, x, y);
		} else if (name == 'N') {
			chess.main.Pieces.Knight.knightMoves(color, x, y);
		} else if (name == 'Q') {
			chess.main.Pieces.Queen.queenMoves(color, x, y);
		} else if (name == 'K') {
			chess.main.Pieces.King.kingMoves(color, x, y);
			if (color == 'W') {
				kingXw = x;
				kingYw = y;
			} else {
				kingXb = x;
				kingYb = y;
			}
		}

	}

	public static void movePiece(char name, char color, int x, int y, int newx, int newy) {

		if (name == 'P') {
			chess.main.Pieces.Pawn.pawnMoves(color, x, y);
			if (color == 'W')
				chess.main.Pieces.Pawn.movesW[x]++;
			else
				chess.main.Pieces.Pawn.movesB[x]++;
		} else if (name == 'R') {
			chess.main.Pieces.Rook.rookMoves(color, x, y);
		} else if (name == 'B') {
			chess.main.Pieces.Bishop.bishopMoves(color, x, y);
		} else if (name == 'N') {
			chess.main.Pieces.Knight.knightMoves(color, x, y);
		} else if (name == 'Q') {
			chess.main.Pieces.Queen.queenMoves(color, x, y);
		} else if (name == 'K') {
			chess.main.Pieces.King.kingMoves(color, x, y);
			if (color == 'W') {
				kingXw = newx;
				kingYw = newy;
			} else {
				kingXb = newx;
				kingYb = newy;
			}
		}

		ChessMain.chessBoard[newy][newx] = Character.toString(color) + Character.toString(name) + "_";
		ChessMain.chessBoard[y][x] = "  _";
		System.out.println(ChessMain.chessBoard[y][x]);

	}

}
