package com.mhsn.tree.comparison;

import com.mhsn.tree.MyTree;
import com.mhsn.tree.MyTreeUtils;
import com.mhsn.tree.TreeNode;


public class IdenticalCheck {

	
public static boolean areTreesIdentical(TreeNode t1, TreeNode t2){
		
		if(t1 == null && t2 == null){
			return true;
		}
		if(t1 == null || t2 == null){
			return false;
		}
		if(t1.value != t2.value){ 
			return false;
		}
		
		if(areTreesIdentical(t1.left, t2.left) && areTreesIdentical(t1.right, t2.right)){
			return true;
		}
		
		
		return false;
	}
	
	public static void main(String[] args) {
		MyTree t1 = MyTreeUtils.initiateDefaultTree();
		MyTree t2 = MyTreeUtils.initiateDefaultTree();
		
		System.out.println("Identical ? "+areTreesIdentical(t1.root, t2.root));
		
		MyTree tree = new MyTree();
		tree.root = new TreeNode(50);
		tree.add(30);
		tree.add(64);
		tree.add(60);
		tree.add(20);
		tree.add(55);
		tree.add(100);
		tree.add(56);
		tree.add(54);
		tree.add(57);
		
		System.out.println("Identical ? "+areTreesIdentical(t1.root, tree.root));
		
	}
	
}
