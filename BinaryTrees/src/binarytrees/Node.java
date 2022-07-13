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

//-----------------------------Node class--------------------------------

public class Node {
    int data;  //Declaration of data (integer values), left and right nodes
    Node left; 
    Node right;
	
    public Node(int data) { //Node constructor
	this.data = data;
    }
    
}
