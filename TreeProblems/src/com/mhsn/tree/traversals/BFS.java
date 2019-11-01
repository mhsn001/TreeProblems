package com.mhsn.tree.traversals;

import java.util.LinkedList;
import java.util.Queue;

import com.mhsn.tree.TreeNode;


public class BFS {

public static void levelOrderTraversing(TreeNode root) {
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		if(root == null){
			System.out.println("No Elements ");
			return;
		}
		queue.add(root);
		while(!queue.isEmpty()){
			
			TreeNode n = queue.poll();
			System.out.print(n.value +" ");
			
			if(n.left != null){
				queue.add(n.left);
			}
			if(n.right != null){
				queue.add(n.right);
			}
			
		}
		
		
	}
	
}
