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

class FindCeilingInBST
{
	public static void main (String[] args)
	{
	    Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left=new Node(4);
        root.left.right.right=new Node(7);
        
        int key=9;
    
        System.out.println("Ceil value for "+key+"  found in Tree is -> "+findCeiling(root,key));

	}

	//Ceil Value
	public static int findCeiling(Node root,int key){
	    int ceil=-1;
	    while(root!=null){
	        
	        if(root.data==key){
	            ceil=root.data;
	            return ceil;
	        }else if(root.data>key){
	            ceil=root.data;
	            root=root.left;
	        }else{
	            root=root.right;
	        }
	    }
	    return ceil;
	}
    
}

