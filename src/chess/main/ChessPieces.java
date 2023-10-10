package chess.main;



public class ChessPieces{
	

	static boolean sw = true;
	int king_moves_W = 8;
	int king_moves_B = 8;
	
	
	static int kingXw = 4;
	static int kingYw = 7;
	
	static int kingXb = 4;
	static int kingYb = 0;
	
	

	
	public static void Pawn(char color,int x, int y) {
		sw = !sw;
		if (color == 'W') {
			try {
				if (ChessMain.chessBoard[y-1][x].charAt(0) == ' ') {
					ChessMain.chessBoard[y-1][x] = ((ChessMain.chessBoard[y-1][x].charAt(2)=='_') ? ChessMain.chessBoard[y-1][x].replace('_', '*') : ChessMain.chessBoard[y-1][x].replace('*', '_'));
					if (ChessMain.chessBoard[y-2][x].charAt(0) == ' ' || y == 6) {
						ChessMain.chessBoard[y-2][x] = (ChessMain.chessBoard[y-2][x].charAt(2)=='_' ? ChessMain.chessBoard[y-2][x].replace('_', '*') : ChessMain.chessBoard[y-2][x].replace('*', '_'));
					}
				}
			}catch (IndexOutOfBoundsException e) {}
				
			try {
				if (ChessMain.chessBoard[y-1][x-1].charAt(0) == 'B' || ChessMain.chessBoard[y-1][x-1].charAt(1) == 'F') {
					ChessMain.chessBoard[y-1][x-1] = (ChessMain.chessBoard[y-1][x-1].charAt(2)=='_' ? ChessMain.chessBoard[y-1][x-1].replace('_', '*') : ChessMain.chessBoard[y-1][x].replace('*', '_'));
					
				} 
				
			} catch (IndexOutOfBoundsException e) {}
			try {	
				if (ChessMain.chessBoard[y-1][x+1].charAt(0) == 'B' || ChessMain.chessBoard[y-1][x+1].charAt(1) == 'F') {
					ChessMain.chessBoard[y-1][x+1] = (ChessMain.chessBoard[y-1][x+1].charAt(2)=='_' ? ChessMain.chessBoard[y-1][x+1].replace('_', '*') : ChessMain.chessBoard[y-1][x+1].replace('*', '_'));
					
				}
			} catch (IndexOutOfBoundsException e) {}
		} if (color == 'B') { //--------------------------------------------------------------------------
			try {
				if (ChessMain.chessBoard[y+1][x].charAt(0) == ' ') {
					ChessMain.chessBoard[y+1][x] = (ChessMain.chessBoard[y+1][x].charAt(2)=='_' ? ChessMain.chessBoard[y+1][x].replace('_', '*') : ChessMain.chessBoard[y+1][x].replace('*', '_'));
					if (ChessMain.chessBoard[y+2][x].charAt(0) == ' ' || y == 1) {
						ChessMain.chessBoard[y+2][x] = (ChessMain.chessBoard[y+2][x].charAt(2)=='_' ? ChessMain.chessBoard[y+2][x].replace('_', '*') : ChessMain.chessBoard[y+2][x].replace('*', '_'));
					}
				}
			}catch (IndexOutOfBoundsException e) {}
				
			try {
				if (ChessMain.chessBoard[y+1][x-1].charAt(0) == 'W' || ChessMain.chessBoard[y+1][x-1].charAt(1) == 'F') {
					ChessMain.chessBoard[y+1][x-1] = (ChessMain.chessBoard[y+1][x-1].charAt(2)=='_' ? ChessMain.chessBoard[y+1][x-1].replace('_', '*') : ChessMain.chessBoard[y+1][x-1].replace('*', '_'));} 
				
			} catch (IndexOutOfBoundsException e) {}
			try {	
				if (ChessMain.chessBoard[y+1][x+1].charAt(0) == 'W' || ChessMain.chessBoard[y+1][x+1].charAt(1) == 'F') {
					ChessMain.chessBoard[y+1][x+1] = (ChessMain.chessBoard[y+1][x+1].charAt(2)=='_' ? ChessMain.chessBoard[y+1][x+1].replace('_', '*') : ChessMain.chessBoard[y+1][x+1].replace('*', '_'));}
			} catch (IndexOutOfBoundsException e) {}
		}
		if (!sw) ChessMain.generateBoard();
	}

	
	public static void Rook(char color,int x, int y) {
		sw = !sw;
			// UP
			int ofset_up = 1;
			while (y-ofset_up >=0 && ChessMain.chessBoard[y-ofset_up][x].charAt(0) == ' ') {
				ChessMain.chessBoard[y-ofset_up][x] = (ChessMain.chessBoard[y-ofset_up][x].charAt(2)=='_' ? ChessMain.chessBoard[y-ofset_up][x].replace('_', '*') : ChessMain.chessBoard[y-ofset_up][x].replace('*', '_'));
				ofset_up++;}
			try {
				if (ChessMain.chessBoard[y-ofset_up][x].charAt(0) == ((color == 'W') ? 'B' : 'W')) {
					ChessMain.chessBoard[y-ofset_up][x] = (ChessMain.chessBoard[y-ofset_up][x].charAt(2)=='_' ? ChessMain.chessBoard[y-ofset_up][x].replace('_', '*') : ChessMain.chessBoard[y-ofset_up][x].replace('*', '_'));}
			} catch (Exception e) {}
			// LEFT 
			int ofset_left = 1;
			while (x-ofset_left >=0 && ChessMain.chessBoard[y][x-ofset_left].charAt(0) == ' ' ) {
				ChessMain.chessBoard[y][x-ofset_left] = (ChessMain.chessBoard[y][x-ofset_left].charAt(2)=='_' ? ChessMain.chessBoard[y][x-ofset_left].replace('_', '*') : ChessMain.chessBoard[y][x-ofset_left].replace('*', '_'));
				ofset_left++;}
			try {
				if (ChessMain.chessBoard[y][x-ofset_left].charAt(0) == ((color == 'W') ? 'B' : 'W')) {
					ChessMain.chessBoard[y][x-ofset_left] = (ChessMain.chessBoard[y][x-ofset_left].charAt(2)=='_' ? ChessMain.chessBoard[y][x-ofset_left].replace('_', '*') : ChessMain.chessBoard[y][x-ofset_left].replace('*', '_'));}
			} catch (Exception e) {}
			// DOWN
			int ofset_down = 1;
			while (y+ofset_down <=7 && ChessMain.chessBoard[y+ofset_down][x].charAt(0) == ' ' ) {
				ChessMain.chessBoard[y+ofset_down][x] = (ChessMain.chessBoard[y+ofset_down][x].charAt(2)=='_' ? ChessMain.chessBoard[y+ofset_down][x].replace('_', '*') : ChessMain.chessBoard[y+ofset_down][x].replace('*', '_'));
				ofset_down++;}
			try {
				if (ChessMain.chessBoard[y+ofset_down][x].charAt(0) == ((color == 'W') ? 'B' : 'W')) {
					ChessMain.chessBoard[y+ofset_down][x] = (ChessMain.chessBoard[y+ofset_down][x].charAt(2)=='_' ? ChessMain.chessBoard[y+ofset_down][x].replace('_', '*') : ChessMain.chessBoard[y+ofset_down][x].replace('*', '_'));}
			} catch (Exception e) {}
			// RIGHT
			int ofset_right = 1;
			while (x+ofset_right <=7 && ChessMain.chessBoard[y][x+ofset_right].charAt(0) == ' ' ) {
				ChessMain.chessBoard[y][x+ofset_right] = (ChessMain.chessBoard[y][x+ofset_right].charAt(2)=='_' ? ChessMain.chessBoard[y][x+ofset_right].replace('_', '*') : ChessMain.chessBoard[y][x+ofset_right].replace('*', '_'));
				ofset_right++;}
			try {
				if (ChessMain.chessBoard[y][x+ofset_right].charAt(0) == ((color == 'W') ? 'B' : 'W')) {
					ChessMain.chessBoard[y][x+ofset_right] = (ChessMain.chessBoard[y][x+ofset_right].charAt(2)=='_' ? ChessMain.chessBoard[y][x+ofset_right].replace('_', '*') : ChessMain.chessBoard[y][x+ofset_right].replace('*', '_'));}
			} catch (Exception e) {}
			if (!sw) ChessMain.generateBoard();
	}

	
	public static void Knight(char color,int x, int y) {
		sw = !sw;
			// UP
			try {
				if (ChessMain.chessBoard[y-2][x-1].charAt(0) == ' ' || ChessMain.chessBoard[y-2][x-1].charAt(0) == ((color == 'W') ? 'B' : 'W')) {
					ChessMain.chessBoard[y-2][x-1] = (ChessMain.chessBoard[y-2][x-1].charAt(2)=='_' ? ChessMain.chessBoard[y-2][x-1].replace('_', '*') : ChessMain.chessBoard[y-2][x-1].replace('*', '_'));}
			} catch (Exception e) {}
			try {
				if (ChessMain.chessBoard[y-2][x+1].charAt(0) == ' ' || ChessMain.chessBoard[y-2][x+1].charAt(0) == ((color == 'W') ? 'B' : 'W')) {
					ChessMain.chessBoard[y-2][x+1] = (ChessMain.chessBoard[y-2][x+1].charAt(2)=='_' ? ChessMain.chessBoard[y-2][x+1].replace('_', '*') : ChessMain.chessBoard[y-2][x+1].replace('*', '_'));}
			} catch (Exception e) {}
			
			// DOWN
			try {
				if (ChessMain.chessBoard[y+2][x-1].charAt(0) == ' ' || ChessMain.chessBoard[y+2][x-1].charAt(0) == ((color == 'W') ? 'B' : 'W')) {
					ChessMain.chessBoard[y+2][x-1] = (ChessMain.chessBoard[y+2][x-1].charAt(2)=='_' ? ChessMain.chessBoard[y+2][x-1].replace('_', '*') : ChessMain.chessBoard[y+2][x-1].replace('*', '_'));}
			} catch (Exception e) {}
			try {
				if (ChessMain.chessBoard[y+2][x+1].charAt(0) == ' ' || ChessMain.chessBoard[y-2][x+1].charAt(0) == ((color == 'W') ? 'B' : 'W')) {
					ChessMain.chessBoard[y+2][x+1] = (ChessMain.chessBoard[y+2][x+1].charAt(2)=='_' ? ChessMain.chessBoard[y+2][x+1].replace('_', '*') : ChessMain.chessBoard[y+2][x+1].replace('*', '_'));}
			} catch (Exception e) {}
			
			// LEFT
			try {
				if (ChessMain.chessBoard[y-1][x-2].charAt(0) == ' ' || ChessMain.chessBoard[y-1][x-2].charAt(0) == ((color == 'W') ? 'B' : 'W')) {
					ChessMain.chessBoard[y-1][x-2] = (ChessMain.chessBoard[y-1][x-2].charAt(2)=='_' ? ChessMain.chessBoard[y-1][x-2].replace('_', '*') : ChessMain.chessBoard[y-1][x-2].replace('*', '_'));}
			} catch (Exception e) {}
			try {
				if (ChessMain.chessBoard[y+1][x-2].charAt(0) == ' ' || ChessMain.chessBoard[y+1][x-2].charAt(0) == ((color == 'W') ? 'B' : 'W')) {
					ChessMain.chessBoard[y+1][x-2] = (ChessMain.chessBoard[y+1][x-2].charAt(2)=='_' ? ChessMain.chessBoard[y+1][x-2].replace('_', '*') : ChessMain.chessBoard[y+1][x-2].replace('*', '_'));}
			} catch (Exception e) {}
			
			// RIGHT
			try {
				if (ChessMain.chessBoard[y-1][x+2].charAt(0) == ' ' || ChessMain.chessBoard[y-1][x+2].charAt(0) == ((color == 'W') ? 'B' : 'W')) {
					ChessMain.chessBoard[y-1][x+2] = (ChessMain.chessBoard[y-1][x+2].charAt(2)=='_' ? ChessMain.chessBoard[y-1][x+2].replace('_', '*') : ChessMain.chessBoard[y-1][x+2].replace('*', '_'));}
			} catch (Exception e) {}
			try {
				if (ChessMain.chessBoard[y+1][x+2].charAt(0) == ' ' || ChessMain.chessBoard[y+1][x+2].charAt(0) == ((color == 'W') ? 'B' : 'W')) {
					ChessMain.chessBoard[y+1][x+2] = (ChessMain.chessBoard[y+1][x+2].charAt(2)=='_' ? ChessMain.chessBoard[y+1][x+2].replace('_', '*') : ChessMain.chessBoard[y+1][x+2].replace('*', '_'));}
			} catch (Exception e) {}
			if (!sw) ChessMain.generateBoard();
	}

	
	public static void Bishop(char color,int x, int y) {
		sw = !sw;
		// UP
		int ofset_up = 1;
		while (y-ofset_up >=0 && x-ofset_up>=0 && ChessMain.chessBoard[y-ofset_up][x-ofset_up].charAt(0) == ' ') {
			ChessMain.chessBoard[y-ofset_up][x-ofset_up] = (ChessMain.chessBoard[y-ofset_up][x-ofset_up].charAt(2)=='_' ? ChessMain.chessBoard[y-ofset_up][x-ofset_up].replace('_', '*') : ChessMain.chessBoard[y-ofset_up][x-ofset_up].replace('*', '_'));
			ofset_up++;}
		try {
			if (ChessMain.chessBoard[y-ofset_up][x-ofset_up].charAt(0) == ((color == 'W') ? 'B' : 'W')) {
				ChessMain.chessBoard[y-ofset_up][x-ofset_up] = (ChessMain.chessBoard[y-ofset_up][x-ofset_up].charAt(2)=='_' ? ChessMain.chessBoard[y-ofset_up][x-ofset_up].replace('_', '*') : ChessMain.chessBoard[y-ofset_up][x-ofset_up].replace('*', '_'));}
		} catch (Exception e) {}
		// LEFT 
		int ofset_left = 1;
		while (x-ofset_left >=0 && y+ofset_left <=7 && ChessMain.chessBoard[y+ofset_left][x-ofset_left].charAt(0) == ' ' ) {
			ChessMain.chessBoard[y+ofset_left][x-ofset_left] = (ChessMain.chessBoard[y+ofset_left][x-ofset_left].charAt(2)=='_' ? ChessMain.chessBoard[y+ofset_left][x-ofset_left].replace('_', '*') : ChessMain.chessBoard[y+ofset_left][x-ofset_left].replace('*', '_'));
			ofset_left++;}
		try {
			if (ChessMain.chessBoard[y+ofset_left][x-ofset_left].charAt(0) == ((color == 'W') ? 'B' : 'W')) {
				ChessMain.chessBoard[y+ofset_left][x-ofset_left] =(ChessMain.chessBoard[y+ofset_left][x-ofset_left].charAt(2)=='_' ? ChessMain.chessBoard[y+ofset_left][x-ofset_left].replace('_', '*') : ChessMain.chessBoard[y+ofset_left][x-ofset_left].replace('*', '_'));
			}
		} catch (Exception e) {}
		// DOWN
		int ofset_down = 1;
		while (y+ofset_down <=7 && x+ofset_down <=7 && ChessMain.chessBoard[y+ofset_down][x+ofset_down].charAt(0) == ' ' ) {
			ChessMain.chessBoard[y+ofset_down][x+ofset_down] = (ChessMain.chessBoard[y+ofset_down][x+ofset_down].charAt(2)=='_' ? ChessMain.chessBoard[y+ofset_down][x+ofset_down].replace('_', '*') : ChessMain.chessBoard[y+ofset_down][x+ofset_down].replace('*', '_'));
			ofset_down++;}
		try {
			if (ChessMain.chessBoard[y+ofset_down][x+ofset_down].charAt(0) == ((color == 'W') ? 'B' : 'W')) {
				ChessMain.chessBoard[y+ofset_down][x+ofset_down] = (ChessMain.chessBoard[y+ofset_down][x+ofset_down].charAt(2)=='_' ? ChessMain.chessBoard[y+ofset_down][x+ofset_down].replace('_', '*') : ChessMain.chessBoard[y+ofset_down][x+ofset_down].replace('*', '_'));}
		} catch (Exception e) {}
		// RIGHT
		int ofset_right = 1;
		while (x+ofset_right <=7 && y-ofset_right >=0 && ChessMain.chessBoard[y-ofset_right][x+ofset_right].charAt(0) == ' ' ) {
			ChessMain.chessBoard[y-ofset_right][x+ofset_right] = (ChessMain.chessBoard[y-ofset_right][x+ofset_right].charAt(2)=='_' ? ChessMain.chessBoard[y-ofset_right][x+ofset_right].replace('_', '*') : ChessMain.chessBoard[y-ofset_right][x+ofset_right].replace('*', '_'));
			ofset_right++;}
		try {
			if (ChessMain.chessBoard[y-ofset_right][x+ofset_right].charAt(0) == ((color == 'W') ? 'B' : 'W')) {
				ChessMain.chessBoard[y-ofset_right][x+ofset_right] = (ChessMain.chessBoard[y-ofset_right][x+ofset_right].charAt(2)=='_' ? ChessMain.chessBoard[y-ofset_right][x+ofset_right].replace('_', '*') : ChessMain.chessBoard[y-ofset_right][x+ofset_right].replace('*', '_'));}
		} catch (Exception e) {}
		if (!sw) ChessMain.generateBoard();
		
	}

	
	public static void Queen(char color,int x, int y) {
		sw = !sw;
		// UP
		int ofset_up = 1;
		while (y-ofset_up >=0 && x-ofset_up>=0 && ChessMain.chessBoard[y-ofset_up][x-ofset_up].charAt(0) == ' ') {
			ChessMain.chessBoard[y-ofset_up][x-ofset_up] = (ChessMain.chessBoard[y-ofset_up][x-ofset_up].charAt(2)=='_' ? ChessMain.chessBoard[y-ofset_up][x-ofset_up].replace('_', '*') : ChessMain.chessBoard[y-ofset_up][x-ofset_up].replace('*', '_'));
			ofset_up++;}
		try {
			if (ChessMain.chessBoard[y-ofset_up][x-ofset_up].charAt(0) == ((color == 'W') ? 'B' : 'W')) {
				ChessMain.chessBoard[y-ofset_up][x-ofset_up] = (ChessMain.chessBoard[y-ofset_up][x-ofset_up].charAt(2)=='_' ? ChessMain.chessBoard[y-ofset_up][x-ofset_up].replace('_', '*') : ChessMain.chessBoard[y-ofset_up][x-ofset_up].replace('*', '_'));}
		} catch (Exception e) {}
		// LEFT 
		int ofset_left = 1;
		while (x-ofset_left >=0 && y+ofset_left <=7 && ChessMain.chessBoard[y+ofset_left][x-ofset_left].charAt(0) == ' ' ) {
			ChessMain.chessBoard[y+ofset_left][x-ofset_left] = (ChessMain.chessBoard[y+ofset_left][x-ofset_left].charAt(2)=='_' ? ChessMain.chessBoard[y+ofset_left][x-ofset_left].replace('_', '*') : ChessMain.chessBoard[y+ofset_left][x-ofset_left].replace('*', '_'));
			ofset_left++;}
		try {
			if (ChessMain.chessBoard[y+ofset_left][x-ofset_left].charAt(0) == ((color == 'W') ? 'B' : 'W')) {
				ChessMain.chessBoard[y+ofset_left][x-ofset_left] =(ChessMain.chessBoard[y+ofset_left][x-ofset_left].charAt(2)=='_' ? ChessMain.chessBoard[y+ofset_left][x-ofset_left].replace('_', '*') : ChessMain.chessBoard[y+ofset_left][x-ofset_left].replace('*', '_'));
			}
		} catch (Exception e) {}
		// DOWN
		int ofset_down = 1;
		while (y+ofset_down <=7 && x+ofset_down <=7 && ChessMain.chessBoard[y+ofset_down][x+ofset_down].charAt(0) == ' ' ) {
			ChessMain.chessBoard[y+ofset_down][x+ofset_down] = (ChessMain.chessBoard[y+ofset_down][x+ofset_down].charAt(2)=='_' ? ChessMain.chessBoard[y+ofset_down][x+ofset_down].replace('_', '*') : ChessMain.chessBoard[y+ofset_down][x+ofset_down].replace('*', '_'));
			ofset_down++;}
		try {
			if (ChessMain.chessBoard[y+ofset_down][x+ofset_down].charAt(0) == ((color == 'W') ? 'B' : 'W')) {
				ChessMain.chessBoard[y+ofset_down][x+ofset_down] = (ChessMain.chessBoard[y+ofset_down][x+ofset_down].charAt(2)=='_' ? ChessMain.chessBoard[y+ofset_down][x+ofset_down].replace('_', '*') : ChessMain.chessBoard[y+ofset_down][x+ofset_down].replace('*', '_'));}
		} catch (Exception e) {}
		// RIGHT
		int ofset_right = 1;
		while (x+ofset_right <=7 && y-ofset_right >=0 && ChessMain.chessBoard[y-ofset_right][x+ofset_right].charAt(0) == ' ' ) {
			ChessMain.chessBoard[y-ofset_right][x+ofset_right] = (ChessMain.chessBoard[y-ofset_right][x+ofset_right].charAt(2)=='_' ? ChessMain.chessBoard[y-ofset_right][x+ofset_right].replace('_', '*') : ChessMain.chessBoard[y-ofset_right][x+ofset_right].replace('*', '_'));
			ofset_right++;}
		try {
			if (ChessMain.chessBoard[y-ofset_right][x+ofset_right].charAt(0) == ((color == 'W') ? 'B' : 'W')) {
				ChessMain.chessBoard[y-ofset_right][x+ofset_right] = (ChessMain.chessBoard[y-ofset_right][x+ofset_right].charAt(2)=='_' ? ChessMain.chessBoard[y-ofset_right][x+ofset_right].replace('_', '*') : ChessMain.chessBoard[y-ofset_right][x+ofset_right].replace('*', '_'));}
		} catch (Exception e) {}
		
		// UP
		ofset_up = 1;
		while (y-ofset_up >=0 && ChessMain.chessBoard[y-ofset_up][x].charAt(0) == ' ') {
			ChessMain.chessBoard[y-ofset_up][x] = (ChessMain.chessBoard[y-ofset_up][x].charAt(2)=='_' ? ChessMain.chessBoard[y-ofset_up][x].replace('_', '*') : ChessMain.chessBoard[y-ofset_up][x].replace('*', '_'));
			ofset_up++;}
		try {
			if (ChessMain.chessBoard[y-ofset_up][x].charAt(0) == ((color == 'W') ? 'B' : 'W')) {
				ChessMain.chessBoard[y-ofset_up][x] = (ChessMain.chessBoard[y-ofset_up][x].charAt(2)=='_' ? ChessMain.chessBoard[y-ofset_up][x].replace('_', '*') : ChessMain.chessBoard[y-ofset_up][x].replace('*', '_'));}
		} catch (Exception e) {}
		// LEFT 
		ofset_left = 1;
		while (x-ofset_left >=0 && ChessMain.chessBoard[y][x-ofset_left].charAt(0) == ' ' ) {
			ChessMain.chessBoard[y][x-ofset_left] = (ChessMain.chessBoard[y][x-ofset_left].charAt(2)=='_' ? ChessMain.chessBoard[y][x-ofset_left].replace('_', '*') : ChessMain.chessBoard[y][x-ofset_left].replace('*', '_'));
			ofset_left++;}
		try {
			if (ChessMain.chessBoard[y][x-ofset_left].charAt(0) == ((color == 'W') ? 'B' : 'W')) {
				ChessMain.chessBoard[y][x-ofset_left] = (ChessMain.chessBoard[y][x-ofset_left].charAt(2)=='_' ? ChessMain.chessBoard[y][x-ofset_left].replace('_', '*') : ChessMain.chessBoard[y][x-ofset_left].replace('*', '_'));}
		} catch (Exception e) {}
		// DOWN
		ofset_down = 1;
		while (y+ofset_down <=7 && ChessMain.chessBoard[y+ofset_down][x].charAt(0) == ' ' ) {
			ChessMain.chessBoard[y+ofset_down][x] = (ChessMain.chessBoard[y+ofset_down][x].charAt(2)=='_' ? ChessMain.chessBoard[y+ofset_down][x].replace('_', '*') : ChessMain.chessBoard[y+ofset_down][x].replace('*', '_'));
			ofset_down++;}
		try {
			if (ChessMain.chessBoard[y+ofset_down][x].charAt(0) == ((color == 'W') ? 'B' : 'W')) {
				ChessMain.chessBoard[y+ofset_down][x] = (ChessMain.chessBoard[y+ofset_down][x].charAt(2)=='_' ? ChessMain.chessBoard[y+ofset_down][x].replace('_', '*') : ChessMain.chessBoard[y+ofset_down][x].replace('*', '_'));}
		} catch (Exception e) {}
		// RIGHT
		ofset_right = 1;
		while (x+ofset_right <=7 && ChessMain.chessBoard[y][x+ofset_right].charAt(0) == ' ' ) {
			ChessMain.chessBoard[y][x+ofset_right] = (ChessMain.chessBoard[y][x+ofset_right].charAt(2)=='_' ? ChessMain.chessBoard[y][x+ofset_right].replace('_', '*') : ChessMain.chessBoard[y][x+ofset_right].replace('*', '_'));
			ofset_right++;}
		try {
			if (ChessMain.chessBoard[y][x+ofset_right].charAt(0) == ((color == 'W') ? 'B' : 'W')) {
				ChessMain.chessBoard[y][x+ofset_right] = (ChessMain.chessBoard[y][x+ofset_right].charAt(2)=='_' ? ChessMain.chessBoard[y][x+ofset_right].replace('_', '*') : ChessMain.chessBoard[y][x+ofset_right].replace('*', '_'));}
		} catch (Exception e) {}
		if (!sw) ChessMain.generateBoard();
	}

