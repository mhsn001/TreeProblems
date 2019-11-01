package com.mhsn.tree;


public class TreeNode {

	public int value;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(){}
	
	public TreeNode(int value){
		this.value = value;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+value;
	}
}
