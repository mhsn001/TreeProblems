package com.mhsn.tree.comparison;

import com.mhsn.tree.MyTree;
import com.mhsn.tree.MyTreeUtils;
import com.mhsn.tree.TreeNode;

public class SubTreeCheck {

	
	public static boolean isSubTree(TreeNode mainNode, TreeNode sub){
		
		if(mainNode == null){
			return false;
		}
		if(mainNode.value == sub.value){
			return IdenticalCheck.areTreesIdentical(mainNode, sub);
		}
		
		if(isSubTree(mainNode.left, sub) || isSubTree(mainNode.right, sub)){
			return true;
		}
		
		
		return false;
	}
	
	public static void main(String[] args) {
		MyTree t1 = MyTreeUtils.initiateDefaultTree();
		
		MyTree tree = new MyTree();
		tree.add(60);
		tree.add(55);
		tree.add(90);
		tree.add(56);
		tree.add(54);
		tree.add(57);
		
		System.out.println("Sub Tree ? "+isSubTree(t1.root, tree.root));
		
		
		tree = new MyTree();
		tree.add(60);
		tree.add(58); // odd node
		tree.add(90);
		tree.add(56);
		tree.add(54);
		tree.add(57);
		
		System.out.println("Sub Tree ? "+isSubTree(t1.root, tree.root));
		
	}
	
}
