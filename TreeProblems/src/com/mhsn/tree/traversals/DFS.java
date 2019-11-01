package com.mhsn.tree.traversals;

import com.mhsn.tree.TreeNode;


public class DFS {

	
	public static void preOrderTraversing(TreeNode root){
		
		if(root == null){
			return;
		}
		
		System.out.print(" "+root.value);
		preOrderTraversing(root.left);
		preOrderTraversing(root.right);
			
	}
	
	public static void postOrderTraversing(TreeNode root){
		
		if(root == null){
			return;
		}
		postOrderTraversing(root.left);
		postOrderTraversing(root.right);
		System.out.print(" "+root.value);
		
	}
	
	public static void inOrderTraversing(TreeNode root){
	
		if(root == null){
			return;
		}
		inOrderTraversing(root.left);
		System.out.print(" "+root.value);
		inOrderTraversing(root.right);
	}

		
	
}
