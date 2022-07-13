/*
References:

Bro Code. (2019, November 20). Binary search tree [Video]. YouTube.
    https://youtu.be/Gt2yBZAhsGM

Bro Code. (2019, November 10). Tree traversal [Video]. YouTube.
    https://youtu.be/b_NjndniOqY

 */
package binarytrees;

/**
 *
 * @author trevo
 */

//-------------------------------Binary Search Tree class-------------------------------------------------

public class BinarySearchTree {
    
    Node root; //Declaration of root node
    
	//The insert method: it calls the insertHelper method which uses recursion for data insertion
	public void insert(Node node) { 
		
		root = insertHelper(root, node);
	}
	private Node insertHelper(Node root, Node node) {
		
		int data = node.data;
		
		if(root == null) { //root value is null, therefore node becomes root
			root = node;
			return root;
		}
		else if(data < root.data) { //Data less than root data, therefore inserted in left branch
			root.left = insertHelper(root.left, node);
		}
		else { //Data greater than root data, therefore inserted in right branch
			root.right = insertHelper(root.right, node);
		}
		
		return root;
	}
        
        //----------------------Methods for traversal of the binary search tree------------------------------
       
        //Pre-order tree traversal
        public void preOrderDisplay(){
            preOrderDisplayHelper(root);
        }
        /*
        * visit the root node, then the left children and then the right children
        * this process utilizes recursive calls
        */
        private void preOrderDisplayHelper(Node root){
            if(root != null){
                System.out.println(root.data); //Display root first
                preOrderDisplayHelper(root.left); //Display left childen
                preOrderDisplayHelper(root.right); //Display right children
            }
        }
        
        
        //In-order tree traversal
	public void inOrderDisplay() {
            inOrderDisplayHelper(root);
	}
        /*
        * visit all left nodes, then the root, then all right nodes
        * this process utilizes recursive calls
        */
	private void inOrderDisplayHelper(Node root){
		if(root != null) { //To check if the root node of sub tree is not null
                    inOrderDisplayHelper(root.left); //left most (least value) node is printed first  
                    System.out.println(root.data);  //the root node's data is then displayed
                    inOrderDisplayHelper(root.right);//Finally, display right node data 
		}
	}
        
        
        //Post-order tree traversal
        public void postOrderDisplay(){
            postOrderDisplayHelper(root);
        }
        //visit the left children, then the right children and then the root node
        private void postOrderDisplayHelper(Node root){
            if(root != null){
                postOrderDisplayHelper(root.left);//Left most children to be displayed
                postOrderDisplayHelper(root.right);//Right most children to be displayed
                System.out.println(root.data);//Display root
            }
        }

        
        //--------------------------------------------------------------------------------------------------
        
	
        //---------------------------------Binary tree search-----------------------------------------------
        
        public boolean search(int data) {
		return searchHelper(root, data);
	}
	private boolean searchHelper(Node root, int data) {
		
		if(root == null) { //tree is empty
			return false;
		}
		else if(root.data == data) { //data is found
			return true;
		}
		else if(root.data > data) { //data in root is greater than searched data. Go left
			return searchHelper(root.left, data);
		}
		else { //data in root is less than searched data. Go right
			return searchHelper(root.right, data);
		}
	}
        
        //-------------------------------------------------------------------------------------------------
        
        
        //-------------------------Process of deleting a node from the tree--------------------------------
        
	public void remove(int data) {
		
		if(search(data)) { //first check if data exists in tree
			removeHelper(root, data);
		}
		else { //data could not be found
			System.out.println(data + " could not be found");
		}
	}
	private Node removeHelper(Node root, int data) {
		
		if(root == null) {
			return root;
		}
                //when data to be removed is less than root data, look in left branch
		else if(data < root.data) { 
			root.left = removeHelper(root.left, data);
		}
                //when data to be removed is greater than root data, look in right branch
		else if(data > root.data) {
			root.right = removeHelper(root.right, data);
		}
                // node found containing data to be removed
		else { 
			if(root.left == null && root.right == null) { //is the node a leaf node?
				root = null;
			}
                        //Node being deleted has a right child
			else if(root.right != null) { //find a successor to replace this node since it was occupied
				root.data = successor(root);
				root.right = removeHelper(root.right, root.data);
			}
			else { //find a predecessor to replace this node
				root.data = predecessor(root);
				root.left = removeHelper(root.left, root.data);
			}
                        //This process must be done to avoid gaps and avoid losing the children of the deleted nodes
		}
		return root;
	}
	private int successor(Node root) { //find least value below the right child of this root node
		root = root.right;
		while(root.left != null){
			root = root.left;
		}
		return root.data;
	}
	private int predecessor(Node root) {//find greatest value below the left child of this root node
		root = root.left;
		while(root.right != null){
			root = root.right;
		}
		return root.data;
	}
        
        //-------------------------------------------------------------------------------------------------------------
}
