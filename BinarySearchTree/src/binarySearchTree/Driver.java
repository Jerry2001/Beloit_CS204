package binarySearchTree;

import java.util.Random;

public class Driver {
	final static int TREE_SIZE = 100;
	final  static int ELEMENT_RANGE = 10;
	
	/**
	 * Construct a tree with the size of TREE_SIZE with element ranging from 1 to ELEMENT_RANGE. 
	 * Then, output the repetition of every value of element in the tree.
	 */
	public static void main(String args[]) {
		BST tree = new BST();
		Random rand = new Random(101);
		for(int i = 0; i < TREE_SIZE; ++i) {
			tree.insert(rand.nextInt(ELEMENT_RANGE) + 1);
		}
		System.out.println(tree.toString());
	}
}
