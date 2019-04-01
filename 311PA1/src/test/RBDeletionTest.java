package test;

import classes.Endpoint;
import classes.Node;
import classes.RBTree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Deletion test cases gotten from
 * https://www.geeksforgeeks.org/red-black-tree-set-3-delete-2/
 */
public class RBDeletionTest {

    // Instance variables
    private RBTree tree;
    private Node node1;
    private Node node2;
    private Node node3;
    private Node node4;
    private Node node5;
    private Node node6;

    @Before
    public void initialize() {
        tree = new RBTree();
        node1 = new Node(new Endpoint(1, 1));
        node2 = new Node(new Endpoint(2, 1));
        node3 = new Node(new Endpoint(3, 1));
        node4 = new Node(new Endpoint(4, 1));
        node5 = new Node(new Endpoint(5, 1));
        node6 = new Node(new Endpoint(6, 1));
    }

    @Test
    public void simpleDelete() {

        // Create simple tree
        tree.RBInsert(node3);
        tree.RBInsert(node2);
        tree.RBInsert(node4);
        tree.RBInsert(node1);

        // Delete root.left
        tree.RBDeletion(node2);

        // Test tree keys
        assertEquals(3, tree.getRoot().getKey());
        assertEquals(1, tree.getRoot().getLeft().getKey());
        assertEquals(4, tree.getRoot().getRight().getKey());

        // Test tree parents
        assertTrue(tree.getRoot().getParent() == tree.getNILNode());
        assertEquals(3, tree.getRoot().getLeft().getParent().getKey());
        assertEquals(3, tree.getRoot().getRight().getParent().getKey());

        // Test leaves
        assertTrue(tree.getRoot().getLeft().getLeft() == tree.getNILNode());
        assertTrue(tree.getRoot().getLeft().getRight() == tree.getNILNode());
        assertTrue(tree.getRoot().getRight().getLeft() == tree.getNILNode());
        assertTrue(tree.getRoot().getRight().getRight() == tree.getNILNode());

        // Test tree colors
        assertEquals(1, tree.getRoot().getColor());
        assertEquals(1, tree.getRoot().getLeft().getColor());
        assertEquals(1, tree.getRoot().getRight().getColor());

        // Test size
        assertEquals(3, tree.getSize());
    }

    @Test
    public void doubleBlackLeftLeftTest() {

        // Create tree
        tree.RBInsert(node5);
        tree.RBInsert(node3);
        tree.RBInsert(node6);
        tree.RBInsert(node2);
        tree.RBInsert(node4);

        // Delete root.right
        tree.RBDeletion(node6);

        // Test tree keys
        assertEquals(3, tree.getRoot().getKey());
        assertEquals(2, tree.getRoot().getLeft().getKey());
        assertEquals(5, tree.getRoot().getRight().getKey());
        assertEquals(4, tree.getRoot().getRight().getLeft().getKey());

        // Test tree parents
        assertTrue(tree.getRoot().getParent() == tree.getNILNode());
        assertEquals(3, tree.getRoot().getLeft().getParent().getKey());
        assertEquals(3, tree.getRoot().getRight().getParent().getKey());
        assertEquals(5, tree.getRoot().getRight().getLeft().getParent().getKey());

        // Test leaves
        assertTrue(tree.getRoot().getLeft().getLeft() == tree.getNILNode());
        assertTrue(tree.getRoot().getLeft().getRight() == tree.getNILNode());
        assertTrue(tree.getRoot().getRight().getRight() == tree.getNILNode());
        assertTrue(tree.getRoot().getRight().getLeft().getLeft() == tree.getNILNode());
        assertTrue(tree.getRoot().getRight().getLeft().getRight() == tree.getNILNode());

        // Test tree colors
        assertEquals(1, tree.getRoot().getColor());
        assertEquals(1, tree.getRoot().getLeft().getColor());
        assertEquals(1, tree.getRoot().getRight().getColor());
        assertEquals(0, tree.getRoot().getRight().getLeft().getColor());

        // Test size
        assertEquals(4, tree.getSize());
    }

