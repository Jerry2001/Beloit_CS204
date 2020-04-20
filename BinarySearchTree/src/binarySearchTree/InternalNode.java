package binarySearchTree;

class InternalNode extends BinNode {
	  private BinNode left;                // Left child
	  private BinNode right;               // Right child
	  
	  /**
	   * Constructor 
	   * @param value value of the node
	   * @param l left children node
	   * @param r right children node
	   */
	  InternalNode(int value,BinNode l, BinNode r){ 
		  this.value = value; left = l; right = r;  
	  }
	  
	  /**
	   * Constructor
	   * @param value value of the node
	   * @param rep repetitionCounter to copy
	   * @param l left child node
	   * @param r right child node
	   */
	  InternalNode(int value, int rep, BinNode l, BinNode r){ 
		  this.value = value; left = l; right = r; repetitionCounter = rep; 
	  }
	  
	  /*
	   * This is not a leaf node so return false
	   */
	  public boolean isLeaf() { 
		  return false; 
	  }
	  
	  /**
	   * Return the left child node
	   * @return the left child node
	   */
	  public BinNode leftChild() { 
		  return left; 
	  }
	  
	  /**
	   * Return the right child node
	   * @return the right child node
	   */
	  public BinNode rightChild() { 
		  return right; 
	  }
	  
	  /**
	   * Set the left child node
	   * @param newLeft the node to set as the new left child
	   */
	  public void  setLeft(BinNode newLeft) {
		  left = newLeft;
	  }
	  
	  /**
	   * Set the right child node
	   * @param newRight  the node to set as the new right child
	   */
	  public void setRight(BinNode newRight) {
		  right = newRight;
	  }
}