	public static void King(char color,int x, int y) {
		sw = !sw;
		try { // UP
			if (ChessMain.chessBoard[y-1][x].charAt(0) == ' ') {
				if ((color == 'W' && ChessMain.chessBoardThreatsB[y-1][x] >0) || (color== 'B' && ChessMain.chessBoardThreatsW[y-1][x] == 0)) {
					ChessMain.chessBoard[y-1][x] = ((ChessMain.chessBoard[y-1][x].charAt(2)=='_') ? ChessMain.chessBoard[y-1][x].replace('_', '*') : ChessMain.chessBoard[y-1][x].replace('*', '_'));
				}
			}
		} catch (Exception e) {}
		try { // UP RIGHT
			if (ChessMain.chessBoard[y-1][x+1].charAt(0) == ' ') {
				if ((color == 'W' && ChessMain.chessBoardThreatsB[y-1][x+1] >0) || (color== 'B' && ChessMain.chessBoardThreatsW[y-1][x+1] == 0)) {
					ChessMain.chessBoard[y-1][x+1] = ((ChessMain.chessBoard[y-1][x+1].charAt(2)=='_') ? ChessMain.chessBoard[y-1][x+1].replace('_', '*') : ChessMain.chessBoard[y-1][x+1].replace('*', '_'));
				}
			}
		} catch (Exception e) {}
		try { // RIGHT
			if (ChessMain.chessBoard[y][x+1].charAt(0) == ' ') {
				if ((color == 'W' && ChessMain.chessBoardThreatsB[y][x+1] >0) || (color== 'B' && ChessMain.chessBoardThreatsW[y][x+1] == 0)) {
					ChessMain.chessBoard[y][x+1] = ((ChessMain.chessBoard[y][x+1].charAt(2)=='_') ? ChessMain.chessBoard[y][x+1].replace('_', '*') : ChessMain.chessBoard[y][x+1].replace('*', '_'));
				}
			}
		} catch (Exception e) {}
		try { // DOWN RIGHT
			if (ChessMain.chessBoard[y+1][x+1].charAt(0) == ' ') {
				if ((color == 'W' && ChessMain.chessBoardThreatsB[y+1][x+1] >0) || (color== 'B' && ChessMain.chessBoardThreatsW[y+1][x+1] == 0)) {
					ChessMain.chessBoard[y+1][x+1] = ((ChessMain.chessBoard[y+1][x+1].charAt(2)=='_') ? ChessMain.chessBoard[y+1][x+1].replace('_', '*') : ChessMain.chessBoard[y+1][x+1].replace('*', '_'));
				}
			}
		} catch (Exception e) {}
		try { // DOWN
			if (ChessMain.chessBoard[y+1][x].charAt(0) == ' ') {
				if ((color == 'W' && ChessMain.chessBoardThreatsB[y+1][x] >0) || (color== 'B' && ChessMain.chessBoardThreatsW[y+1][x] == 0)) {
					ChessMain.chessBoard[y+1][x] = ((ChessMain.chessBoard[y+1][x].charAt(2)=='_') ? ChessMain.chessBoard[y+1][x].replace('_', '*') : ChessMain.chessBoard[y+1][x].replace('*', '_'));
				}
			}
		} catch (Exception e) {}
		try { // DOWN LEFT
			if (ChessMain.chessBoard[y+1][x-1].charAt(0) == ' ') {
				if ((color == 'W' && ChessMain.chessBoardThreatsB[y+1][x-1] >0) || (color== 'B' && ChessMain.chessBoardThreatsW[y+1][x-1] == 0)) {
					ChessMain.chessBoard[y+1][x-1] = ((ChessMain.chessBoard[y+1][x-1].charAt(2)=='_') ? ChessMain.chessBoard[y+1][x-1].replace('_', '*') : ChessMain.chessBoard[y+1][x-1].replace('*', '_'));
				}
			}
		} catch (Exception e) {}
		try { // LEFT
			if (ChessMain.chessBoard[y][x-1].charAt(0) == ' ') {
				if ((color == 'W' && ChessMain.chessBoardThreatsB[y][x-1] >0) || (color== 'B' && ChessMain.chessBoardThreatsW[y][x-1] == 0)) {
					ChessMain.chessBoard[y][x-1] = ((ChessMain.chessBoard[y][x-1].charAt(2)=='_') ? ChessMain.chessBoard[y][x-1].replace('_', '*') : ChessMain.chessBoard[y][x-1].replace('*', '_'));
				}
			}
		} catch (Exception e) {}
		try { // UP LEFT
			if (ChessMain.chessBoard[y-1][x-1].charAt(0) == ' ') {
				if ((color == 'W' && ChessMain.chessBoardThreatsB[y-1][x-1] >0) || (color== 'B' && ChessMain.chessBoardThreatsW[y-1][x-1] == 0)) {
					ChessMain.chessBoard[y-1][x-1] = ((ChessMain.chessBoard[y-1][x-1].charAt(2)=='_') ? ChessMain.chessBoard[y-1][x-1].replace('_', '*') : ChessMain.chessBoard[y-1][x-1].replace('*', '_'));
				}
			}
		} catch (Exception e) {}
		if (!sw) ChessMain.generateBoard();
	}
	
	
	public void CreatePiece(char name, char color, int x,  int y) {
		ChessMain.chessBoard[y][x] = Character.toString(color) + Character.toString(name)+"_";
	}
	
	

	
	
