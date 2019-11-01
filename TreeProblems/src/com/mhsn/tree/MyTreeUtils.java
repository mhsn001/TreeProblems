package com.mhsn.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class MyTreeUtils {

	public static MyTree initiateDefaultTree(){
		
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
		
		return mTree;
	}
	
	
	
public static void addToMap(Map<Integer, List<TreeNode>> map, int hd, TreeNode node) {
		
		List<TreeNode> list = null;
		if(map.containsKey(hd)){
			 map.get(hd).add(node);
					
		}else{
			list = new ArrayList<TreeNode>();
			list.add(node);
			map.put(hd, list);
		}
				
	}
	
	
}
