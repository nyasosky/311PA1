package test;

import classes.Intervals;
import classes.RBTree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntervalsDeleteTest {

    // Instance variables
    Intervals intervals;

    @Before
    public void initialize() {
        intervals = new Intervals();
    }

    @Test
    public void invalidIDTest() {

        // Cannot delete from empty interval tree
        assertFalse(intervals.intervalDelete(-1));
        assertFalse(intervals.intervalDelete(1));

        // Populate intervals tree and do some more tests
        insertIntervalsFromExample();
        assertFalse(intervals.intervalDelete(5));
        assertTrue(intervals.intervalDelete(4));
        assertTrue(intervals.intervalDelete(1));    // Works the first time...
        assertFalse(intervals.intervalDelete(1));   // But not the second
    }

    @Test
    public void intervalDeleteTest() {

        // Test if one deletion works
        insertIntervalsFromExample();
        intervals.intervalDelete(3);
        RBTree tree = intervals.getRBTree();
        assertEquals(4, tree.getRoot().getKey());
        assertEquals(1, tree.getRoot().getLeft().getKey());
        assertEquals(0, tree.getRoot().getLeft().getLeft().getKey());
        assertEquals(7, tree.getRoot().getRight().getKey());
        assertEquals(6, tree.getRoot().getRight().getLeft().getKey());
        assertEquals(11, tree.getRoot().getRight().getRight().getKey());
        assertEquals(6, tree.getSize());

        // Insert points from example with some extra intervals added in
        intervals = new Intervals();
        int[][] points = {{0, 4}, {2, 12}, {1, 6}, {5, 8}, {10, 13}, {3, 9}, {7, 11}};
        for (int i = 0; i < points.length; i++) {
            //System.out.println("Inserting: "+ Arrays.toString(points[i]));
            intervals.intervalInsert(points[i][0], points[i][1]);
        }

        // Delete the extra points and see if the POM is the same
        intervals.intervalDelete(2);
        intervals.intervalDelete(4);
        intervals.intervalDelete(5);
        assertEquals(8, intervals.getRBTree().getSize());
        assertEquals(3, intervals.findPOM());

    }

    /**
     * Helper method to insert the points from the example
     * in the documentation
     */
    private void insertIntervalsFromExample() {
        int[][] points = {{0, 4}, {1, 6}, {3, 9}, {7, 11}};
        for (int i = 0; i < points.length; i++) {
            //System.out.println("Inserting: "+ Arrays.toString(points[i]));
            intervals.intervalInsert(points[i][0], points[i][1]);
        }
    }

}
