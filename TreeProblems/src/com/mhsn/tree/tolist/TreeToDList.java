package com.mhsn.tree.tolist;

import com.mhsn.tree.MyTree;
import com.mhsn.tree.MyTreeUtils;
import com.mhsn.tree.TreeNode;
import com.mhsn.tree.traversals.DFS;


public class TreeToDList {

	static TreeNode prev;
	static TreeNode head;
	
	public static void treeToDList(TreeNode root) {
		 
		if(root == null){
			return;
		}
		treeToDList(root.left);
		if(prev == null){
			head = root;
			prev = head;
		}else{
			root.left = prev;
			prev.right = root;
			prev = root;
		}		
		treeToDList(root.right);

	}
	
	private static void printDList(TreeNode head) {
		
		TreeNode temp = head;
		while(temp != null){
		System.out.print(" "+temp.value);
		temp = temp.right;
		}
		
	}
	public static void main(String[] args) {
		
		MyTree tree = MyTreeUtils.initiateDefaultTree();
		System.out.println("Pre-order traversal");
		DFS.preOrderTraversing(tree.root);
		
		treeToDList(tree.root);
		System.out.println("\nDoubly linked list");
		printDList(head);
	}

}
