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
//----------------Class Main that is used to test methods-----------------
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        
        //--------------------Process of inserting data into the tree---------------
 
        tree.insert(new Node(5));
    	tree.insert(new Node(2));
    	tree.insert(new Node(7));
        tree.insert(new Node(9));
        tree.insert(new Node(1));
    	tree.insert(new Node(3));
    	tree.insert(new Node(6));
    	tree.insert(new Node(4));
    	tree.insert(new Node(8));
        
        //---------------------Process of displaying the binary tree----------------
        //tree.preOrderDisplay();
        //tree.inOrderDisplay();
        //tree.postOrderDisplay();
        
        
        //---------------------Process of searching for a node-----------------------
        //returns true if the data is available, false otherwise
        //System.out.println(tree.search(1));
        
        
        
        //---------------------Process of removing a node----------------------------
        /*
        tree.remove(1);
        tree.display();
        */
        
    }
    
}
