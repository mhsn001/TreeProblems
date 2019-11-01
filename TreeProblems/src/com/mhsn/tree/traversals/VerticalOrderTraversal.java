package com.mhsn.tree.traversals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import javafx.util.Pair;

import com.mhsn.tree.MyTree;
import com.mhsn.tree.MyTreeUtils;
import com.mhsn.tree.TreeNode;



public class VerticalOrderTraversal {

		//This algo uses level order traversal(BFS)
		public static Map<Integer, List<TreeNode>> verticalOrdTraversalUsingIteration(TreeNode root) {
			
			//Using Map to retain the HD value and list of nodes 
			//Better use TreeMap so that keys will be in natural sorted order 
			Map<Integer, List<TreeNode>> map = new TreeMap<Integer, List<TreeNode>>();
			
			int hd = 0; //Horizontal distance
			Queue<Pair<TreeNode, Integer>> queue = new LinkedList<Pair<TreeNode, Integer>>(); //To keep nodes and hd as pair in queue
					
			queue.add(new Pair(root, 0)); // enqueuing root
			
			List<TreeNode> l = new ArrayList<TreeNode>();
			l.add(root); 
			map.put(0, l); // adding entry to map
			
			int minHD = 0;
			int maxHD = 0;
			while(!queue.isEmpty()){
			
			//dequeuing the head of queue of nodes
			Pair<TreeNode, Integer> pair = queue.remove();
			//dequeuing the HD of node
			TreeNode node = pair.getKey();
			hd = pair.getValue();
			if(node.left != null){
				queue.add(new Pair(node.left, hd-1));
				//hdQueue.add(hd-1);
				MyTreeUtils.addToMap(map, hd-1, node.left);
				minHD = Math.min(minHD, hd-1);
			}
			if(node.right != null){
				queue.add(new Pair(node.right, hd+1));
				//hdQueue.add(hd+1);
				MyTreeUtils.addToMap(map, hd+1, node.right);
				maxHD = Math.max(maxHD, hd+1);
			}
		}
			System.out.println("minHD : "+minHD+ "  maxHD : "+maxHD);
			
			
			return map;
			
		}
	
	
		
		
		public static Map<Integer, List<TreeNode>> verticalOrdTraversalByRecursion(TreeNode root) {
			
			Map<Integer, List<TreeNode>> map = new TreeMap<Integer, List<TreeNode>>();
			
			verOrdRecur(root,0, map);
			//System.out.println(map);
			return map;
		}
		
		// Vertical order traversal using recursion
		private static void verOrdRecur(TreeNode root,int hd, Map<Integer, List<TreeNode>> map) {
			if(root == null){
				return;
			}	
			MyTreeUtils.addToMap(map, hd, root);
			verOrdRecur(root.left, hd-1, map);
			verOrdRecur(root.right, hd+1, map);
		}
		
		
		
		public static void main(String[] args) {
			
			MyTree tree = MyTreeUtils.initiateDefaultTree();
			System.out.print("\nVertical Order  : ");
			
			Map<Integer,List<TreeNode>> map = verticalOrdTraversalUsingIteration(tree.root);
			System.out.println(map);
			
			map = verticalOrdTraversalByRecursion(tree.root);
			System.out.println(map);
			
			
		}
	
	
}
