package hashTable;

import java.util.Arrays; 
import java.lang.Math;

class ClosedHashTable {
	private ProbeSequence probeSequence;
	private float filledThreshold;
	private int sizeOfTable;
	private int filledCnt;
	private int collisionCnt;
	private int probeCnt;
	private Long[] hashTable;
	final static public int EMPTY_SLOT = -1;
	public enum ProbeSequence {
		LINEAR, QUADRATIC
	}

	/**
	 * Constructor
	 * @param size size of the hashtable
	 * @param threshold threshold of the hashtable
	 * @param probe the kind of probe sequence technique the hashtable uses 
	 */
	public ClosedHashTable(int size, float threshold, ProbeSequence probe) {
		sizeOfTable = size;
		filledThreshold = threshold;
		probeSequence = probe;
		hashTable = new Long[sizeOfTable];
		filledCnt = 0;
		probeCnt = 0;
		collisionCnt = 0;
		for(int i = 0; i < hashTable.length; ++i) 
			hashTable[i] = (long) EMPTY_SLOT;
	}
	
	public int getFilledCnt() {
		return filledCnt;
	}
	
	public int getCollisionCnt() {
		return collisionCnt;
	}
	
	public int getProbeCnt() {
		return probeCnt;
	}

	/**
	 * the hash table hash function
	 * @param toHash the value to hash
	 * @return the hashed value
	 */
	private int hashFunction(int toHash) {
		int squared = toHash * toHash;
		int upper6Digits = squared / 100;
		int lower4DigitsOfThat = upper6Digits % sizeOfTable;
		return lower4DigitsOfThat;
	}
	/**
	 * Return the appropriate next probe of index in the sequence
	 * @param index the current position
	 * @return the next probe's position
	 */
	public int probeFunction(int index) {
		if (probeSequence == ProbeSequence.LINEAR) return index;
		else return index * index;
	}

	/**
	 * Determine whether the value is in the hashtable
	 * @param value to check
	 * @return return true if that value is in the hashtable, otherwise return false
	 */
	public boolean find(int value) {
		int home;
		int pos = home = hashFunction(value); 
		for (int i = 1; ((value != (hashTable[pos])) && (EMPTY_SLOT != (hashTable[pos]))); i++) {
			probeCnt++;
			pos = (home + probeFunction(i)) % sizeOfTable;
		}
		if (value == (hashTable[pos])) { 
			return true;
		} else
			return false; 
	}

	/**
	 * Insert the value to the hash table
	 * @param value the value to insert
	 * @return return 0 if it is inserted successfully
	 * -1 if it can not be inserted due to infinite loop, -2 if the value is duplicate
	 */
	public int insert(int value) {
		int step = 0;
		int home; 
		int pos = home = hashFunction(value); 
		for (int i = 1; EMPTY_SLOT != hashTable[pos]; i++) {
			++step;
			if(step == 8210) return -1;
			pos = (home + probeFunction(i)) % sizeOfTable; 
			collisionCnt++; 
			if (value == hashTable[pos]) {
				return -2;
			}
		}
		filledCnt++;
		hashTable[pos] = (long) value;
		return 0;
	}
}