    @Test
    public void doubleBlackRightRightTest() {

        // Create tree
        tree.RBInsert(node3);
        tree.RBInsert(node2);
        tree.RBInsert(node5);
        tree.RBInsert(node4);
        tree.RBInsert(node6);

        // Delete root.left
        tree.RBDeletion(node2);

        // Test tree keys
        assertEquals(5, tree.getRoot().getKey());
        assertEquals(3, tree.getRoot().getLeft().getKey());
        assertEquals(4, tree.getRoot().getLeft().getRight().getKey());
        assertEquals(6, tree.getRoot().getRight().getKey());

        // Test tree parents
        assertTrue(tree.getRoot().getParent() == tree.getNILNode());
        assertEquals(5, tree.getRoot().getLeft().getParent().getKey());
        assertEquals(5, tree.getRoot().getRight().getParent().getKey());
        assertEquals(3, tree.getRoot().getLeft().getRight().getParent().getKey());

        // Test leaves
        assertTrue(tree.getRoot().getLeft().getLeft() == tree.getNILNode());
        assertTrue(tree.getRoot().getLeft().getRight().getLeft() == tree.getNILNode());
        assertTrue(tree.getRoot().getLeft().getRight().getRight() == tree.getNILNode());
        assertTrue(tree.getRoot().getRight().getLeft() == tree.getNILNode());
        assertTrue(tree.getRoot().getRight().getRight() == tree.getNILNode());

        // Test tree colors
        assertEquals(1, tree.getRoot().getColor());
        assertEquals(1, tree.getRoot().getLeft().getColor());
        assertEquals(0, tree.getRoot().getLeft().getRight().getColor());
        assertEquals(1, tree.getRoot().getRight().getColor());

        // Test size
        assertEquals(4, tree.getSize());
    }

    @Test
    public void doubleBlackLeftRightTest() {

        // Create tree
        tree.RBInsert(node4);
        tree.RBInsert(node2);
        tree.RBInsert(node5);
        tree.RBInsert(node3);

        // Delete root.right
        tree.RBDeletion(node5);

        // Test tree keys
        assertEquals(3, tree.getRoot().getKey());
        assertEquals(2, tree.getRoot().getLeft().getKey());
        assertEquals(4, tree.getRoot().getRight().getKey());

        // Test tree parents
        assertTrue(tree.getRoot().getParent() == tree.getNILNode());
        assertEquals(3, tree.getRoot().getLeft().getParent().getKey());
        assertEquals(3, tree.getRoot().getRight().getParent().getKey());

        // Test leaves
        assertTrue(tree.getRoot().getLeft().getLeft() == tree.getNILNode());
        assertTrue(tree.getRoot().getLeft().getRight() == tree.getNILNode());
        assertTrue(tree.getRoot().getRight().getLeft() == tree.getNILNode());
        assertTrue(tree.getRoot().getRight().getRight() == tree.getNILNode());

        // Test tree colors
        assertEquals(1, tree.getRoot().getColor());
        assertEquals(1, tree.getRoot().getLeft().getColor());
        assertEquals(1, tree.getRoot().getRight().getColor());

        // Test size
        assertEquals(3, tree.getSize());
    }

    @Test
    public void doubleBlackRightLeftTest() {

        // Create tree
        tree.RBInsert(node3);
        tree.RBInsert(node2);
        tree.RBInsert(node5);
        tree.RBInsert(node4);

        // Delete root.left
        tree.RBDeletion(node2);

        // Test tree keys
        assertEquals(4, tree.getRoot().getKey());
        assertEquals(3, tree.getRoot().getLeft().getKey());
        assertEquals(5, tree.getRoot().getRight().getKey());

        // Test tree parents
        assertTrue(tree.getRoot().getParent() == tree.getNILNode());
        assertEquals(4, tree.getRoot().getLeft().getParent().getKey());
        assertEquals(4, tree.getRoot().getRight().getParent().getKey());

        // Test leaves
        assertTrue(tree.getRoot().getLeft().getLeft() == tree.getNILNode());
        assertTrue(tree.getRoot().getLeft().getRight() == tree.getNILNode());
        assertTrue(tree.getRoot().getRight().getLeft() == tree.getNILNode());
        assertTrue(tree.getRoot().getRight().getRight() == tree.getNILNode());

        // Test tree colors
        assertEquals(1, tree.getRoot().getColor());
        assertEquals(1, tree.getRoot().getLeft().getColor());
        assertEquals(1, tree.getRoot().getRight().getColor());

        // Test size
        assertEquals(3, tree.getSize());
    }

