package muTorere;

/**
 * The GameBoard class understands the board layout
 * and show whether two positions are connected by an edge/line.
 */

public class GameBoard {
	/**
	 * Determine whether the two positions are connected by an edge.
	 * @param vertex1 the first vertex
	 * @param vertex2 the second vertex
	 * @return returns true if vertex1 and vertex2 are connected, else returns false.
	 */
	public static boolean areThesePositionsConnected( int vertex1 , int vertex2 ) {
		if(vertex1 > vertex2) {
			vertex1 += vertex2;
			vertex2 = vertex1 - vertex2;
			vertex1 -= vertex2;
		}
		return (vertex1 == 0 | Math.abs(vertex1 - vertex2 % 8) == 1);
	}
}