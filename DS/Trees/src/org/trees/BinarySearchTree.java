package org.trees;

public class BinarySearchTree {
	public Node root;
	public boolean insertNode(String msg){
		if(root!=null) {
			
		} else {
			root = new Node("msg");
		}
		return false;
	}
	
	public Node traverseTree(Node node) {
		
		return null;
	}
	public int compareNode(Node compare, Node compareTo) {
		if(Integer.parseInt(compare.data)<Integer.parseInt(compareTo.data)) {
			return -1;
		} else if(Integer.parseInt(compare.data)>Integer.parseInt(compareTo.data)){
			return 1;
		} else {
			return 0;
		}
	}
}

class Node{
	Node left;
	Node right;
	String data;
	public Node(String str) {
		data = str;
		
	}
}