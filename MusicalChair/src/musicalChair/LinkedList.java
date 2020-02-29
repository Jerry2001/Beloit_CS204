package musicalChair;

/**
 * This is the circular linked list class
 */

public class LinkedList {

	private Node headOfList, preHead, tail;
	private int sizeOfList;
	
	/**
	 * @param val the initial size of the linked list
	 * Set the initial size of the linked list
	 */
	void setSize(int val){
		this.sizeOfList = val;
	}

	/**
	 * @return the current size of the linked list
	 * Return the current size of the linked list
	 */
	int getSize(){
		return this.sizeOfList;
	}

	/**
	 * @param val the value to input at the front of the linked list
	 * Add an integer at the front of the linked list
	 */
	void insertAtFrontofList(int val) {
		Node theNewItem = new Node(val, headOfList);
		if(val == sizeOfList) tail = theNewItem;
		
		headOfList = theNewItem;
		if(val == 1) {
			preHead = tail;
			tail.setNext(theNewItem);
		}
	} 
	
	/**
	 * Move the current headOfList to the next item in the linked list
	 */
	void goToNextElement() {
		preHead = headOfList;
		headOfList = headOfList.getNext();
	}

	/**
	 * Remove the element that headOfList is pointing to, reduce the size of the linked list 
	 * and move the headOfList to the next item.`
	 */
	void removeElement() {
		preHead.setNext(headOfList.getNext());
		--sizeOfList;
		goToNextElement();
	}
	
	/**
	 * @return the value headOfList is pointing to
	 * Return the value the current headOfList is pointing to
	 */
	public int getHeadVal() {
		return headOfList.getContents();
	}
	
	/**
	 * @return a String version of the linked list
	 * Return a String version of the linked list
	 */
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
