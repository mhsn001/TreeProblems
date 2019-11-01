package com.mhsn.tree.treeview;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.mhsn.tree.MyTree;
import com.mhsn.tree.MyTreeUtils;
import com.mhsn.tree.TreeNode;


public class TreeSideView {
	
	//For side view we use only level order traversal no need of vertical level traversal
		public static  Map<Integer, List<TreeNode>> sideViewWithBFS(TreeNode root) {
				
				Queue<TreeNode> queue = new LinkedList<TreeNode>(); // for node queue
				Queue<Integer> levelQueue = new LinkedList<Integer>();// to keep the level number with respect to node queq
				
				Map<Integer, List<TreeNode>> map = new TreeMap<Integer, List<TreeNode>>(); // to group nodes on level basis
				
				if(root == null){
					System.out.println("No Elements ");
					return null;
				}
			
				queue.add(root); // add root to queue
				levelQueue.add(0); // add level of root node
				MyTreeUtils.addToMap(map, 0, root); // add to map where level number is key
							
				while(queue.size() > 0){
								
					TreeNode n = queue.poll(); // dequeue the node
					int level = levelQueue.poll(); // dequeue the level of the node
								
					if(n.left != null){
						queue.add(n.left);// add left to queue
						levelQueue.add(level+1);// add level of left node
						MyTreeUtils.addToMap(map, level+1, n.left);// add to map where level number is key
					}
					if(n.right != null){
						queue.add(n.right);
						levelQueue.add(level+1);
						MyTreeUtils.addToMap(map, level+1 , n.right);
					}
							
				}
				
				System.out.println(map);
					
				//Code for printing Left and right side views
				Set<Entry<Integer, List<TreeNode>>> keySet = map.entrySet();
				Iterator<Entry<Integer, List<TreeNode>>> it = keySet.iterator();
				
				System.out.print("\t Left side view :");		
				//print first element of each list of TreeNode
				while(it.hasNext()){
					System.out.print(" "+it.next().getValue().get(0));
				}
				
				System.out.print("\n\t Right side view :");
				it = keySet.iterator();
				//print last element of each list of TreeNode
				while(it.hasNext()){
					List<TreeNode> list = it.next().getValue();
					System.out.print(" "+list.get(list.size() - 1));
				}
						
				return map;
				
			}
		
		
		public static void main(String[] args) {
			MyTree tree = MyTreeUtils.initiateDefaultTree();
			sideViewWithBFS(tree.root);
		}

}
