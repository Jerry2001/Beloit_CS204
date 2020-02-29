package musicalChair;

import java.util.*;

/**
 * @author Jerry Ngo
 * This class plays the whole musical chair game. 
 * It asks for the number of people playing the game and how many round it would drop a people.
 * Then, it creates a new linked list object, plays the game and announces the winner. 
 */

public class Driver {

	public static void main(String[] args) {
		System.out.print("How many people are plaing musical chairs? ");
		Scanner scnr = new Scanner(System.in);
		int numberOfPlayer = scnr.nextInt();
		
		System.out.print("Drop out every k-th person for k = ");
		int k = scnr.nextInt();
		
		LinkedList game = new LinkedList();
		game.sizeOfList = numberOfPlayer;
		for(int i = numberOfPlayer; i > 0; --i) {
			game.insertAtFrontofList(i);
		}
		
		while(game.sizeOfList != 1) {
			for(int i = 0; i < k - 1; ++i) game.goToNextElement();
			game.removeElement();
		}
		System.out.format("Player #%d wins the game!", game.getHeadVal());
	}
}
