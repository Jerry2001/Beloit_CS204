package muTorere;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * The PlayerTurn class keeps track of whose turn it is right now
 * and stores the players' name.
 */

public class PlayerTurn {
	public static String player1 = "Player 1";
	public static String player2 = "Player 2";
	private static int currentPlayer = 0;
	
	/**
	 * It returns the integral form of current player name.
	 * @return returns the integral form of current player name.
	 */
	public static int getCurrentPlayer() {
		return currentPlayer;
	}
	
	/**
	 * It returns a string of the current player name.
	 * @return returns a string of the current player name.
	 */
	public static String getCurrentPlayerName() {
		return (currentPlayer == 0) ? player1 : player2;
	}
	
	/**
	 * Create a JFrame that shows the pieces' color of each player.
	 */
	public static void getPlayersName() {     
	      JFrame topFrame = null;                
	      JLabel piecesColorLabel = null;               
	      GridBagConstraints layoutConst = null;
	      
	      piecesColorLabel = new JLabel(player1 + " has the red pieces, " + player2 + " has the black pieces.");
	      
	      topFrame = new JFrame("Mu Torere");
	      topFrame.setLayout(new GridBagLayout());
	      
	      layoutConst = new GridBagConstraints();
	      layoutConst.gridx = 0;
	      layoutConst.gridy = 0;
	      layoutConst.insets = new Insets(10, 10, 10, 10);
	      
	      topFrame.add(piecesColorLabel, layoutConst);
	      topFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      topFrame.pack();
	      topFrame.setVisible(true);
	}
	
	/**
	 * Update the current player.
	 */
	public static void updatePlayer() {
		currentPlayer ^= 1;
	}
	
	/**
	 * Set the player1's name.
	 * @param name the player1's name
	 */
	public static void setPlayer1(String name) {
		player1 = name;
	}
	
	/**
	 * Set the player2's name.
	 * @param name the player2's name
	 */
	public static void setPlayer2(String name) {
		player2 = name;
	}
}