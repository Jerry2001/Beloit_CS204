package musicalChair;

public class Debugging {
	
	private static Node head, second;
	private static int sizeOfList;
	
	public static String convertToString() {
		if (head == null)
			return "<empty list>";
		String toReturn = "" + head.getContents();
		for (Node nextNode = head.getNext(); nextNode != null; nextNode = nextNode.getNext()) {
			toReturn += ", " + nextNode.getContents();
		}
		return toReturn;
	}

	/** A test driver for debugging circular linked lists. */
	public static void main(String[] args) {
		head = new Node(17);
		second = new Node(19);
		head.setNext(second);
		second.setNext(head);
		sizeOfList = 2;
		System.out.println( convertToString() );
	}

}