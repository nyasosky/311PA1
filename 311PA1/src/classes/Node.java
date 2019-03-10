package classes;

public class Node {

	private int color;
	private Node parent;
	private Node left;
	private Node right;
	private int key;
	private int p;
	private int val;
	private int maxVal;
	private Endpoint endpoint;
	private Endpoint emax;
	
	//test
	public Node getParent() {
		return this.parent;
	}
	
	public Node getLeft() {
		return this.left;
	}
	
	public Node getRight() {
		return this.right;
	}
	
	public int getKey() {
		return this.key;
	}
	
	public int getP() {
		return this.p;
	}
	
	public int getVal() {
		return this.val;
	}
	
	public int getMaxVal() {
		return this.maxVal;
	}
	
	public Endpoint getEndpoint() {
		return this.endpoint;
	}
	
	public Endpoint getEmax() {
		return this.emax;
	}
	
	public int getColor() {
		return this.color;
	}
}
