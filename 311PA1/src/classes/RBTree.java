package classes;

import java.lang.Math;

public class RBTree {
	
	private Node root;
	private Node sentinel;
	private int size;
	
	public RBTree() {
		root = null;
		sentinel = null;
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
		
		return (int) Math.floor(Math.log(this.getSize())/Math.log(2));
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
		if (y.getLeft() != null) {
			y.getLeft().setParent(x);
		}
		y.setParent(x.getParent());
		if (x.getParent() == null) {
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
		if (y.getRight() != null) {
			y.getRight().setParent(x);
		}
		y.setParent(x.getParent());
		if (x.getParent() == null) {
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

}
