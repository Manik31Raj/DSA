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
class CheckForValidBST
{
	public static void main (String[] args)
	{
	   Node root = new Node(13);
       root.left = new Node(10);
       root.right = new Node(15);
       root.right.left=new Node(14);
       root.right.right=new Node(17);
       root.right.right.left=new Node(16);
       root.left.left=new Node(7);
       root.left.right=new Node(12);
       root.left.left.right=new Node(9);
       root.left.left.right.left=new Node(8);
       
       System.out.println("Is Given Bianry Tree is a valid Binary Search Tree -> "+isValidBST(root));
	}
	
	public static boolean isValidBST(Node root){
	   return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
	}
	
	public static boolean isValidBST(Node root,long minVal,long maxVal){
	    if(root==null) return true;
	    if(root.data>=maxVal || root.data<=minVal) return false;
	    
	    return isValidBST(root.left,minVal,root.data) && isValidBST(root.right,root.data,maxVal);
	}
}
