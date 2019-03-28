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
        if (intervalID < 1 || intervalID > intervalList.size() + 1) {
            System.out.println("Invalid interval ID please try again");
            return false;
        }
        Endpoint[] e = intervalList.get(intervalID - 1);
        Node left = new Node(e[0]);
        Node right = new Node(e[1]);

        Node root = this.getRBTree().getRoot();
        
        Node toDelete = this.getRBTree().search(root, left);
        if (toDelete != this.getRBTree().getNILNode()) {
        	this.getRBTree().RBDeletion(toDelete);
        }
        toDelete = this.getRBTree().search(root, right);
        if (toDelete != this.getRBTree().getNILNode()) {
        	this.getRBTree().RBDeletion(toDelete);
        }
        
        //this.getRBTree().InOrderDeletion(z, x, y);

        return true; // Return false for the purpose of no errors
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
