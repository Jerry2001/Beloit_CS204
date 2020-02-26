package muTorere;

/**
 * The PlayingPieces class know the current positions of all the pieces
 *  , and checks if a move is legal, makes move and updates the board.
 */

public class PlayingPieces {
	public static final int GAME_SIZE = 9;
	private static int step = 0;
	private static int[] boardPosition = {2, 0, 0, 0, 0, 1, 1, 1, 1};
	
	/**
	 * It returns a string of current board layout.
	 * @return returns a string of current board layout.
	 */
	public static String boardToString() {
		String board = "";
		int[] convertBoardPosition = new int[GAME_SIZE];
		for(int i = 0; i < GAME_SIZE; ++i) {
			convertBoardPosition[i] = boardPosition[i] + 1;
			if(convertBoardPosition[i] == 3) convertBoardPosition[i] = 0;
		}
		board += " " + convertBoardPosition[8] + " " + convertBoardPosition[1] + "\n";
		board += convertBoardPosition[7] + "   " + convertBoardPosition[2] + "\n";
		board += "  " + convertBoardPosition[0] + "\n";
		board += convertBoardPosition[6] + "   " + convertBoardPosition[3] + "\n";
		board += " " + convertBoardPosition[5] + " " + convertBoardPosition[4] + "\n";
		return board;
	}
	
	/**
	 * It checks whether a piece belongs to the current player or not.
	 * @param position the position of the piece
	 * @return returns true if the piece returns to the current player, else returns false.
	 */
	private static boolean isBelongTo(int position) {
		return (boardPosition[position] == PlayerTurn.getCurrentPlayer());
	}
	
	/**
	 * It finds the position of the blank space
	 * @return returns the position of the blank space
	 */
	private static int blankPosition() {
		for(int i = 0; i < GAME_SIZE; ++i) {
			if(boardPosition[i] == 2) return i;
		}
		return -1;
	}
	
	/**
	 * It checks whether a piece is adjacent to the blank space or not.
	 * @param position the position of the piece
	 * @return returns true if the piece returns to the current player, else returns false.
	 */
	private static boolean adjacentToBlank(int position) {
		boolean flag = false;
		int blankPosition = blankPosition();
		for(int i = 0; i < GAME_SIZE; ++i) {
			if(i == blankPosition) continue;
			flag |= (GameBoard.areThesePositionsConnected(blankPosition, i) && (i == position));
		}
		return flag;
	}
	
	/**
	 * It checks if it is legal to play a piece at the first move.
	 * @param position the position of the piece
	 * @return returns true if it is legal to play the piece at the first move, else returns false.
	 */
	private static boolean isLegalWithSpecialCase(int position) {
		int blankPosition = blankPosition();
		if(blankPosition != 0 || step != 0) return true;
		int playerBinary = PlayerTurn.getCurrentPlayer();
		boolean flag = false;
		for(int i = 0; i < GAME_SIZE; ++i) {
			if(playerBinary == boardPosition[i] || i == blankPosition) continue;
			flag |= (GameBoard.areThesePositionsConnected(i, position));
		}
		return flag;
	}
	
	/**
	 * It checks if the current player won the game.
	 * @return returns true if the current player won the game, else returns false.
	 */
	public static boolean isWon() {
		int blankPosition = blankPosition();
		int playerBinary = PlayerTurn.getCurrentPlayer();
		boolean flag = false;
		for(int i = 0; i < GAME_SIZE; ++i) {
			if(playerBinary == boardPosition[i]) continue;
			flag |= (GameBoard.areThesePositionsConnected(i, blankPosition));
		}
		return (!flag);
	}
	
	/**
	 * It checks if moving a piece is legal or not.
	 * @param position the position of the piece
	 * @return returns true if moving the piece is legal, else returns false.
	 */
	public static boolean isLegalMove(int position) {
		return (isBelongTo(position) && adjacentToBlank(position) && isLegalWithSpecialCase(position));
	}
	
	/**
	 * It updates the board's layout after making move.
	 * @param moveFrom the position of the moved piece.
	 */
	public static void makeMove(int moveFrom) {
		int blankPosition = blankPosition();
		boardPosition[blankPosition] = boardPosition[moveFrom];
		boardPosition[moveFrom] = 2;
		++step;
	}
}