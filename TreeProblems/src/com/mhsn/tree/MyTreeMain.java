package com.mhsn.tree;

import com.mhsn.tree.traversals.BFS;
import com.mhsn.tree.traversals.DFS;

public class MyTreeMain {

	public static void main(String[] args) {
		
		//Its a BST 
		MyTree mTree = new MyTree();
		mTree.add(50);
		mTree.add(30);
		mTree.add(40);
		mTree.add(60);
		mTree.add(20);
		mTree.add(55);
		mTree.add(90);
		mTree.add(56);
		mTree.add(54);
		mTree.add(57);
		
		DFS.inOrderTraversing(mTree.root);
		//BFS.levelOrderTraversing(mTree.root);
		
		
	}
}
