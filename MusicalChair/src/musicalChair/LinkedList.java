package musicalChair;

/**
 * This is the circular linked list class
 */

public class LinkedList {

	private Node headOfList, preHead, tail;
	int sizeOfList;
	
	/**
	 * @param val the value to input at the front of the linked list
	 * Add an integer at the front of the linked list
	 */
	void insertAtFrontofList(int val) {
		Node theNewItem = new Node(val, headOfList);
		if(val == sizeOfList) tail = theNewItem;
		
		headOfList = theNewItem;
		if(val == 1) tail.setNext(theNewItem);
	} 
	
	/**
	 * Move the current head of list to the next item
	 */
	void goToNextElement() {
		preHead = headOfList;
		headOfList = headOfList.getNext();
	}

	void removeElement() {
		preHead.setNext(headOfList.getNext());
		--sizeOfList;
		goToNextElement();
	}
	
	public int getHeadVal() {
		return headOfList.getContents();
	}
	
	public String toString() {
		if (headOfList == null)
			return "<empty list>";
		String toReturn = " " + headOfList.getContents();
		for (Node nextNode = headOfList.getNext(); nextNode != headOfList; nextNode=nextNode.getNext()) {
			toReturn += ", " + nextNode.getContents();
		}
		return toReturn;
	}

}
