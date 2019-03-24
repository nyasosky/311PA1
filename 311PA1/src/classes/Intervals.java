package classes;

import java.util.ArrayList;
import java.util.List;

public class Intervals {

	RBTree rbTree;
	private List<Endpoint[]> intervalList; // used for testing

	public Intervals() {
		rbTree = new RBTree();
		intervalList = new ArrayList<Endpoint[]>();
	}

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

	// This method is optional
	public boolean intervalDelete(int intervalID) {

		return false; // Return false for the purpose of no errors
	}

	public int findPOM() {
		return rbTree.getRoot().getEmax().getValue(); // Return 0 for the purpose of no errors
	}

	public RBTree getRBTree() {
		return rbTree;
	}

	public List<Endpoint[]> getList() { // used for testing
		return this.intervalList;
	}

}
