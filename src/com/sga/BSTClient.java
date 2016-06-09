package com.sga;

import com.sga.datastructure.BST;


/**
 * Builds a Binary Search Tree as follows:
 * 
 * 										10
 *								/				\
 * 							5						15
 *						/		\					/\	
 * 					3				8			14		20
 *					/\				/\
 * 				   2  4		       7  9
 *				  /
 * 			     1
 * 
 *	
 * @author alex imbastari
 *
 */
public class BSTClient {
		
	//Build the tree (For simplicity the Key and Value are the same here)
	final private BST<Integer, Integer> bst = new BST<>();; 
	
	public BSTClient(){
		//root
		bst.put(10, 10);
		
		//left sub tree
		bst.put(5, 5);
		bst.put(3, 3);
		bst.put(8, 8);
		bst.put(2, 2);
		bst.put(4, 4);
		bst.put(7, 7);
		bst.put(9, 9);
		bst.put(1, 1);
		
		//right sub tree
		bst.put(15, 15);
		bst.put(14, 14);
		bst.put(20, 20);
		
		
	}
	

	private Integer findCommonParent(Integer key1, Integer key2){
		Integer commonParentKey = bst.findCommonParent(key1, key2);
		
		return commonParentKey;
	}
	
	
	public static void main(String[] args) {
		BSTClient bstClient = new BSTClient();

		System.out.println("Case 1: Find Common Parent for Nodes with Keys 2 and 20");
		System.out.println("Expected Value is 10");
		System.out.println("Actual Value is " + bstClient.findCommonParent(2, 20));

		System.out.println("");
		
		System.out.println("Case 2: Find Common Parent for Nodes with Keys 3 and 9");
		System.out.println("Expected Value is 5");
		System.out.println("Actual Value is " + bstClient.findCommonParent(3, 9));
		
		System.out.println("");
		
		System.out.println("Case 3: Find Common Parent for Nodes with Keys 7 and 9");
		System.out.println("Expected Value is 8");
		System.out.println("Actual Value is " + bstClient.findCommonParent(7, 9));
		
		System.out.println("");
		
		System.out.println("Case 4: Find Common Parent for Nodes with Keys 2 and 3");
		System.out.println("Expected Value is 5");
		System.out.println("Actual Value is " + bstClient.findCommonParent(2, 3));
		
		System.out.println("");
		
		System.out.println("Case 5: Find Common Parent for Nodes with Keys 30 and 3");
		System.out.println("Expected Value is null");
		System.out.println("Actual Value is " + bstClient.findCommonParent(30, 3));
		
	}

}
