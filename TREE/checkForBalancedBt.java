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
	
	//Uses Recursion and formula as 1+max(left,right) + //For Balanced BT condition(every node) -> height(left)-height(right) <= 1
    public static int maxDepth(Node root){
        if(root==null) return 0;
        
        int lh=maxDepth(root.left);
        int rh=maxDepth(root.right);

		if(lh==-1 && rh==-1) return -1;
        if(Math.abs(rh-lh)>1) return -1;
        
        return 1+ Math.max(lh,rh);
    }
    
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
