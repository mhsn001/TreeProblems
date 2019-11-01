package com.mhsn.tree;



public class MyTree {

	
	
	public TreeNode root;
	
	public MyTree(){}
	public MyTree(TreeNode root){
		this.root = root;
		}
	
	// add a node in Binary tree
		public void add(int value){
		
			if(root == null){
				root = new TreeNode(value);	
				return;
			}
			addChild(root, value);
		}
		
		//add node in binary tree
		private static void addChild(TreeNode root,int value){
			//if new node is smaller than the parent child 
			if(value <= root.value){
				if(root.left == null){
					//System.out.println("Adding node "+ value +" at left of " +root.value );
					root.left = new TreeNode(value);
					return;
				}
				addChild(root.left, value);// recursion starts here until it gets null on left or right side
			}else {// or if new node is greater than the parent child than add the node at the right
				if(root.right == null ){
					//System.out.println("Adding node "+ value +" at right of " +root.value );
					root.right = new TreeNode(value);
					return;
				}
				addChild(root.right, value);// recursion starts here until it gets null on left or right side
			}
		}
		
		// To delete a node we have to replace this node either  
		//  1. with smallest node in the right sub tree of the required node
		//	2. with biggest node in the left subtree of the required node 
		public void deleteNode(int value){
					
			removeNode(root,null, value);
					
		}

		private void removeNode(TreeNode current, TreeNode parent, int value){
			// Here argument parent is parent of current node. It will be required for removing the current node	
			System.out.println("############# - 1");
			if(current.value == value){
				//Remove the node and replace a new node on deleted node
				System.out.println("############# - 2");			
				if(current.left != null && current.right != null){
					System.out.println("############# - 3");
					//If Both subtrees of the required (current)node are not null then get the highest node in the left subtree and replace it with the current node
					TreeNode temp = current.left; 
					TreeNode subTreeParent = current; // parent node of the left subtree
					while(true){
						System.out.println("############# - 4");
						if(temp.right != null){
							System.out.println("############# - 5");// to get the highest node in the left subtree move forward on right nodes 
							subTreeParent = temp;
							temp = temp.right;
						}else if(temp.left != null){ // if reaching this condition that means got the highest element(temp) in left subtree
													//  and if highest node's left is not null then we have to replace this with highest node too. 
							System.out.println("############# - 6");
							subTreeParent.right = temp.left; // replacing left node or subtree of temp node
							
							// Checking if current is left node or right node of its parent and then replacing the temp.  
							if(parent.right.value == value){
								System.out.println("############# - 7");
								parent.right = temp;
							}else{
								System.out.println("############# - 8");
								parent.left = temp;
							}
							// updating the children of newly replace node 
							temp.left = current.left;
							temp.right = current.right;
							return;						
						}else{ // if temp (which is to be replaced with current node) is leaf node
							System.out.println("############# - 9");						
							if(parent.right.value == value){
								System.out.println("############# - 10");
								parent.right = temp;
							}else{
								System.out.println("############# - 11");
								parent.left = temp;
							}
							System.out.println("############# - 12");
							
							// finding out that the leaf node is the right node or left node of its parent and then updating parent node.
							if(subTreeParent.right.value == temp.value){
								subTreeParent.right = null;
								System.out.println("############# - 13");
							}else{
								subTreeParent.left = null;
								System.out.println("############# - 14");
							}
							System.out.println("############# - 15");
							
							temp.left = current.left;
							temp.right = current.right;
							return;
						}
						
					}
					
				}else if(current.right != null){ // left node of the current node is null but not the right node then simply replace right subtree's root node with current node 
									
					if(parent.right.value == value){
						parent.right = current.right;
					}else{
						parent.left = current.right;
					}
					
				}else if(current.left != null){// right node of the current node is null but not the left node then simply replace left subtree's root node with current node 
					
					if(parent.right.value == value){
						parent.right = current.left;
					}else{
						parent.left = current.left;
					}
					
				}else{ // if current node is leaf node
					if(parent.right.value == value){
						parent.right = null;
					}else{
						parent.left = null;
					}
									
				}
				
				return;
				
			}else if(value < current.value){
				removeNode(current.left,current, value);
			}else{
				removeNode(current.right,current, value);
			}
					
			
		}
		
	
	
	
}
