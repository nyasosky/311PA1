package classes;

public class RBTree {
	
	private Node root;
	private Node sentinel;
	private int size;
	
	public RBTree() {
		root = new Node();
		sentinel = new Node();
		sentinel.setColor(1);
		sentinel.setEmax(sentinel.getEndpoint());
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

	private int getHeight(Node n) {
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
			z.setColor(1);
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
		updateNodeValues(z);
		RBInsertFixup(z);
	}
	
	public void RBInsertFixup(Node z) {
		while (z.getParent().getColor() == 0) {
			if (z.getParent() == z.getParent().getParent().getLeft()) {
				Node y = new Node();
				y = z.getParent().getParent().getRight();
				if (y.getColor() == 0) {
					z.getParent().setColor(1);
					y.setColor(1);
					z.getParent().getParent().setColor(0);
					z = z.getParent().getParent();
				}
				else {
					if (z == z.getParent().getRight()) {
						z = z.getParent();
						LeftRotate(z);
					}
					z.getParent().setColor(1);
					z.getParent().getParent().setColor(0);
					RightRotate(z.getParent().getParent());
				}
			}
			else {
				Node y = new Node();
				y = z.getParent().getParent().getLeft();
				if (y.getColor() == 0) {
					z.getParent().setColor(1);
					y.setColor(1);
					z.getParent().getParent().setColor(0);
					z = z.getParent().getParent();
				}
				else {
					if (z == z.getParent().getLeft()) {
						z = z.getParent();
						RightRotate(z);
					}
					z.getParent().setColor(1);
					z.getParent().getParent().setColor(0);
					LeftRotate(z.getParent().getParent());
				}
			}
		}
		this.getRoot().setColor(1);
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
		updateNodeValues(x);
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
		updateNodeValues(x);
	}
	//For testing purposes
	public void InOrderTraversal(Node z) {
		if (z == this.getNILNode()) {
			return;
		}
		InOrderTraversal(z.getLeft());
		System.out.print("Key: " + z.getKey() + " Color: " + z.getColor());
		if (z.getParent() == this.getNILNode())
			System.out.print(" Parent: Nil Node");
		else
			System.out.print(" Parent: " + z.getParent().getKey());
		if (z.getLeft() == this.getNILNode())
			System.out.print(" Left: Nil Node");
		else
			System.out.print(" Left: " + z.getLeft().getKey());
		if (z.getRight() == this.getNILNode())
			System.out.println(" Right: Nil Node");
		else
			System.out.println(" Right: " + z.getRight().getKey());
		System.out.print("\tP: " + z.getP() + " Val: " + z.getVal() + " Max Val: " + z.getMaxVal());
		if (z.getEmax() == this.getNILNode().getEndpoint())
			System.out.println(" Emax: Nil Node");
		else
			System.out.println(" Emax: " + z.getEmax().getValue());
		InOrderTraversal(z.getRight());
	}
	
	private void updateNodeValues(Node x) {
		if(x == this.getNILNode()) {
			x.setVal(0);
			x.setMaxVal(0);
			x.setEmax(this.getNILNode().getEmax());
		}
		else {
			x.setVal(x.getLeft().getVal() + x.getP() + x.getRight().getVal());
			x.setMaxVal(Math.max(x.getLeft().getMaxVal(),
				Math.max(x.getLeft().getVal() + x.getP(), x.getLeft().getVal() + x.getP() + x.getRight().getMaxVal())));
			if(x.getLeft().getEmax() != this.getNILNode().getEmax() && x.getMaxVal() == x.getLeft().getMaxVal()) {
				x.setEmax(x.getLeft().getEmax());
			}
			else if(x.getMaxVal() == (x.getLeft().getVal() + x.getP())){
				x.setEmax(x.getEndpoint());
			} else if (x.getRight().getEmax() != this.getNILNode().getEmax() && x.getMaxVal() == (x.getLeft().getVal() + x.getP() + x.getRight().getMaxVal())) {
				x.setEmax(x.getRight().getEmax());
			}
			else {
				x.setEmax(this.getNILNode().getEndpoint());
			}
			updateNodeValues(x.getParent());
		}
	}
	
	private void RBTransplant(Node u, Node v) {
		if (u.getParent() == this.getNILNode()) {
			this.root = v;
		}
		else if (u == u.getParent().getLeft()) {
			u.getParent().setLeft(v);
		}
		else {
			u.getParent().setRight(v);
		}
		v.setParent(u.getParent());
	}
	
	public void RBDeletion(Node z) {
		Node y = z;
		Node x;
		int yOC = y.getColor();
		if (z.getLeft() == this.getNILNode()) {
			x = z.getRight();
			RBTransplant(z, z.getRight());
		}
		else if (z.getRight() == this.getNILNode()) {
			x = z.getLeft();
			RBTransplant(z, z.getLeft());
		}
		else {
			y = Minimum(z.getRight());
			yOC = y.getColor();
			x = y.getRight();
			if (y.getParent() == z) {
				x.setParent(y);
			}
			else {
				RBTransplant(y, y.getRight());
				y.setRight(z.getRight());
				y.getRight().setParent(y);
			}
			RBTransplant(z, y);
			y.setLeft(z.getLeft());
			y.getLeft().setParent(y);
			y.setColor(z.getColor());
			if (yOC == 1) {
				RBDeleteFixup(x);
			}
		}
	}
	
	private void RBDeleteFixup(Node x) {
		while (x != this.getNILNode() && x.getColor() == 1) {
			if (x == x.getParent().getLeft()) {
				Node w = x.getParent().getRight();
				if (w.getColor() == 0) {
					w.setColor(1);
					x.getParent().setColor(0);
					LeftRotate(x.getParent());
					w = x.getParent().getRight();
				}
				if (w.getLeft().getColor() == 1 && w.getRight().getColor() == 1) {
					w.setColor(0);
					x = x.getParent();
				}
				else {
					if (w.getRight().getColor() == 1) {
						w.getLeft().setColor(1);
						w.setColor(0);
						RightRotate(w);
						w = x.getParent().getRight();
					}
					w.setColor(x.getParent().getColor());
					x.getParent().setColor(1);
					w.getRight().setColor(1);
					LeftRotate(x.getParent());
					x = this.getRoot();
				}
			}
			else {
				Node w = x.getParent().getLeft();
				if (w.getColor() == 0) {
					w.setColor(1);
					x.getParent().setColor(0);
					RightRotate(x.getParent());
					w = x.getParent().getLeft();
				}
				if (w.getLeft().getColor() == 1 && w.getRight().getColor() == 1) {
					w.setColor(0);
					x = x.getParent();
				}
				else {
					if (w.getLeft().getColor() == 1) {
						w.getRight().setColor(1);
						w.setColor(0);
						LeftRotate(w);
						w = x.getParent().getLeft();
					}
					w.setColor(x.getParent().getColor());
					x.getParent().setColor(1);
					w.getLeft().setColor(1);
					RightRotate(x.getParent());
					x = this.getRoot();
				}
			}
		}
		x.setColor(1);
		updateNodeValues(x);
	}
	
	private Node Minimum(Node x) {
		Node z = x;
		while (z.getLeft() != this.getNILNode()) {
			z = z.getLeft();
		}
		return z;
	}

	public void InOrderDeletion(Node z, Node x, Node y) {
		if (z == this.getNILNode()) {
			return;
		}
		if (z.getEndpoint() == x.getEndpoint()) {
			this.RBDeletion(z);
			//updateNodeValues(x.getParent());
		}
		if (z.getEndpoint() == y.getEndpoint()) {
			this.RBDeletion(z);
			//updateNodeValues(y.getParent());
		}
		this.InOrderDeletion(z.getLeft(), x, y);
		this.InOrderDeletion(z.getRight(), x, y);
	}
}
