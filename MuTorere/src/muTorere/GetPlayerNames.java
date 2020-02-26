package muTorere;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * The GetPlayerNames method creates a JFrame that asks for the two players' name.
 */

public class GetPlayerNames extends JFrame implements ActionListener{
	private JButton saveNameButton; 
	private JLabel player1Label;     
	private JLabel player2Label;     
	private JLabel title;
	private JTextField player1Filed;  
	private JTextField player2Field; 
	
	/** A "pseudo" JUnit test. 
	 *  If any of the asserts are wrong, the program will halt at that point.
	 *  If this code doesn't halt, we will print that all was well, and return true.
	 * @return true if all tests pass; halts if any test fails.
	 */
	private static boolean testGameBoard( ) {
		assert(GameBoard.areThesePositionsConnected(0, 5));
		assert(GameBoard.areThesePositionsConnected(3, 4));
		assert(GameBoard.areThesePositionsConnected(4, 3));
		assert(!GameBoard.areThesePositionsConnected(2, 4));
		assert(!GameBoard.areThesePositionsConnected(7, 1));
		assert(GameBoard.areThesePositionsConnected(1, 8));
		assert(GameBoard.areThesePositionsConnected(8, 1));
		System.out.println( "GameBoard.areThesePositionsConnected appears to work correctly.");
		return true;
	}
	
	/**
	 * Constructor to set the JFrame's layout.  
	 */
	GetPlayerNames() {
	      GridBagConstraints layoutConst = null;
	      setLayout(new GridBagLayout());

	      setTitle("Get Player Name");
	      title = new JLabel("Enter the Players' name");

	      saveNameButton = new JButton("Save");
	      saveNameButton.addActionListener(this);
	      
	      player1Label = new JLabel("Player 1");
	      player2Label = new JLabel("Player 2");
	      player2Field = new JTextField(15);
	      player2Field.setEditable(true);
	      player1Filed = new JTextField(15);
	      player1Filed.setEditable(true);
	      
	      layoutConst = new GridBagConstraints();
	      layoutConst.gridx = 0;
	      layoutConst.gridy = 0;
	      layoutConst.gridwidth = 2;
	      layoutConst.insets = new Insets(10, 10, 10, 10);
	      add(title, layoutConst);
	      
	      layoutConst = new GridBagConstraints();
	      layoutConst.gridx = 0;
	      layoutConst.gridy = 1;
	      layoutConst.gridwidth = 1;
	      layoutConst.insets = new Insets(10, 10, 10, 10);
	      add(player1Label, layoutConst);

	      layoutConst = new GridBagConstraints();
	      layoutConst.gridx = 1;
	      layoutConst.gridy = 1;
	      layoutConst.insets = new Insets(10, 10, 10, 10);
	      add(player2Field, layoutConst);

	      layoutConst = new GridBagConstraints();
	      layoutConst.gridx = 0;
	      layoutConst.gridy = 2;
	      layoutConst.insets = new Insets(10, 10, 10, 10);
	      add(player2Label, layoutConst);

	      layoutConst = new GridBagConstraints();
	      layoutConst.gridx = 1;
	      layoutConst.gridy = 2;
	      layoutConst.insets = new Insets(10, 10, 10, 10);
	      add(player1Filed, layoutConst);
	      
	      layoutConst = new GridBagConstraints();
	      layoutConst.gridx = 0;
	      layoutConst.gridy = 3;
	      layoutConst.gridwidth = 2;
	      layoutConst.insets = new Insets(10, 10, 10, 10);
	      add(saveNameButton, layoutConst);
	      
	   }

	   /**
	    *  Method is automatically called when an event 
	    *  occurs (e.g, Enter key is pressed). 
	    */
	   @Override
	   public void actionPerformed(ActionEvent event) {
	      String player1Name, player2Name;   
	      player1Name = player2Field.getText();
	      player2Name = player1Filed.getText();

	      PlayerTurn.setPlayer1(player1Name);
	      PlayerTurn.setPlayer2(player2Name);
	      PlayerTurn.getPlayersName();
	   }

	   public static void main(String[] args) {
	      GetPlayerNames myFrame = new GetPlayerNames();
	      myFrame.pack();
	      myFrame.setVisible(true);
	   }
}