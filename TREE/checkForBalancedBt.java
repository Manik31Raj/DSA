/*
 * Balanced Binary Tree:
 * A tree is balanced if for every node, the height difference
 * between its left and right subtree is at most 1.
 *
 * Example (balanced):
 *         1
 *       /   \
 *      2     3
 *     / \   / \
 *    4   5 6   7
 */



import java.util.*;
import java.lang.*;
import java.io.*;

class Node{
    int data;
    Node left;
    Node right;
    public Node(int key){
        this.data=key;
    }
}

class checkForBalancedBt
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Node root=new Node(1);
		root.left=new Node(2);
	    root.right=new Node(3);
	    root.left.left=new Node(4);
	    root.left.right=new Node(5);
	    root.right.left=new Node(6);
	    root.right.right=new Node(7);
	    
	    System.out.println("Tree is Balanced Binary Tree -> "+ isBalancedBT(root));
	    System.out.println("Tree is Balanced Binary Tree -> "+maxDepth(root)==-1 ? false:true);
	    
	}
	/*
	 * Optimized approach:
	 * Instead of checking height again and again,
	 * we calculate height and check balance together.
	 *
	 * Trick:
	 * return -1 if subtree is unbalanced
	 * otherwise return its height
	 *
	 * This avoids repeated work → O(N)
	 */
	
	//Uses Recursion and formula as 1+max(left,right) + //For Balanced BT condition(every node) -> height(left)-height(right) <= 1
    public static int maxDepth(Node root){
        if(root==null) return 0;
        
        int lh=maxDepth(root.left);
        int rh=maxDepth(root.right);

		if(lh==-1 && rh==-1) return -1;
        if(Math.abs(rh-lh)>1) return -1;
        
        return 1+ Math.max(lh,rh);
    }
	
     /*
     * Brute force approach:
     * For every node, calculate left height and right height,
     * then check balance.
     *
     * Problem:
     * height() gets called multiple times → O(N^2)
     */
	
    //For Balanced BT condition(every node) -> height(left)-height(right) <= 1
    public static boolean isBalancedBT(Node root){
        if(root==null) return true;
        
        int lh=maxDepth(root.left);
        int rh=maxDepth(root.right);
        
        if(Math.abs(rh-lh)>1) return false;
        
        boolean left=isBalancedBT(root.left);
        boolean right=isBalancedBT(root.right);
        
        if(!right || ! left) return false;
        
        return true;
    }
}
