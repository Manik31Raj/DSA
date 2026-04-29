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
class FindLCAInBST
{
	public static void main (String[] args)
	{
	  Node root = new Node(9);
      root.left = new Node(4);
      root.right = new Node(15);
      root.left.left = new Node(1);
      root.left.right = new Node(6);
      root.right.left = new Node(12); 
      root.right.right = new Node(20);
      root.left.left.right = new Node(2);
      root.left.right.left = new Node(5);
      root.left.right.right = new Node(7);
      root.right.left.left = new Node(11);
      root.right.left.right = new Node(13);
      root.right.right.left = new Node(18);
      root.right.right.right = new Node(25);
      
      System.out.println("Lowest Common Ancestors using General Method   -> "+LCA(root,1,7).data);
      System.out.println("Lowest Common Ancestors using Recursion Method -> "+LCAUsingRecursion(root,1,7).data);
      
	}
	
	//General Method
	public static Node LCA(Node root,int val1,int val2){
        
        while(root != null){

         // both values in left subtree
         if(val1 < root.data && val2 < root.data){
            root = root.left;
         }

         // both values in right subtree
         else if(val1 > root.data && val2 > root.data){
            root = root.right;
         }

        // split point → LCA
         else{
            return root;
         }
       }

      return null;
	}
	
	//Using Recursion Method 
    public static Node LCAUsingRecursion(Node root,int val1,int val2){
        
        if(root==null) return null;
        
        int curr=root.data;
        
        if(curr>val1 && curr>val2){
            return LCAUsingRecursion(root.left,val1,val2);
        }
        
        if(curr<val1 && curr<val2){
            return LCAUsingRecursion(root.right,val1,val2);
        } 
        
        return root;
    }
	
}
