package classes;
import java.lang.Math;

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
	
	public Node() {
		color = 1;
		parent = null;
		left = null;
		right = null;
		key = 0;
		p = 0;
		val = 0;
		maxVal = 0;
		endpoint = null;
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
		return key;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public int getP() {
		return p;
	}
	
	public void setP(int p) {
		this.p = p;
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
	
	public void setMaxVal() {
		this.maxVal = Math.max(this.left.getMaxVal(),Math.max(this.left.getP(), this.left.getVal() + this.getP() + this.right.getMaxVal()));
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
