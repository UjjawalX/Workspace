package org.trees;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinarySearchTree {
	public Node root;

	public static void main(String[] args) {
		BinarySearchTree b = new BinarySearchTree();
		String st;
		Scanner sc = new Scanner(System.in);
		System.out.println("keep entering numbers . enter string when exit");
		do {
			
			st = sc.nextLine();
			
			if (st.matches("^[0-9]+$")) {
				b.insertNode(st);
			}
			else {
				break;
				
			}
		} while(true);
		System.out.println("inorder traversal of BST:");
		b.printTreeInOrder();
		System.out.println("Delete a number");
		st = sc.nextLine();
		if (st.matches("^[0-9]+$")) {
			Node deleted = b.deleteNode(st);
			if (deleted != null)
				System.out.println("Deleted node" + deleted);
			else
				System.out.println("problem deleting node");
		} else {
			System.out.println("Entered string is not number");
		}
		System.out.println("inorder traversal of BST:");
		b.printTreeInOrder();

	}

	public boolean insertNode(String msg) {
		Node newNode = new Node(msg);
		if (root != null) {
			Node x = root;
			Node y = null;
			while (x != null) {
				y = x;
				// newNode < x
				if (compareNode(newNode.data, x.data) == -1) {
					x = x.leftchild;
				} // newNode < x
				else {
					x = x.rightchild;
				}
			}
			newNode.parent = y;
			if (compareNode(newNode.data, y.data) == -1) {
				y.leftchild = newNode;
			} else {
				y.rightchild = newNode;
			}
		} else {
			root = newNode;
			root.leftchild = null;
			root.rightchild = null;
		}
		return true;
	}

	// prints elements in sorted order
	public void printTreeInOrder() {
		Node x = root;

		List<Node> stack = new ArrayList<>();

		do {
			if (x != null) {
				stack.add(x);
				x = x.leftchild;
			}
			if (x == null) {

				x = pop(stack);
				System.out.println(x);
				x = x.rightchild;
			}
		} while (!stack.isEmpty() || x != null);

	}

	private Node pop(List<Node> stack) {
		Node x;
		x = stack.get(stack.size() - 1);
		stack.remove(stack.size() - 1);
		return x;
	}

	private int compareNode(String compare, String compareTo) {
		if (Integer.parseInt(compare) < Integer.parseInt(compareTo)) {
			return -1;
		} else if (Integer.parseInt(compare) > Integer.parseInt(compareTo)) {
			return 1;
		} else {
			return 0;
		}
	}

	public Node searchNode(String y) {
		Node cur = root;
		do {
			if (compareNode(y, cur.data) == -1)
				cur = cur.leftchild;
			else if (compareNode(y, cur.data) == 1)
				cur = cur.rightchild;
			else
				return cur;
		} while (cur != null);
		return null;
	}

	public Node deleteNode(String val) {
		Node z = searchNode(val);
		if (z != null) {
			// no child or one child
			if (z.leftchild == null || z.rightchild == null) {
				// no child
				if (z.leftchild == null && z.rightchild == null) {
					Node p = z.parent;
					if (z == p.leftchild)
						p.leftchild = null;
					else
						p.rightchild = null;
				}
				// only one child
				else {
					if (z.rightchild != null) {
						replaceZwithM(z, z.rightchild);
					} else {
						replaceZwithM(z, z.leftchild);
					}
				}
			} // if both the childs are present
			else {
				Node m = findSuccessor(z);
				if (m == z.rightchild) {
					replaceZwithM(z, m);
				} else {
					replaceZwithM(m, m.rightchild);
					replaceZwithM(z, m);
				}
			}
			return z;
		} else {
			return null;
		}
	}

	/**
	 * Replaces z with m
	 * 
	 * @param z
	 *            to be replaced
	 * @param m
	 *            one going to replace z
	 */
	private void replaceZwithM(Node z, Node m) {

		Node p = z.parent;
		// interaction wtih parent
		if (p != null) {
			if (p.rightchild == z)
				p.rightchild = m;
			else
				p.leftchild = m;
		} else {
			this.root = m;
		}
		if (m != null) {
			m.parent = p;

			// interaction with childs
			if (z.rightchild == m) {
				m.leftchild = z.leftchild;
				if (z.leftchild != null)
					z.leftchild.parent = m;
			} else if (z.leftchild == m) {
				m.rightchild = z.rightchild;
				if (z.rightchild != null)
					z.rightchild.parent = m;
			} else {
				m.leftchild = z.leftchild;
				if (z.leftchild != null)
					z.leftchild.parent = m;
				m.rightchild = z.rightchild;
				if (z.rightchild != null)
					z.rightchild.parent = m;
			}
		}
	}

	private Node findSuccessor(Node z) {
		if (z.rightchild != null) {
			Node x = z.rightchild;
			while (x.leftchild != null) {
				x = x.leftchild;
			}
			return x;
		}
		return null;
	}
}

class Node {
	Node leftchild;
	Node rightchild;
	Node parent;
	String data;

	public Node(String str) {
		data = str;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}

}