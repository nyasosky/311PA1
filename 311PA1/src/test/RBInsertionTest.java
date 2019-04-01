package test;

import classes.Endpoint;
import classes.Node;
import classes.RBTree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RBInsertionTest {

    // Instance variables
    private RBTree tree;
    private Node node1;
    private Node node2;
    private Node node3;
    private Node node4;

    @Before
    public void initialize() {
        tree = new RBTree();
        node1 = new Node(new Endpoint(1, 1));
        node2 = new Node(new Endpoint(2, 1));
        node3 = new Node(new Endpoint(3, 1));
        node4 = new Node(new Endpoint(4, 1));
    }

    @Test
    public void firstInsert() {
        tree.RBInsert(node1);
        assertEquals(tree.getRoot().getKey(), 1);
        assertEquals(tree.getRoot().getColor(), 1);
    }

    @Test
    public void leftInsert() {
        tree.RBInsert(node2);
        tree.RBInsert(node1);
        assertEquals(tree.getRoot().getKey(), 2);
        assertEquals(tree.getRoot().getColor(), 1);
        assertEquals(tree.getRoot().getLeft().getKey(), 1);
        assertEquals(tree.getRoot().getLeft().getColor(), 0);
        assertTrue(tree.getRoot().getRight() == tree.getNILNode());
    }

    @Test
    public void rightInsert() {
        tree.RBInsert(node2);
        tree.RBInsert(node3);
        assertEquals(tree.getRoot().getKey(), 2);
        assertEquals(tree.getRoot().getColor(), 1);
        assertEquals(tree.getRoot().getRight().getKey(), 3);
        assertEquals(tree.getRoot().getRight().getColor(), 0);
        assertTrue(tree.getRoot().getLeft() == tree.getNILNode());
    }

    @Test
    public void leftRightInsert() {

        // Build tree
        tree.RBInsert(node2);
        tree.RBInsert(node1);
        tree.RBInsert(node3);

        // Test initial insertion
        assertEquals(tree.getRoot().getKey(), node2.getKey());
        assertEquals(tree.getRoot().getColor(), 1);

        // Test root's children
        Node left = tree.getRoot().getLeft();
        Node right = tree.getRoot().getRight();
        assertEquals(left.getKey(), node1.getKey());
        assertEquals(right.getKey(), node3.getKey());
        assertEquals(left.getParent().getKey(), node2.getKey());
        assertEquals(right.getParent().getKey(), node2.getKey());
        assertEquals(left.getColor(), 0);
        assertEquals(right.getColor(), 0);

        // Test children's children are nil
        assertTrue(left.getLeft() == tree.getNILNode());
        assertTrue(left.getRight() == tree.getNILNode());
        assertTrue(right.getLeft() == tree.getNILNode());
        assertTrue(right.getRight() == tree.getNILNode());

    }

    @Test
    public void insertWithLeftRotation() {

        // Build tree
        tree.RBInsert(node1);
        tree.RBInsert(node2);
        tree.RBInsert(node3);

        // Test root after rotation
        assertEquals(tree.getRoot().getKey(), 2);
        assertEquals(tree.getRoot().getColor(), 1);

        // Test children
        Node left = tree.getRoot().getLeft();
        Node right = tree.getRoot().getRight();
        assertEquals(left.getKey(), 1);
        assertEquals(right.getKey(), 3);
        assertEquals(left.getParent(), tree.getRoot());
        assertEquals(right.getParent(), tree.getRoot());
        assertEquals(left.getColor(), 0);
        assertEquals(right.getColor(), 0);

        // Test grandchildren are nil
        assertTrue(left.getLeft() == tree.getNILNode());
        assertTrue(left.getRight() == tree.getNILNode());
        assertTrue(right.getLeft() == tree.getNILNode());
        assertTrue(right.getRight() == tree.getNILNode());
    }

    @Test
    public void insertWithRightRotation() {

        // Build tree
        tree.RBInsert(node3);
        tree.RBInsert(node2);
        tree.RBInsert(node1);

        // Test root after rotation
        assertEquals(tree.getRoot().getKey(), 2);
        assertEquals(tree.getRoot().getColor(), 1);

        // Test children
        Node left = tree.getRoot().getLeft();
        Node right = tree.getRoot().getRight();
        assertEquals(left.getKey(), 1);
        assertEquals(right.getKey(), 3);
        assertEquals(left.getParent(), tree.getRoot());
        assertEquals(right.getParent(), tree.getRoot());
        assertEquals(left.getColor(), 0);
        assertEquals(right.getColor(), 0);

        // Test grandchildren are nil
        assertTrue(left.getLeft() == tree.getNILNode());
        assertTrue(left.getRight() == tree.getNILNode());
        assertTrue(right.getLeft() == tree.getNILNode());
        assertTrue(right.getRight() == tree.getNILNode());
    }

    @Test
    public void insertCase3() {

        // Build tree to create case 3 scenario (from Wikipedia)
        tree.RBInsert(node3);
        tree.RBInsert(node2);
        tree.RBInsert(node4);
        tree.RBInsert(node1);

        // Test if colors were repainted correctly
        assertEquals(tree.getRoot().getColor(), 1);
        assertEquals(tree.getRoot().getLeft().getColor(), 1);
        assertEquals(tree.getRoot().getRight().getColor(), 1);
        assertEquals(tree.getRoot().getLeft().getLeft().getColor(), 0);
    }

    @Test
    public void insertCase4() {

        // Build tree to create case 4 scenario (from Wikipedia)
        tree.RBInsert(node3);
        tree.RBInsert(node1);
        tree.RBInsert(node4);
        tree.getRoot().getRight().setColor(1);    // Set color of uncle to black
        tree.RBInsert(node2);

        // Test rotations
        assertEquals(tree.getRoot().getKey(), 2);
        assertEquals(tree.getRoot().getLeft().getKey(), 1);
        assertEquals(tree.getRoot().getRight().getKey(), 3);
        assertEquals(tree.getRoot().getRight().getRight().getKey(), 4);
        assertTrue(tree.getRoot().getLeft().getLeft() == tree.getNILNode());
        assertTrue(tree.getRoot().getLeft().getRight() == tree.getNILNode());
        assertTrue(tree.getRoot().getRight().getLeft() == tree.getNILNode());
        assertTrue(tree.getRoot().getRight().getRight().getLeft() == tree.getNILNode());
        assertTrue(tree.getRoot().getRight().getRight().getRight() == tree.getNILNode());

        // Test colors
        assertEquals(tree.getRoot().getColor(), 1);
        assertEquals(tree.getRoot().getLeft().getColor(), 0);
        assertEquals(tree.getRoot().getRight().getColor(), 0);
        assertEquals(tree.getRoot().getRight().getRight().getColor(), 1);
    }
}
