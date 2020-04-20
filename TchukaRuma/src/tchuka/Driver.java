package tchuka;

import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {
		int minStones, maxStones, stonesPerHole;
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("I can play 3-hole Tchuka Ruma for any number of seeds.");
		System.out.print("What are the fewest number of stones per hole that I should try? ");
		minStones = scnr.nextInt();
		
		// I noticed a typo, however, we are to use exactly the same words.
		System.out.print("Are what is the largest number of stones per bin? ");
		maxStones = scnr.nextInt();
		scnr.close();
		System.out.println("");
		
		for (stonesPerHole = minStones; stonesPerHole <= maxStones; stonesPerHole++) {
			System.out.println("You are starting with " + stonesPerHole + " stones in each bin.");
			TchukaRuma game = new TchukaRuma(stonesPerHole);
			if(game.canYouWin() == true) {
				System.out.println("You can win the game. Use the sequence:");
				String answer = game.getOrderOfMoves();
				for(int i = 0; i < answer.length(); ++i) {
					System.out.print(answer.charAt(i));
					if(i != answer.length() - 1) {
						System.out.print(", ");
					}
				}
				System.out.println("");
			} else System.out.println("It is not possible to win the game.");
			System.out.println("");
		}
	}
}
