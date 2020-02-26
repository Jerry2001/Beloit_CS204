package musicalChair;

public class LinkedList {

	private Node headOfList, preHead, tail;
	int sizeOfList;
	
	void insertAtFrontofList(int val) {
		Node theNewItem = new Node(val, headOfList);//value, where to put it 
		if(val == sizeOfList) tail = theNewItem;
		
		headOfList = theNewItem;//we now actually move our pointer to read this correctly
		if(val == 1) tail.setNext(theNewItem);
	} 
	
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