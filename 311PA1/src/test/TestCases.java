package test;

import classes.Endpoint;
import classes.Intervals;
import classes.Node;
import classes.RBTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestCases {

	@Test
	void RBTreeTest1() {
		Intervals intervalTest = new Intervals();
		intervalTest.intervalInsert(0, 4);
		intervalTest.intervalInsert(1, 6);
		intervalTest.intervalInsert(3, 9);
		intervalTest.intervalInsert(7, 11);
		RBTree t = intervalTest.getRBTree();
		System.out.println("Size: " + t.getSize() + " Height: " + t.getHeight());
		t.InOrderTraversal(t.getRoot());
		assertEquals(3, intervalTest.findPOM());
	}

	@Test
	void RBTreeTest2() {
		RBTree t = new RBTree();
		assertEquals(0, t.getHeight());
	}

	@Test
	void NodeTest1() {
		Node n = new Node();
		Node parent = new Node(new Endpoint(11, 1));
		parent.setColor(1);
		n.setParent(parent);
		System.out.println(n.getParent() + " " + parent.getColor() + " " + n.getParent().getKey());
		assertTrue(true);
	}
	
	@Test
	void RBTreeIntervalOverlap() {
		Intervals intervalTest = new Intervals();
		intervalTest.intervalInsert(0, 4);
		intervalTest.intervalInsert(1, 6);
		intervalTest.intervalInsert(1, 6);
		intervalTest.intervalInsert(3, 9);
		intervalTest.intervalInsert(7, 11);
		intervalTest.intervalInsert(7, 11);
		RBTree t = intervalTest.getRBTree();
		System.out.println("Size: " + t.getSize() + " Height: " + t.getHeight());
		t.InOrderTraversal(t.getRoot());
		assertEquals(3, intervalTest.findPOM());
	}

	@Test
	void Delete1() {
		Intervals intervalTest = new Intervals();
		intervalTest.intervalInsert(1, 5);
		intervalTest.intervalInsert(3, 6);
		intervalTest.intervalInsert(1, 5);
		intervalTest.getRBTree().InOrderTraversal(intervalTest.getRBTree().getRoot());
		System.out.println();
		System.out.println();
		intervalTest.intervalDelete(1);
		intervalTest.getRBTree().InOrderTraversal(intervalTest.getRBTree().getRoot());

	}
	
	@Test
	void Delete2() {
		Intervals it = new Intervals();
		it.intervalInsert(2, 8);
		it.intervalInsert(1, 4);
		it.intervalInsert(3, 4);
		it.intervalInsert(5, 7);
		it.intervalInsert(7, 9);
		it.intervalInsert(3, 7);
		it.intervalInsert(2, 5);
		it.getRBTree().InOrderTraversal(it.getRBTree().getRoot());
		System.out.println();
		System.out.println();
		it.intervalDelete(3);
		it.getRBTree().InOrderTraversal(it.getRBTree().getRoot());
	}
}
