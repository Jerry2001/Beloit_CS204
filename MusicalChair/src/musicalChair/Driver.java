package musicalChair;

import java.util.*;

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