    @Test
    public void siblingAndBothChildrenBlackTest() {

        // Create tree
        tree.RBInsert(node2);
        tree.RBInsert(node1);
        tree.RBInsert(node3);
        tree.getRoot().getLeft().setColor(1);
        tree.getRoot().getRight().setColor(1);

        // Delete root.left
        tree.RBDeletion(node1);

        // Test tree keys
        assertEquals(2, tree.getRoot().getKey());
        assertEquals(3, tree.getRoot().getRight().getKey());

        // Test tree parents
        assertTrue(tree.getRoot().getParent() == tree.getNILNode());
        assertEquals(2, tree.getRoot().getRight().getParent().getKey());

        // Test leaves
        assertTrue(tree.getRoot().getLeft() == tree.getNILNode());
        assertTrue(tree.getRoot().getRight().getLeft() == tree.getNILNode());
        assertTrue(tree.getRoot().getRight().getRight() == tree.getNILNode());

        // Test tree colors
        assertEquals(1, tree.getRoot().getColor());
        assertEquals(0, tree.getRoot().getRight().getColor());

        // Test size
        assertEquals(2, tree.getSize());
    }

    @Test
    public void siblingRedLeftTest() {

        // Create tree
        tree.RBInsert(node4);
        tree.RBInsert(node2);
        tree.RBInsert(node5);
        tree.RBInsert(node1);
        tree.RBInsert(node3);
        tree.getRoot().getLeft().setColor(0);
        tree.getRoot().getLeft().getLeft().setColor(1);
        tree.getRoot().getLeft().getRight().setColor(1);

        // Delete root.right
        tree.RBDeletion(node5);

        // Test tree keys
        assertEquals(2, tree.getRoot().getKey());
        assertEquals(1, tree.getRoot().getLeft().getKey());
        assertEquals(4, tree.getRoot().getRight().getKey());
        assertEquals(3, tree.getRoot().getRight().getLeft().getKey());

        // Test tree parents
        assertTrue(tree.getRoot().getParent() == tree.getNILNode());
        assertEquals(2, tree.getRoot().getLeft().getParent().getKey());
        assertEquals(2, tree.getRoot().getRight().getParent().getKey());
        assertEquals(4, tree.getRoot().getRight().getLeft().getParent().getKey());

        // Test leaves
        assertTrue(tree.getRoot().getLeft().getLeft() == tree.getNILNode());
        assertTrue(tree.getRoot().getLeft().getRight() == tree.getNILNode());
        assertTrue(tree.getRoot().getRight().getRight() == tree.getNILNode());
        assertTrue(tree.getRoot().getRight().getLeft().getLeft() == tree.getNILNode());
        assertTrue(tree.getRoot().getRight().getLeft().getRight() == tree.getNILNode());

        // Test tree colors
        assertEquals(1, tree.getRoot().getColor());
        assertEquals(1, tree.getRoot().getLeft().getColor());
        assertEquals(1, tree.getRoot().getRight().getColor());
        assertEquals(0, tree.getRoot().getRight().getLeft().getColor());

        // Test size
        assertEquals(4, tree.getSize());
    }

    @Test
    public void siblingRedRightTest() {

        // Create tree
        tree.RBInsert(node2);
        tree.RBInsert(node1);
        tree.RBInsert(node4);
        tree.RBInsert(node3);
        tree.RBInsert(node5);
        tree.getRoot().getRight().setColor(0);
        tree.getRoot().getRight().getLeft().setColor(1);
        tree.getRoot().getRight().getRight().setColor(1);

        // Delete root.left
        tree.RBDeletion(node1);

        // Test tree keys
        assertEquals(4, tree.getRoot().getKey());
        assertEquals(2, tree.getRoot().getLeft().getKey());
        assertEquals(3, tree.getRoot().getLeft().getRight().getKey());
        assertEquals(5, tree.getRoot().getRight().getKey());

        // Test tree parents
        assertTrue(tree.getRoot().getParent() == tree.getNILNode());
        assertEquals(4, tree.getRoot().getLeft().getParent().getKey());
        assertEquals(4, tree.getRoot().getRight().getParent().getKey());
        assertEquals(2, tree.getRoot().getLeft().getRight().getParent().getKey());

        // Test leaves
        assertTrue(tree.getRoot().getLeft().getLeft() == tree.getNILNode());
        assertTrue(tree.getRoot().getLeft().getRight().getLeft() == tree.getNILNode());
        assertTrue(tree.getRoot().getLeft().getRight().getRight() == tree.getNILNode());
        assertTrue(tree.getRoot().getRight().getLeft() == tree.getNILNode());
        assertTrue(tree.getRoot().getRight().getRight() == tree.getNILNode());

        // Test tree colors
        assertEquals(1, tree.getRoot().getColor());
        assertEquals(1, tree.getRoot().getLeft().getColor());
        assertEquals(0, tree.getRoot().getLeft().getRight().getColor());
        assertEquals(1, tree.getRoot().getRight().getColor());

        // Test size
        assertEquals(4, tree.getSize());
    }
}
