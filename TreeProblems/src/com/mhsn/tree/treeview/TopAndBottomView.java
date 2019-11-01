package com.mhsn.tree.treeview;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.mhsn.tree.MyTree;
import com.mhsn.tree.MyTreeUtils;
import com.mhsn.tree.TreeNode;
import com.mhsn.tree.traversals.VerticalOrderTraversal;


public class TopAndBottomView {

	
	
public static void topViewOfTree(TreeNode root){
		
		/*//Taking TreeMap so that it will keep the keys in sorted order
		Map<Integer, List<TreeNode>> map = new TreeMap<Integer, List<TreeNode>>();*/
		
		// Using vertical order traversal to get TreeMap which contain result for vertical order traversal
	
		VerticalOrderTraversal traverse = new VerticalOrderTraversal();
		TreeMap<Integer, List<TreeNode>> map = (TreeMap)traverse.verticalOrdTraversalUsingIteration(root);
		Set<Entry<Integer, List<TreeNode>>> keySet = map.entrySet();
		Iterator<Entry<Integer, List<TreeNode>>> it = keySet.iterator();
				
		while(it.hasNext()){
			System.out.print(" "+it.next().getValue().get(0));
		}
				
	}

	public static void bottomViewOfTree(TreeNode root){ 
		
		/*//Taking TreeMap so that it will keep the keys in sorted order
		Map<Integer, List<TreeNode>> map = new TreeMap<Integer, List<TreeNode>>();*/
		
		// Using vertical order traversal to get TreeMap which contaion result for vertical order traversal

		VerticalOrderTraversal traverse = new VerticalOrderTraversal();
		TreeMap<Integer, List<TreeNode>> map = (TreeMap)traverse.verticalOrdTraversalUsingIteration(root);
		Set<Entry<Integer, List<TreeNode>>> keySet = map.entrySet();
		Iterator<Entry<Integer, List<TreeNode>>> it = keySet.iterator();
				
		while(it.hasNext()){
			List<TreeNode> list = it.next().getValue();
			System.out.print(" "+list.get(list.size() - 1));
		}
				
	}
	
	
	public static void main(String[] args) {
		
		
		
		MyTree tree = MyTreeUtils.initiateDefaultTree();
		
		topViewOfTree(tree.root);
		
		bottomViewOfTree(tree.root);
		
		
	}
	
	
}
