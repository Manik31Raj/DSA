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

class SymmetricBTree        
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
	    
	    System.out.println("isSymmetricBTree  - > "+isSymmetricBTree(root));
	   
	}
	public static boolean isSymmetricBTree(Node root){
	       
	       return root==null || isSymmetricBTreeHelp(root.left,root.right);
	}
	
	private static boolean isSymmetricBTreeHelp(Node left,Node right){
	    
	    if(left==null || right==null){
	        return right==left;
	    }
	    
	    if(left.data!=right.data){
	        return false;
	    }
	    
	    return isSymmetricBTreeHelp(left.left, right.right) &&
           isSymmetricBTreeHelp(left.right, right.left);
	      
	}
}

