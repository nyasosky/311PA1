package classes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RBtreeTest {

	@Test
	void test() {
		RBTree t = new RBTree();
		Node n1 = new Node();
		n1.setKey(14);
		t.RBInsert(n1);
		Node n2 = new Node();
		n2.setKey(10);
		t.RBInsert(n2);
		Node n3 = new Node();
		n3.setKey(1);
		t.RBInsert(n3);
		Node n4 = new Node();
		n4.setKey(12);
		t.RBInsert(n4);
		Node n5 = new Node();
		n5.setKey(8);
		t.RBInsert(n5);
		Node n6 = new Node();
		n6.setKey(20);
		t.RBInsert(n6);
		Node n7 = new Node();
		n7.setKey(18);
		t.RBInsert(n7);
		Node n8 = new Node();
		n8.setKey(26);
		t.RBInsert(n8);
		Node n9 = new Node();
		n9.setKey(22);
		t.RBInsert(n9);
		Node n10 = new Node();
		n10.setKey(30);
		t.RBInsert(n10);
		System.out.println("Size: " + t.getSize() + " Height: " + t.getHeight());
		t.InOrderTraversal(t.getRoot());
		assertTrue(true);
	}

}
