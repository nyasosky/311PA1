package test;

import classes.Endpoint;
import classes.Node;
import classes.RBTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestCases {

    @Test
    void RBTreeTest1() {
        RBTree t = new RBTree();
        Node n1 = new Node(new Endpoint(0, 1));
        t.RBInsert(n1);
        Node n2 = new Node(new Endpoint(1, 1));
        t.RBInsert(n2);
        Node n3 = new Node(new Endpoint(3, 1));
        t.RBInsert(n3);
        Node n4 = new Node(new Endpoint(4, -1));
        t.RBInsert(n4);
        Node n5 = new Node(new Endpoint(6, -1));
        t.RBInsert(n5);
        Node n6 = new Node(new Endpoint(7, 1));
        t.RBInsert(n6);
        Node n7 = new Node(new Endpoint(9, -1));
        t.RBInsert(n7);
        Node n8 = new Node(new Endpoint(11, -1));
        t.RBInsert(n8);
        System.out.println("Size: " + t.getSize() + " Height: " + t.getHeight());
        t.InOrderTraversal(t.getRoot());
        assertTrue(true);
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
