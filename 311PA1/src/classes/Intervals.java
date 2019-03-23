package classes;

public class Intervals {
	
	RBTree t = new RBTree();
	private int[][] list = new int[5][5]; //used for testing

	public Intervals() {
		t = new RBTree();
		list[0][0] = 1;
	}
	
	void intervalInsert(int a, int b) {
		Endpoint left = new Endpoint(a, -1);
		Node x = new Node();
		x.setEndpoint(left);
		x.setKey(left.getValue());
		Endpoint right = new Endpoint(b, 1);
		Node y = new Node();
		y.setEndpoint(right);
		y.setKey(right.getValue());
		
		this.getRBTree().RBInsert(x);
		this.getRBTree().RBInsert(y);
			}
	
	//This method is optional
	boolean intervalDelete(int intervalID) {
		
		return false; //Return false for the purpose of no errors
	}
	
	int findPOM() {
		
		return 0; //Return 0 for the purpose of no errors
	}
	
	RBTree getRBTree() {
		return new RBTree();
	}
	
	int[][] getList(){ //used for testing
		return this.list;
	}
	
}
