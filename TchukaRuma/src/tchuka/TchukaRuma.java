package tchuka;
import java.util.Arrays;

public class TchukaRuma {
	public static final int THE_RUMA = 2;
	private int[] seedsInBins; // Bin 0 is on the left
	private int seedsInHand;
	private StringBuilder orderOfMoves;
	
	/**
	 * TchukaRuma constuctor that takes stonesPerBin and create a new TchukaRuma object with number of stones in hole 0 and 1 equal to stonesPerBin.
	 * @param stonesPerBin
	 */
	public TchukaRuma( int stonesPerBin ) {
		orderOfMoves = new StringBuilder();
		seedsInBins = new int[3];
		seedsInBins[0] = seedsInBins[1] = stonesPerBin;
		seedsInBins[2] = 0;
	}
	
	/**
	 * Create a copy of a TchukaRuma game state. orderOfMoves from two games point to a same object.
	 * @param previousGame the TchukaRuma game to copy 
	 */
	public TchukaRuma(TchukaRuma previousGame) {
		seedsInBins = new int[3];
		orderOfMoves = previousGame.orderOfMoves;
		seedsInBins[0] = previousGame.seedsInBins[0];
		seedsInBins[1] = previousGame.seedsInBins[1];
	}
	
	// For debugging & testing
	public String toString( ) {
		return Arrays.toString(seedsInBins);
	}
	
	/**
	 * Returns a string which is the correct order to play the game.
	 * @return a string which is the correct order to play the game.
	 */
	public String getOrderOfMoves() {
		orderOfMoves = orderOfMoves.reverse();
		return orderOfMoves.toString();
	}

	/**
	 * Returns the bin you placed your last seed
	 * @param currentBin the bin to take all the seed and distribute them 
	 * @return Returns the bin you placed your last seed
	 */
	public int sowOneRound( int currentBin ) {
		seedsInHand = seedsInBins[currentBin];
		seedsInBins[currentBin] = 0;
		while (seedsInHand > 0) {
			++currentBin;
			currentBin %= 3;
			++seedsInBins[currentBin];
			--seedsInHand;
		}
		return currentBin;
	}
	
	/**
	 * Multiple sowings. Returns true if your last seed was placed in the Ruma; false otherwise.
	 * @param binToPlayFrom the bin to start playing from
	 * @return true if your last seed was placed in the Ruma; false otherwise.
	 */
	public boolean makeOneMove( int binToPlayFrom ) {
		int lastBin = sowOneRound(binToPlayFrom);
		if(lastBin == THE_RUMA) return true;
		if(seedsInBins[lastBin] > 1) {
			return makeOneMove(lastBin);
		}
		else return false;
	}
	
	/**
	 * Make one move from a bin then call a "CanYouWin" from the new configuration.
	 * @param whichBin the bin to start playing from
	 * @return true if you could win from playing from whichBin, else returns false.
	 */
	public boolean canYouWinPlayingFromBin( int whichBin ) {
		TchukaRuma nextStateGame = new TchukaRuma(this);
		if(nextStateGame.makeOneMove(whichBin)) return nextStateGame.canYouWin();
		else return false;
	}
	
	/**
	 * Check to see if you’ve *just* won. Otherwise, call canYouWinPlayingFrom() for both 0 and 1
	 * @return true if you could win from this configuration, else returns false.
	 */
	public boolean canYouWin( ) {
		if((seedsInBins[0] | seedsInBins[1]) == 0) {
			return true;
		}
		if(canYouWinPlayingFromBin(0)) {
			orderOfMoves.append(0);
			return true;
		}
		if(canYouWinPlayingFromBin(1)) {
			orderOfMoves.append(1);
			return true;
		} 
		return false;
	}
}