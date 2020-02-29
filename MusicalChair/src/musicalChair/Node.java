package musicalChair;

/**
 * Objects in java.
 * Each node has a next value that acts as a pointer to the address. it is at one point in memory but points to the following one.
 * Each node stores where it is and where it is going.
 */

public class Node {
	private int contents;
	private Node next;
	
	/**
	 * @return contents of the node
	 * return contents of the node
	 */
	public int getContents() {
		return contents;
	}

	/**
	 * @param contents contents to set for the node 
	 * set contents for the node
	 */
	public void setContents(int contents) {
		this.contents = contents;
	}

	/**
	 * @return a node that the current node is pointed to
	 * Return a node that the current node is pointed to
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * @param next next is the node that the current node is pointed to
	 * Set the node that the current node is pointed to
	 */
	public void setNext(Node next) {
		this.next = next;
	}
	
	/**
	 * @param newContents contents of the node
	 * A constructutor to create a new node with initial contents
	 */
	public Node (int newContents) {
		contents =  newContents;
		next=null;
	}

	/**
	 * @param newContents contents of the node
	 * @param nextNode the node that the current node is pointed to
	 * A constructor to creat a new node with initial contents and a next node that the current node pointed to 
	 */
	public Node(int newContents, Node nextNode) {
		contents= newContents;
		next = nextNode;
	}
}



