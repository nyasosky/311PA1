package classes;

public class RBTree {
	
	private Node root;
	private Node sentinel;
	private int size;
	
	public RBTree() {
		root = new Node();
		sentinel = new Node();
		sentinel.setColor(0);
		root = sentinel;
		root.setParent(sentinel);
		size = 0;
	}
	
	public Node getRoot() {
		return this.root;
	}
	
	public void setRoot(Node n) {
		this.root = n;
	}
	
	public Node getNILNode() {
		return this.sentinel;
	}
	
	public int getSize() {
	
		return this.size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public int getHeight() {
		if (root == sentinel) {
			return 0;
		}
		return getHeight(root);
	}

	public int getHeight(Node n) {
		if (n == sentinel) {
			return 0;
		}
		int leftHeight = getHeight(n.getLeft()) + 1;
		int rightHeight = getHeight(n.getRight()) + 1;
		if (leftHeight > rightHeight) {
			return leftHeight;
		}
		return rightHeight;
	}
	
	public void RBInsert(Node z) {
		this.setSize(this.getSize() + 1);
		Node y = new Node();
		y = this.getNILNode();
		Node x = new Node();
		x = this.getRoot();
		
		while(x != this.getNILNode()) {
			y = x;
			if (z.getKey() < x.getKey()) {
				x = x.getLeft();
			}
			else {
				x = x.getRight();
			}
		}
		z.setParent(y);
		if (y == this.getNILNode()) {
			this.setRoot(z);
			z.setColor(0);
			z.setLeft(this.getNILNode());
			z.setRight(this.getNILNode());
			return;
		}
		else if (z.getKey() < y.getKey()) {
			y.setLeft(z);
		}
		else {
			y.setRight(z);
		}
		z.setLeft(this.getNILNode());
		z.setRight(this.getNILNode());
		RBInsertFixup(z);	
	}
	
	public void RBInsertFixup(Node z) {
		while (z.getParent().getColor() == 1) {
			if (z.getParent() == z.getParent().getParent().getLeft()) {
				Node y = new Node();
				y = z.getParent().getParent().getRight();
				if (y.getColor() == 1) {
					z.getParent().setColor(0);
					y.setColor(0);
					z.getParent().getParent().setColor(1);
					z = z.getParent().getParent();
				}
				else {
					if (z == z.getParent().getRight()) {
						z = z.getParent();
						LeftRotate(z);
					}
					z.getParent().setColor(0);
					z.getParent().getParent().setColor(1);
					RightRotate(z.getParent().getParent());
				}
			}
			else {
				Node y = new Node();
				y = z.getParent().getParent().getLeft();
				if (y.getColor() == 1) {
					z.getParent().setColor(0);
					y.setColor(0);
					z.getParent().getParent().setColor(1);
					z = z.getParent().getParent();
				}
				else {
					if (z == z.getParent().getLeft()) {
						z = z.getParent();
						RightRotate(z);
					}
					z.getParent().setColor(0);
					z.getParent().getParent().setColor(1);
					LeftRotate(z.getParent().getParent());
				}
			}
		}
		this.getRoot().setColor(0);
	}
	
	public void LeftRotate(Node x) {
		Node y = new Node();
		y = x.getRight();
		x.setRight(y.getLeft());
		if (y.getLeft() != this.getNILNode()) {
			y.getLeft().setParent(x);
		}
		y.setParent(x.getParent());
		if (x.getParent() == this.getNILNode()) {
			this.setRoot(y);
		}
		else if (x == x.getParent().getLeft()) {
			x.getParent().setLeft(y);
		}
		else { 
			x.getParent().setRight(y);
		}
		y.setLeft(x);
		x.setParent(y);
	}
	
	public void RightRotate(Node x) {
		Node y = new Node();
		y = x.getLeft();
		x.setLeft(y.getRight());
		if (y.getRight() != this.getNILNode()) {
			y.getRight().setParent(x);
		}
		y.setParent(x.getParent());
		if (x.getParent() == this.getNILNode()) {
			this.setRoot(y);
		}
		else if (x == x.getParent().getLeft()) {
			x.getParent().setLeft(y);
		}
		else {
			x.getParent().setRight(y);
		}
		y.setRight(x);
		x.setParent(y);
	}
	//For testing purposes
	public void InOrderTraversal(Node z) {
		if (z == this.getNILNode()) {
			return;
		}
		InOrderTraversal(z.getLeft());
		System.out.print("Key: " + z.getKey() + "  Parent: " + z.getParent().getKey() + " Color: " + z.getColor());
		if (z.getLeft().getP() == 0)
			System.out.print(" Left: Nil Node");
		else
			System.out.print(" Left: " + z.getLeft().getKey());
		if (z.getRight().getP() == 0)
			System.out.println(" Right: Nil Node");
		else
			System.out.println(" Right: " + z.getRight().getKey());
		System.out.println("\tP: " + z.getP() + " Val: " + z.getVal());
		InOrderTraversal(z.getRight());
	}
	
}
