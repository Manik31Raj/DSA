import java.util.*;
import java.lang.*;
import java.io.*;

class Node{
    int data;
    Node left;
    Node right;
    public Node(int key){
        this.data=key;
        System.out.println(data + " inserted");
    }
}

class TreeWithTraversal
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
	    
	    System.out.print("In-Order   : " );
	    inOrder(root);
	    System.out.println("");
	    System.out.print("Pre-Order  : ");
	    preOrder(root);
	    System.out.println("");
	    System.out.print("Post-Order : ");
	    postOrder(root);
	    System.out.println("");
	   
	}
	public static void inOrder(Node root){
        if(root == null) return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    public static void preOrder(Node root){
        if(root == null) return;

        System.out.print(root.data + " "); 
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void postOrder(Node root){
        if(root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}