	public static void GetPiecePath(int x, int y) {
		char name = ChessMain.chessBoard[y][x].charAt(1);
		char color = ChessMain.chessBoard[y][x].charAt(0);
		
		
		
		
		if (name == 'P') {
			Pawn(color, x, y);
		} else if (name == 'R') {
			Rook(color,x,y);
		} else if (name == 'B') {
			Bishop(color, x, y);
		} else if (name == 'N') {
			Knight(color, x, y);
		} else if (name == 'Q') {
			Queen(color, x, y);
		} else if (name == 'K') {
			King(color, x, y);
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
			Pawn(color, x, y);
		} else if (name == 'R') {
			Rook(color,x,y);
		} else if (name == 'B') {
			Bishop(color, x, y);
		} else if (name == 'N') {
			Knight(color, x, y);
		} else if (name == 'Q') {
			Queen(color, x, y);
		} else if (name == 'K') {
			King(color, x, y);
			if (color == 'W') {
				kingXw = x;
				kingYw = y;
			} else {
				kingXb = x;
				kingYb = y;
			}
		}
		
		ChessMain.chessBoard[newy][newx] = Character.toString(color) + Character.toString(name)+"_";
		ChessMain.chessBoard[y][x] = "  _";
		System.out.println(ChessMain.chessBoard[y][x]);
		
	}
}

