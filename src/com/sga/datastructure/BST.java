package com.sga.datastructure;

/**
 * Generic Implementation of Binary Search Tree.
 * Each node in the tree keeps track of its parent and in addition its left and right children.
 *
 * (This is a minimalistic implementation to prove the find common parent algorithm, many other usefull methods are
 * missing such as rank, delete, min, max etc...)
 * 
 * @author alex imbastari
 *
 * @param <Key> Must implement Comparable (natural ordering)
 * @param <Value> Value attached to BST Node
 */
public class BST<Key extends Comparable<Key>, Value> {
	
	/**
	 * Represents a Node in the BST
	 * 
	 * @author alex imbastari
	 *
	 */
	private class Node{
		private Key key;
		private Value val;
		private Node left, right, parentNode;
		private int N;
		private boolean marked;
		
		public Node(Key key, Value val, int N, boolean marked, Node parentNode){
			this.key = key;
			this.val = val;
			this.N = N;
			this.marked = false;
			this.parentNode = parentNode;
		}
	}
	
	//The root node
	private Node root;
	
	public int size(){
		return size(root);	
	}

	private int size(Node x){
		if (x== null) 
			return 0;
		else
			return x.N;
	}

	public Value get(Key key) { 
		Node node = getNode(root, key);
		if(node == null)
			return null;
		else
			return node.val;
		
	}
	
	/**
	 * Return node associated with key in the subtree rooted at x; 
	 * Return null if key not present in subtree rooted at x. 
	 *
	 * @param key Key used 
	 * @return Node 
	 */
	public Node getNode(Key key) { 
		return getNode(root, key);
	}
	
	private Node getNode(Node x, Key key) { 
		if (x == null) 
			return null; 
		
		int cmp = key.compareTo(x.key); 
		
		if (cmp < 0) 
			return getNode(x.left, key); 
		else if (cmp > 0) 
			return getNode(x.right, key); 
		else
			return x; 
	}

	/**
	 * Search for key. Update value if found; grow tree if new. 
	 * 
	 * @param key
	 * @param val
	 */
	public void put(Key key, Value val) { 
		root = put(null, root, key, val); 
	}
	
	private Node put(Node parentNode, Node x, Key key, Value val) { 
		// Change key's value to val if key in subtree rooted at x. 
		// Otherwise, add new node to subtree associating key with val. 
		if (x == null) 
			return new Node(key, val, 1, false, parentNode); 
		
		int cmp = key.compareTo(x.key); 
		if (cmp < 0) 
			x.left = put(x, x.left, key, val); 
		else if (cmp > 0) 
			x.right = put(x, x.right, key, val); 
		else{ 
			x.val = val; 
			x.N = size(x.left) + size(x.right) + 1;
		}
		
		return x; 
	}
	
	
	/**
	 * Finds common parent given 2 keys
	 * If either node cannot be found then return null
	 * 
	 * @param key1 First Node to search for 
	 * @param key2 Second Node to search for
	 * @return
	 */
	public Key findCommonParent(Key key1, Key key2){
		
		//1) Search for first Node and mark the nodes touched
		Node node1 = getNode(key1);
		if(node1 == null)
			return null;
		
		//2) Search for second Node
		Node node2 = getNode(key2);
		if(node2 == null)
			return null;
		
		//3) Iterate from node1 towards root, marking the nodes
		Node parentNode = node1.parentNode;
		while(parentNode != null){
			parentNode.marked = true;
			parentNode = parentNode.parentNode;
		}
		
		//4) Iterate from node2 towards root until the first marked node is reached.  
		//That is the first common parent for both nodes.
		Node commonParentNode = node2.parentNode;
		while(commonParentNode != null){
			if(commonParentNode.marked){
				break;
			}
			
			commonParentNode = commonParentNode.parentNode;
		}

		//Clear marked nodes for next iteration
		while(parentNode != null){
			parentNode.marked = false;
			parentNode = parentNode.parentNode;
		}
		
		return commonParentNode.key;
	}

}
