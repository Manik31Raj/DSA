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

class CountNodesOfCompleteTree
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
        root.left.left.right=new Node(8);
        root.left.left.left=new Node(9);
        root.left.right.right=new Node(11);
        root.left.right.left=new Node(10);
        root.left.right.left.right=new Node(12);
        
        System.out.println("Total Nodes -> "+countNodes(root));
        
	}
	
	public static int countNodes(Node root){
	    if(root==null) return 0;
	    return countNodes(root.left)+countNodes(root.right)+1;
	}
	
	public static int LeftHeight(Node root){
        int count=0;
        while(root!=null){
            count++;
            root=root.left;
        }
        return count;
    }
    
    public static int RightHeight(Node root){
        int count=0;
        while(root!=null){
            count++;
            root=root.right;
        }
        return count;
    }
	
}
