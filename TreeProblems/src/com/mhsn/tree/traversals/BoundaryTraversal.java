package com.mhsn.tree.traversals;

import com.mhsn.tree.MyTree;
import com.mhsn.tree.MyTreeUtils;
import com.mhsn.tree.TreeNode;


public class BoundaryTraversal {
	
	public static void boundaryTraversal(TreeNode root) {
		// TODO Auto-generated method stub
		if(root == null){
			System.out.println("No elements found ");
			return;
		}
	
		System.out.println("\nleft print");
		leftPrint(root);
		System.out.println("\nleaf print");
		leafPrint(root);
		System.out.println("\nright print");
		rightPrint(root.right);
	
	}

	private static void leftPrint(TreeNode root){
		
		if(root != null){
			
			/*if(root.left != null || root.right != null){
				System.out.println(" "+root.value);
			}*/
			if(root.left != null){
				System.out.print(" "+root.value);
				leftPrint(root.left);
				
			}
			else if(root.right != null){
				System.out.print(" "+root.value);
				leftPrint(root.right);
			}
		}
		
		if(root.right != null && root.right.left != null){
			leftPrint(root.right.left);
		}
	}

	private static void rightPrint(TreeNode root){
		if(root != null){
				if(root.right != null){
				System.out.print(" "+root.value);
				leftPrint(root.right);
				
			}
				else if(root.left != null){
				System.out.print(" "+root.value);
				leftPrint(root.left);
			}
		}
		
		if(root.left != null && root.left.right != null){
			leftPrint(root.left.right);
		}
	}

	private static void leafPrint(TreeNode root){
		
		if(root != null){
			
			if(root.left == null && root.right == null){
				System.out.print(" "+root.value);
			}else{
				leafPrint(root.left);
				leafPrint(root.right);
			}
						
		}
		
	}
	
	
	public static void main(String[] args) {
		MyTree tree = MyTreeUtils.initiateDefaultTree();
		boundaryTraversal(tree.root);
	}
	
}
