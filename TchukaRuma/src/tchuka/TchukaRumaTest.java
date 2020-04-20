package tchuka;

import static org.junit.Assert.*;

import org.junit.Test;

public class TchukaRumaTest {

	@Test
	public void testTchukaRuma() {
		TchukaRuma gameBoard = new TchukaRuma( 3 );
		assertEquals("[3, 3, 0]", gameBoard.toString() );
		gameBoard = new TchukaRuma( 17 );
		assertEquals("[17, 17, 0]", gameBoard.toString() );
	}

	@Test
	public void testSowOneRound() {
		TchukaRuma gameBoard = new TchukaRuma( 2 );
		assertEquals(2,gameBoard.sowOneRound(0) );
		gameBoard = new TchukaRuma( 3 );
		assertEquals(0,gameBoard.sowOneRound(0) );
		gameBoard = new TchukaRuma( 3 );
		assertEquals(1,gameBoard.sowOneRound(1) );
		gameBoard = new TchukaRuma( 4 );
		assertEquals(1,gameBoard.sowOneRound(0) );
		gameBoard = new TchukaRuma( 7 );
		assertEquals(2,gameBoard.sowOneRound(1) );
	}

	@Test
	public void testMakeOneMove() {
		// Test with no repeated sowing
		TchukaRuma gameBoard = new TchukaRuma( 2 );
		gameBoard.makeOneMove(0);
		assertEquals("[0, 3, 1]", gameBoard.toString() );
		// Test with one repeated sowing
		gameBoard = new TchukaRuma( 2 );
		gameBoard.makeOneMove(1);
		assertEquals("[1, 1, 2]", gameBoard.toString() );
		// Test with several repeated sowings
		gameBoard = new TchukaRuma( 4 );
		gameBoard.makeOneMove(0);
		assertEquals("[0, 1, 7]", gameBoard.toString() );
		// Test that you stop when you land in the Ruma; no repeated sowings
		gameBoard = new TchukaRuma( 4 );
		gameBoard.makeOneMove(1);
		assertEquals("[5, 1, 2]", gameBoard.toString() );
		// Test that you stop when you land in the Ruma; with repeated sowings
		gameBoard = new TchukaRuma( 5 );
		gameBoard.makeOneMove(1);
		assertEquals("[3, 1, 6]", gameBoard.toString() );
	}

	@Test
	public void testCanYouWinPlayingFromBin() {
		TchukaRuma gameBoard = new TchukaRuma( 4 );
		assertTrue(gameBoard.canYouWinPlayingFromBin(0));
		gameBoard = new TchukaRuma( 4 );
		assertTrue(gameBoard.canYouWinPlayingFromBin(1));
		gameBoard = new TchukaRuma( 5 );
		assertTrue(gameBoard.canYouWinPlayingFromBin(0));
		gameBoard = new TchukaRuma( 5 );
		assertFalse(gameBoard.canYouWinPlayingFromBin(1));
	}
	
	@Test
	public void testCanYouWin() {
		TchukaRuma gameBoard = new TchukaRuma( 2 );
		assertFalse(gameBoard.canYouWin( ));
		
		gameBoard = new TchukaRuma( 3 );
		assertFalse(gameBoard.canYouWin( ));
		
		gameBoard = new TchukaRuma( 4 );
		assertTrue(gameBoard.canYouWin( ));
		
		gameBoard = new TchukaRuma( 5 );
		assertTrue(gameBoard.canYouWin( ));
		
		gameBoard = new TchukaRuma( 6 );
		assertFalse(gameBoard.canYouWin( ));
		
		gameBoard = new TchukaRuma( 7 );
		assertTrue(gameBoard.canYouWin( ));
	}

}