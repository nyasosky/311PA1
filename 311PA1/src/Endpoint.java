/**
 * Class for an endpoint to be associated with a node
 * @author Ryan Connolly and Nathan Yasosky
 *
 */
public class Endpoint {

	/**
	 * Value of the endpoint
	 */
	private int value;
	
	/**
	 * Value to determine if the endpoint is a left or right endpoint, 1 for left, -1 for right
	 */
	private int p;
	
	/**
	 * Reference to the node that the endpoint is associated with
	 */
	private Node node;

	/**
	 * Constructor for an endpoint object
	 * Each endpoint will have a value and a p value
	 * @param value This is the true value that an endpoint will hold
	 * @param p This value is used to determine if the endpoint is a left or right endpoint, it will be either -1 or 1
	 */
	public Endpoint(int value, int p) {
		this.value = value;
		this.p = p;
		this.node = null;
	}

	/**
	 * Method for getting the value of an endpoint
	 * @return The value that the endpoint holds
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 * Method for knowing if an endpoint is a left or right endpoint
	 * @return The p value, 1 for left endpoint, and -1 for right endpoint
	 */
	public int getP() {
		return this.p;
	}
	
	/**
	 * Method for getting the node that the endpoint is associated with 
	 * @return The node that the endpoint is associated with
	 */
	public Node getNode() {
		return this.node;
	}
	
	/**
	 * Method to set the node reference
	 * @param n The reference node
	 */
	public void setNode(Node n) {
		this.node = n;
	}
}
