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

class DiameterOfBinaryTree
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
	    
	    System.out.println("Diameter of Binary Tree -> "+diameterOfBTree(root));
	    
	}
	public static int diameterOfBTree(Node root){
	    int[] diameter=new int[1];
	    height(root,diameter);
	    return diameter[0];
	}
	
	
	//Uses Recursion and formula as 1+max(left,right)
    public static int height(Node root,int[] diameter){
        if(root==null) return 0;
        
        int lh=height(root.left,diameter);
        int rh=height(root.right,diameter);
        
        diameter[0]=Math.max(diameter[0],lh+rh);
        
        return 1+ Math.max(lh,rh);
    }
}
