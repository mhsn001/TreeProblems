package com.mhsn.tree.traversals;

import java.util.LinkedList;
import java.util.Queue;

import com.mhsn.tree.MyTree;
import com.mhsn.tree.MyTreeUtils;
import com.mhsn.tree.TreeNode;



public class DiagonalTraverse {

	//This implementation is based on in order traversal 
	public static void traversDiagonaly(TreeNode root){
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null); // Adding null means end of one level,s diagonal nodes
		
		while(!queue.isEmpty()){
			//getting node from queue
			TreeNode node = queue.remove();

			//if getting null in the queue that means nodes of same level are removed from queue
			if(node == null && !queue.isEmpty() && queue.element() != null){
				System.out.println(); // print next line
				queue.add(null); // add null for next level
			}else if(!queue.isEmpty()){
				//traversing through the right node and adding left node in the queue
				traverseRightNode(node, queue);
			}
		}
				
	}
		//traversDiagonaly
		private static void traverseRightNode(TreeNode node, Queue<TreeNode> queue) {

		//print the node
		System.out.print(" "+node.value);
		if(node.left != null){
			//adding left node in the queue
			queue.add(node.left);
		}
		if(node.right != null){
		//traverse the right node
		 traverseRightNode(node.right, queue);
		}
	}

	public static void main(String[] args) {
		MyTree tree = MyTreeUtils.initiateDefaultTree();
		traversDiagonaly(tree.root);
		
	}
	
}
