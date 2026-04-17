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

class MaximumPathSumOfBinaryTree
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
	    
	    System.out.println("MAX Path Sum of Binary Tree -> "+maxPathSum(root));
	    
	}
	public static int maxPathSum(Node root){
	    int[] maxSum=new int[1];
	    maxPath(root,maxSum);
	    return maxSum[0];
	}
	
	
    public static int maxPath(Node root,int[] maxSum){
        if(root==null) return 0;
        
        int lh=Math.max(0,maxPath(root.left,maxSum));
        int rh=Math.max(0,maxPath(root.right,maxSum));
        
        maxSum[0]=Math.max(maxSum[0],lh+rh+root.data);
        
        return Math.max(lh,rh)+root.data;
    }
}
