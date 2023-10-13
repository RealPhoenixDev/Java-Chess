package chess.main;

import java.util.Scanner;

public class UserControl {

	public static char side = ' ';
	public static char move = ' ';

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Hello User, Enter a Starting Side");
		System.out.println("W - white, B - Black");

		while (true) {
			side = input.next().charAt(0);
			input.nextLine();

			if (side != 'B' && side != 'W') {
				System.out.println("Input is incorrect! Please Try again \n");
				continue;
			}
			break;
		}
		ChessMain.main(args);

		char move = 'W';
		while (true) {
			System.out.println("\n\n\n-------------------------------------");
			ChessMain.generateThreats();
			ChessMain.generateBoard();

			if (move == 'W') {
				System.out.println("White Moves!");
			} else
				System.out.println("Black Moves!");

			try {
				System.out.println("Select Piece");
				String cell = input.nextLine();

				System.out.println("\n\n\n-------------------------------------");

				if (side == 'B') {
					int cell_1 = Character.getNumericValue(cell.charAt(0));
					int cell_2 = cell.charAt(1) - '0';
					cell = cell_1 + Integer.toString(7 - cell_2);
				}

				int cellx = cell.charAt(0) - '0';
				int celly = cell.charAt(1) - '0';

				if (ChessMain.chessBoard[celly][cellx].charAt(0) == move) {
					ChessPieces.GetPiecePath(cellx, celly);
				} else {
					throw new Exception("Error1!");
				}

				System.out.println("Select cell to move or select the same cell to unselect it");
				String next_move = input.nextLine();

				if (side == 'B') {
					int cell_1 = next_move.charAt(0) - '0';
					int cell_2 = next_move.charAt(1) - '0';
					next_move = cell_1 + Integer.toString(7 - cell_2);
				}
				int nextMovex = next_move.charAt(0) - '0';
				int nextMovey = next_move.charAt(1) - '0';

				if (cell.equals(next_move)) {
					ChessPieces.GetPiecePath(cellx, celly);
					continue;
				} else if (ChessMain.chessBoard[nextMovey][nextMovex].charAt(2) == '*') {
					char name = ChessMain.chessBoard[celly][cellx].charAt(1);
					ChessPieces.movePiece(name, move, cellx, celly, nextMovex, nextMovey);
				} else {
					ChessPieces.GetPiecePath(cellx, celly);
					throw new Exception("Error!");
				}

			} catch (Exception e) {
				System.out.println(e);
				System.out.println("You entered incorrect cell, please try again!");
				continue;
			}

			if (move == 'W') {
				move = 'B';
			} else {
				move = 'W';
			}
		}
	}
}
