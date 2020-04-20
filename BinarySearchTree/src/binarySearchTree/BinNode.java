package binarySearchTree;

public abstract class BinNode {
	protected int value; // The value being stored, and compared
	protected int repetitionCounter = 1; // The # of times this value was inserted
	abstract public boolean isLeaf(); // All subclasses must implement
	
	/**
	 * return the value of the node
	 * @return the value of the node
	 */
	protected int getValue() {
		return  value;
	}
	
	/**
	 * return the repetitionCounter
	 * @return the repetitionCounter
	 */
	protected int getRepetitions(){
		return repetitionCounter;
	}
	
	/**
	 * Increase repetitionCounter by one
	 */
	public void increaseRepetition() {
		++repetitionCounter;
	}
}