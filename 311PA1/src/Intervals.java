import java.util.ArrayList;
import java.util.List;

/**
 * Class for an Interval within a RBT
 * @author Ryan Connolly and Nathan Yasosky
 *
 */
public class Intervals {

	/**
	 * Instance of a RBT
	 */
	RBTree rbTree;
	
	/**
	 * List to keep track of intervals added into the RBT
	 */
    private List<Endpoint[]> intervalList;

	/**
	 * Constructor for an Intervals object
	 * Each Intervals object will consist of a RBT and a list of intervals that contain endpoints
	 */
	public Intervals() {
		rbTree = new RBTree();
		intervalList = new ArrayList<Endpoint[]>();
	}

	/**
	 * Method for inserting an interval into a RBT
	 * Creates two endpoints and then adds them into the interval list
	 * Two new nodes are created using the endpoints and then they are inserted into the tree
	 * @param a Value for the left endpoint
	 * @param b Value for the right endpoint
	 */
	public void intervalInsert(int a, int b) {
		Endpoint left = new Endpoint(a, 1);
		Node x = new Node(left);
		Endpoint right = new Endpoint(b, -1);
		Node y = new Node(right);
		Endpoint[] newInterval = { left, right };
		intervalList.add(newInterval);
		this.getRBTree().RBInsert(x);
		this.getRBTree().RBInsert(y);
	}

	/**
	 * Method for deleting an interval from a RBT
	 * The given id is used as the index to get the endpoints located at the index of the interval list
	 * Then nodes are created with the endpoints, and a node is created from the root of the RBT
	 * Then the tree is searched for the left node first and then it will get deleted if it is not nil
	 * Then the same process occurs for the right node
     * @param intervalID the interval id of the interval you want to delete
     * @return boolean that will return true if the deletion was successful false otherwise
	 */
	public boolean intervalDelete(int intervalID) {
        if (intervalID < 1 || intervalID > intervalList.size()) {
            System.out.println("Invalid interval ID please try again");
            return false;
        }
        if (intervalList.get(intervalID - 1) == null) {
            System.out.println("Interval has already been deleted");
            return false;
        }
        Endpoint[] e = intervalList.get(intervalID - 1);

        this.getRBTree().RBDeletion(e[0].getNode());
        this.getRBTree().RBDeletion(e[1].getNode());
        intervalList.set(intervalID - 1, null);
        return true;
	}

	/**
	 * Method for finding the point of maximum overlap
	 * @return integer location where there is maximum overlap
	 */
	public int findPOM() {
        return rbTree.getRoot().getEmax().getValue();
	}

	/**
	 * Method for getting the RBT associated with the current Intervals object
     * @return the RBTree associated with the Intervals
	 */
	public RBTree getRBTree() {
		return rbTree;
	}
	
	/**
	 * Method for getting the interval list that is associated with the current Intervals object
	 * @return List of intervals
	 */
    public List<Endpoint[]> getList() {
		return this.intervalList;
	}

}
