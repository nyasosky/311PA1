package classes;

public class Node {

	private int color;
	private Node parent;
	private Node left;
	private Node right;
	private int maxVal;
	private Endpoint endpoint;
	private Endpoint emax;

	public Node() {
		color = 1;
		parent = null;
		left = null;
		right = null;
		maxVal = 0;
		this.endpoint = new Endpoint(0, 0);
		emax = null;
	}

	public Node(Endpoint endpoint) {
		color = 1;
		parent = null;
		left = null;
		right = null;
		maxVal = 0;
		this.endpoint = endpoint;
		emax = null;
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
		if (this.getP() == 0) {
			return 0;
		}
		return (this.left.getVal() + this.endpoint.getP() + this.right.getVal());
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
