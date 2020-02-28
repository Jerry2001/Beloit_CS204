package musicalChair;

public class Node {
	//objects in java
	//each node has a next value that acts as a pointer to the address. it is at one point in memory but points to the following one
	//each node stores where it is and where it is going
		
	private int contents;
	private Node next;
	
	public int getContents() {
		return contents;
	}

	public void setContents(int contents) {
		this.contents = contents;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	public Node (int newContents ) {
		contents =  newContents;
		next=null;
	}

	public Node( int newContents, Node nextNode) {
		contents= newContents;
		next = nextNode;
	}

	public void print() {
		Node current= this;
		while(current!= null) {
			System.out.print(current.contents);
			System.out.print(" , ");
			current = current.next;
		}
	}
}



