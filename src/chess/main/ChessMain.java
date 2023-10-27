package chess.main;

import java.util.Arrays;

public class ChessMain {

	public static String[][] chessBoard = new String[8][8];
	public static String[][] chessBoardBufffer = new String[8][8];
	public static Integer[][] chessBoardThreats = new Integer[8][8];
	public static Integer[][] chessBoardThreatsB = new Integer[8][8];

	public static Integer[][] chessPsThreats = new Integer[8][8];

	public static void main(String[] args) {
		ChessPieces chessPieces = new ChessPieces();

		// Board Creation
		for (int x = 0; x < 8; x++)
			for (int y = 0; y < 8; y++) {
				chessBoard[x][y] = "  _";
				chessBoardThreats[x][y] = 0;
				chessBoardThreatsB[x][y] = 0;
				chessPsThreats[x][y] = 0;
			}
		// Black pieces generation
		// chessPieces.CreatePiece('R', 'B', 0, 0);
		// chessPieces.CreatePiece('N', 'B', 1, 0);
		// chessPieces.CreatePiece('B', 'B', 2, 0);
		// chessPieces.CreatePiece('Q', 'B', 3, 0);
		// chessPieces.CreatePiece('K', 'B', 4, 0);
		// chessPieces.CreatePiece('B', 'B', 5, 0);
		// chessPieces.CreatePiece('N', 'B', 6, 0);
		// chessPieces.CreatePiece('R', 'B', 7, 0);
		// for (int p = 0; p < 8; p++)
		// chessPieces.CreatePiece('P', 'B', p, 1);

		// // White pieces generation
		// chessPieces.CreatePiece('R', 'W', 3, 3);
		// chessPieces.CreatePiece('N', 'W', 1, 7);
		// chessPieces.CreatePiece('B', 'W', 2, 7);
		// chessPieces.CreatePiece('Q', 'W', 3, 7);
		// chessPieces.CreatePiece('K', 'W', 4, 7);
		// chessPieces.CreatePiece('B', 'W', 5, 7);
		// chessPieces.CreatePiece('N', 'W', 6, 7);
		// chessPieces.CreatePiece('R', 'W', 7, 7);

		// for (int p = 0; p < 8; p++)
		// chessPieces.CreatePiece('P', 'W', p, 6);

		chessPieces.CreatePiece('K', 'B', 5, 7);
		chessPieces.CreatePiece('Q', 'W', 5, 3);
		chessPieces.CreatePiece('P', 'B', 5, 5);
	}

	public static void generateBoard() {
		for (int i = 0; i < 8; i++) {
			if (UserControl.side == 'W') {
				System.out.print(Arrays.toString(chessBoard[i]));
				System.out.print(Arrays.toString(chessBoardThreats[i]));
				System.out.println(Arrays.toString(chessPsThreats[i]));
			} else {
				System.out.print(Arrays.toString(chessBoard[7 - i]));
				System.out.print(Arrays.toString(chessBoardThreats[7 - i]));
				System.out.println(Arrays.toString(chessPsThreats[7 - i]));
			}
		}

	}

	public static void generateThreats() {
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				chessBoardThreats[x][y] = 0;
				chessPsThreats[x][y] = 0;
			}
		}

		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				char color = chessBoard[y][x].charAt(0);
				char name = chessBoard[y][x].charAt(1);
				if (color != UserControl.move && color != ' ') {
					switch (name) {
						case 'P':
							chess.main.Pieces.Pawn.pawnThreats(color, x, y);
							break;
						case 'R':
							chess.main.Pieces.Rook.rookThreats(color, x, y);
							break;
						case 'B':
							chess.main.Pieces.Bishop.bishopThreats(color, x, y);
							break;
						case 'N':
							chess.main.Pieces.Knight.knightThreats(color, x, y);
							break;
						case 'Q':
							chess.main.Pieces.Queen.queenThreats(color, x, y);
							break;
						case 'K':
							ChessThreats.KingThreats(color, x, y, true);
							break;
					}
				}
			}
		}
	}
}
