package binarySearchTree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinaryNodeTests {

	@Test
	public void testIsLeaf() {
		InternalNode internal = new InternalNode(17,null,null);
		assertFalse( internal.isLeaf() );
		LeafNode leaf = new LeafNode(17);
		assertTrue( leaf.isLeaf() );
	}

	@Test
	public void testGetValue() {
		InternalNode internal = new InternalNode(17,null,null);
		assertEquals( 17, internal.getValue() );
		LeafNode leaf = new LeafNode(17);
		assertEquals( 17, leaf.getValue() );
	}

	@Test
	public void testGetRepetitions() {
		InternalNode internal = new InternalNode(17,null,null);
		assertEquals( 1, internal.getRepetitions() );
		LeafNode leaf = new LeafNode(17);
		assertEquals( 1, leaf.getRepetitions() );
	}
	
	@Test
	public void testNullChild() {
		InternalNode internal = new InternalNode(17,null,null);
		assertNull( internal.leftChild() );
		assertNull( internal.rightChild() );
		
		LeafNode leaf = new LeafNode( 121 );
		internal = new InternalNode(17,leaf,null);
		assertNull( internal.rightChild() );
		assertEquals( internal.leftChild(), leaf );
		
		internal = new InternalNode(17,null,leaf);
		assertNull( internal.leftChild() );
		assertEquals( internal.rightChild(), leaf );
	}

	@Test
	public void testSetLeftAndRight() {
		LeafNode leaf = new LeafNode( 121 );
		InternalNode internal = new InternalNode(17,null,null);
		internal.setLeft(leaf);
		assertNull( internal.rightChild() );
		assertEquals( internal.leftChild(), leaf );

		internal = new InternalNode(17,null,null);
		internal.setRight(leaf);
		assertNull( internal.leftChild() );
		assertEquals( internal.rightChild(), leaf );
		
		LeafNode leaf2 = new LeafNode( 17 );
		internal = new InternalNode(17,null,null);
		internal.setLeft(leaf2);
		internal.setRight(leaf);
		assertEquals( internal.leftChild(), leaf2 );
		assertEquals( internal.rightChild(), leaf );
	}
}
