package classes;

public class Node {

	private int color;
	private int val;
	private int maxVal;
	private Node parent;
	private Node left;
	private Node right;
	private Endpoint endpoint;
	private Endpoint emax;

	public Node() {
		color = 0;
		parent = null;
		left = null;
		right = null;
		val = 0;
		maxVal = 0;
		endpoint = new Endpoint(0, 0);
		emax = new Endpoint(0,0);
	}

	public Node(Endpoint endpoint) {
		color = 0;
		parent = null;
		left = null;
		right = null;
		val = 0;
		maxVal = 0;
		this.endpoint = endpoint;
		emax = endpoint;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getKey() {
		return endpoint.getValue();
	}

	public int getP() {
		return endpoint.getP();
	}

	public int getVal() {
		return val;
	}
	
	public void setVal(int val) {
		this.val = val;
	}

	public int getMaxVal() {
		return maxVal;
	}
	
	public void setMaxVal(int maxVal) {
		this.maxVal = maxVal;
	}

	public Endpoint getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(Endpoint endpoint) {
		this.endpoint = endpoint;
	}

	public Endpoint getEmax() {
		return emax;
	}
	
	public void setEmax(Endpoint emax) {
		this.emax = emax;
	}
}