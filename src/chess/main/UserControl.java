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
			} else if (move == 'B') {
				System.out.println("Black Moves!");
			}

			try {
				System.out.println("Select Piece");
				String cell = input.nextLine();

				System.out.println("\n\n\n-------------------------------------");

				if (side == 'B') {
					int cell_1 = Character.getNumericValue(cell.charAt(0));
					int cell_2 = Character.getNumericValue(cell.charAt(1));
					cell = cell_1 + Integer.toString(7 - cell_2);
				}

				if (ChessMain.chessBoard[Integer.parseInt(Character.toString(cell.charAt(1)))][Integer
						.parseInt(Character.toString(cell.charAt(0)))].charAt(0) == move) {
					ChessPieces.GetPiecePath(Integer.parseInt(Character.toString(cell.charAt(0))),
							Integer.parseInt(Character.toString(cell.charAt(1))));
				} else {
					throw new Exception("Error1!");
				}

				System.out.println("Select cell to move or select the same cell to unselect it");
				String next_move = input.nextLine();

				if (side == 'B') {
					int cell_1 = Character.getNumericValue(next_move.charAt(0));
					int cell_2 = Character.getNumericValue(next_move.charAt(1));
					next_move = cell_1 + Integer.toString(7 - cell_2);
				}

				if (cell.equals(next_move)) {
					ChessPieces.GetPiecePath(Integer.parseInt(Character.toString(cell.charAt(0))),
							Integer.parseInt(Character.toString(cell.charAt(1))));
					continue;
				} else if (ChessMain.chessBoard[Integer.parseInt(Character.toString(next_move.charAt(1)))][Integer
						.parseInt(Character.toString(next_move.charAt(0)))].charAt(2) == '*') {
					char name = ChessMain.chessBoard[Integer.parseInt(Character.toString(cell.charAt(1)))][Integer
							.parseInt(Character.toString(cell.charAt(0)))].charAt(1);
					ChessPieces.movePiece(name, move, Character.getNumericValue(cell.charAt(0)),
							Character.getNumericValue(cell.charAt(1)),
							Character.getNumericValue(next_move.charAt(0)),
							Character.getNumericValue(next_move.charAt(1)));
				} else {
					ChessPieces.GetPiecePath(Integer.parseInt(Character.toString(cell.charAt(0))),
							Integer.parseInt(Character.toString(cell.charAt(1))));
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
