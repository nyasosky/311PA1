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
}
