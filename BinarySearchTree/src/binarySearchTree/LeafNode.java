package binarySearchTree;

class LeafNode extends BinNode {
	  //Constructor 
	  LeafNode(int val) { 
		  value = val; 
	  }
	  
	  //Apparently this is a leaf node so return true
	  public boolean isLeaf() { 
		  return true; 
	  }
}