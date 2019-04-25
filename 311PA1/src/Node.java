/**
 * Class for a node within a RBT
 * @author Ryan Connolly and Nathan Yasosky
 *
 */
public class Node {

	/**
	 * Color value of the node, 1 for black, 0 for red
	 */
	private int color;
	
	/**
	 * Value of the node
	 */
	private int val;
	
	/**
	 * Max sum of p values from a node and its subtrees
	 */
	private int maxVal;
	
	/**
	 * Parent of the node
	 */
	private Node parent;
	
	/**
	 * Left child of the node
	 */
	private Node left;
	
	/**
	 * Right child of the node
	 */
	private Node right;
	
	/**
	 * Endpoint associated with the node
	 */
	private Endpoint endpoint;
	
	/**
	 * Endpoint with the most overlap from a node and its subtrees
	 */
	private Endpoint emax;

    /**
     * The height of the node's subtree
     */
    private int height;

	/**
	 * Constructor for a node object
	 * Each node will have a color, parent node, left child node, right child node,
	 * a value, a maximum value, an endpoint associated with the node, and a max overlap endpoint
	 */
	public Node() {
		color = 0;
		parent = null;
		left = null;
		right = null;
		val = 0;
		maxVal = 0;
		height = 0;
		endpoint = new Endpoint(0, 0);
		this.endpoint.setNode(this);
		emax = new Endpoint(0,0);
	}

	/**
	 * This is a Node constructor that will take in an endpoint right away
	 * @param endpoint Endpoint object to be associated with the node
	 */
	public Node(Endpoint endpoint) {
		color = 0;
		parent = null;
		left = null;
		right = null;
		val = 0;
		maxVal = 0;
		height = 0;
		this.endpoint = endpoint;
		this.endpoint.setNode(this);
		emax = endpoint;
	}

	/**
	 * Method for getting the color of the node
	 * @return The color value of the node
	 */
	public int getColor() {
		return color;
	}

	/**
	 * Method for setting the color value of a node
	 * @param color The value determining the color, 1 for black, 0 for red
	 */
	public void setColor(int color) {
		this.color = color;
	}

	/**
	 * Method for getting the parent of the current node
	 * @return The parent of the current node
	 */
	public Node getParent() {
		return parent;
	}

	/**
	 * Method for setting the parent of the current node
	 * @param parent Node to be set as parent of the current node
	 */
	public void setParent(Node parent) {
		this.parent = parent;
	}

	/**
	 * Method for getting the left child node of the current node
	 * @return The left child node of the current node
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * Method for setting the left child node of the current node
	 * @param left The node to be made the left child of the current node
	 */
	public void setLeft(Node left) {
		this.left = left;
	}

	/**
	 * method for getting the right child node of the current node
	 * @return The right child node of the current node
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * Method for setting the right child of the current node
	 * @param right Node to be made the right child of the current node
	 */
	public void setRight(Node right) {
		this.right = right;
	}

	/**
	 * Method for getting the key of the current node
	 * @return The key of the node or endpoint value of the node
	 */
	public int getKey() {
		return endpoint.getValue();
	}

	/**
	 * Method for getting the P value of the node
	 * @return The p value of the endpoint associated with the node
	 */
	public int getP() {
		return endpoint.getP();
	}

	/**
	 * Method for getting the value of the node
	 * @return The value of the node
	 */
	public int getVal() {
		return val;
	}
	
	/**
	 * Method for setting the value of the node
	 * @param val Integer value to be made the value of the node
	 */
	public void setVal(int val) {
		this.val = val;
	}

	/**
	 * Method for getting the maxval of the node
	 * @return the maxval of the node
	 */
	public int getMaxVal() {
		return maxVal;
	}
	
	/**
	 * Method for setting the maxval of the node
	 * @param maxVal The desired value for the maxval of the node
	 */
	public void setMaxVal(int maxVal) {
		this.maxVal = maxVal;
	}

	/**
	 * Method for getting the endpoint associated with the node
	 * @return The endpoint associated with the node
	 */
	public Endpoint getEndpoint() {
		return endpoint;
	}

	/**
	 * Method for setting the endpoint associated with the node
	 * @param endpoint Endpoint to be associated with the node
	 */
	public void setEndpoint(Endpoint endpoint) {
		this.endpoint = endpoint;
		this.endpoint.setNode(this);
	}

	/**
	 * Method for getting the emax of the node
	 * @return The emax of the node
	 */
	public Endpoint getEmax() {
		return emax;
	}
	
	/**
	 * method for setting the emax of the node
	 * @param emax The endpoint that will be the emax of the node
	 */
	public void setEmax(Endpoint emax) {
		this.emax = emax;
	}

	/**
	 * Method for getting the height of the node's subtree
	 *
	 * @return The height of the node's subtree
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * method for setting the height of the node's subtree
     *
     * @param height The int that will be the height of the node's subtree
	 */
	public void setHeight(int height) {
		this.height = height;
	}
}