package binarySearchTree;

public class BST {
  private BinNode root; // Root of the BST
  private int nodecount; // Number of nodes in the BST

  // constructor
  BST() { root = null; nodecount = 0; }

  // Reinitialize tree
  public void clear() { root = null; nodecount = 0; }

  // Insert a record into the tree.
  // Records can be anything, but they must be int
  // e: The record to insert.
  public void insert(int e) {
    root = inserthelp(root, e);
    nodecount++;
  }
  
  /**
   * Assist the insert function by handle leaf and internal case
   * @param rt the current node
   * @param e the record to insert 
   * @return the current node
   */
  private BinNode inserthelp(BinNode rt, int e) {
	  if (rt == null) return new LeafNode(e);
	  if(rt.isLeaf() == false) {
		 //System.out.println("--" + rt.value);
		 //System.out.println(e);
		  if (rt.value > e) {
			  BinNode child = inserthelp(((InternalNode)rt).leftChild(), e);
			  ((InternalNode)rt).setLeft(child);
		  }
		  else if(rt.value < e) {
			  BinNode child = inserthelp(((InternalNode)rt).rightChild(), e);
			  ((InternalNode)rt).setRight(child);
			  
		  } else {
			  rt.increaseRepetition();
		  }
	  } else {
		 //System.out.println("**" + rt.value);
		 //System.out.println(e);
		 if(rt.value > e) {
			 rt = new InternalNode(rt.value, rt.getRepetitions(), inserthelp(null, e), null);
		 } else if(rt.value < e) rt = new InternalNode(rt.value, rt.getRepetitions(), null, inserthelp(null, e));
		 else {
			 rt.increaseRepetition();
		 }
		 //System.out.println("-1 " + ((InternalNode)rt).rightChild().value);
	  }
	  //System.out.println(e + " " + rt.value + " " + rt.isLeaf());
	  return rt;
  }
  
  /**
   * Return a string in pattern of "occurs <value> time(s)."
   * @param value the number of time to put in the string 
   * @return a string in pattern of "occurs <value> time(s)."
   */
  private String properQuantityNoun( int value ) {
		if (value == 1) {
			return " occurs 1 time.";
		} else {
			return " occurs " + value + " times.";
		}
	}
  
  /**
   * Construct a string include the repetition counter of every value in the tree
   * @param current the current node
   * @return the constructed string
   */
  public String toString( BinNode current ) {
	  String beingBuilt = "";
	  if (current == null) {
		  return beingBuilt;  	// No new data to add
	  } else if (current.isLeaf()) {
		  beingBuilt = "\nValue " + 	current.getValue() + 
				  properQuantityNoun( current.getRepetitions() );
		  return beingBuilt;
	  } else { 
		  InternalNode stringOf = (InternalNode) current;
		  if (stringOf.leftChild() != null) {
			  beingBuilt = toString(stringOf.leftChild());
		  }
		  beingBuilt += "\nValue " + 	current.getValue() + 
				  		properQuantityNoun( current.getRepetitions() );
		  if (stringOf.rightChild() != null) {
			  beingBuilt += toString(stringOf.rightChild());
		  }
		  return beingBuilt;
	  }
  }
  
  /**
   * This add one line of string to the constructed string from the other toString method  
   */
  public String toString() {	// For the whole tree
	  return "The binary search tree contains:" + toString(root);
  }
}
