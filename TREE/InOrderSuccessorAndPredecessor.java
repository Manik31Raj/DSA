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

class InOrderSuccessorAndPredecessor
{
	public static void main (String[] args)
	{
		Node root=new Node(5);
		
		root.left=new Node(3);
		root.left.left=new Node(2);
		root.left.left.left=new Node(1);
		root.left.right=new Node(4);
		
		root.right=new Node(7);
		root.right.left=new Node(6);
		root.right.right=new Node(9);
		root.right.right.left=new Node(8);
		root.right.right.right=new Node(10);
		
		Node key=root.left.right;
		Node resS=InOrderSuccessor(root,key);
		Node resP=InOrdePredecessor(root,key);
		System.out.println(resS==null ? "No successor Present":"Successor of Node("+key.data+") present in this BST is   : Node("+resS.data+")");
		System.out.println(resP==null ? "No predecessor Present":"Predecessor of Node("+key.data+") present in this BST is : Node("+resP.data+")");

	}
	
	public static Node InOrderSuccessor(Node root,Node key){
	    Node successor=null;
	    
	    while(root!=null){
	        if(root.data>key.data){
	            successor=root;
	            root=root.left;
	        }else{
	            root=root.right;
	        }
	    }
	    return successor;
	}
	
	public static Node InOrdePredecessor(Node root,Node key){
	    Node predecessor=null;
	    
	    while(root!=null){
	        if(root.data<key.data){
	            predecessor=root;
	            root=root.right;
	        }else{
	            root=root.left;
	        }
	    }
	    return predecessor;
	}
}
