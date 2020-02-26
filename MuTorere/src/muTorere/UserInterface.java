/**
 * @author Simon Chu
 * @author Jerry Ngo
 */

package muTorere;

import java.util.Scanner;

/**
 * The UserInterface class is the main interface to play the game.
 *
 */

public class UserInterface {
	
	/** A "pseudo" JUnit test. 
	 *  If any of the asserts are wrong, the program will halt at that point.
	 *  If this code doesn't halt, we will print that all was well, and return true.
	 * @return true if all tests pass; halts if any test fails
	 */
	private static boolean testGameBoard() {
		assert( GameBoard.areThesePositionsConnected(0, 5) );
		assert( GameBoard.areThesePositionsConnected(3, 4) );
		assert( GameBoard.areThesePositionsConnected(4, 3) );
		assert( ! GameBoard.areThesePositionsConnected(2, 4) );
		assert( ! GameBoard.areThesePositionsConnected(7, 1) );
		assert( GameBoard.areThesePositionsConnected(1, 8) );
		assert( GameBoard.areThesePositionsConnected(8, 1) );
		System.out.println( "GameBoard.areThesePositionsConnected appears to work correctly.");
		return true;
	}

	public static void main(String[] args) {
		testGameBoard();
		
		GetPlayerNames.main(new String[0]);
		
		int moveAttempted;
		Scanner scnr = new Scanner(System.in);
		System.out.println("This program allows two people to play Mu Torere against each other, while ensursing legal moves.");
		System.out.println("The current status of the board is: ");
		System.out.println("Press 'Return' when you've entered players' names");
		scnr.hasNextLine();
		
		while(true) {
			System.out.println("Current game position:");
			System.out.println(PlayingPieces.boardToString());
			System.out.print("Your move " + PlayerTurn.getCurrentPlayerName() + " ");
			moveAttempted = scnr.nextInt();
			System.out.println("");
			if(!PlayingPieces.isLegalMove(moveAttempted)) {
				System.out.println("Illegal Move. Try again.");
			} else {
				PlayingPieces.makeMove(moveAttempted);
				if(PlayingPieces.isWon()) {
					System.out.print("Congratulation!!! " + PlayerTurn.getCurrentPlayerName() + " won the game.");
					break;
				}
				PlayerTurn.updatePlayer();
			}
		}
		scnr.close();
	}
}