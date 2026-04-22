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


class LowestCommonAncestor
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
		
		System.out.println("LowestCommonAncestor for node  LCA( "+root.left.right.data+" , "+root.right.left.data+" ) -> "+LCA(root,root.left.right,root.right.left).data);
		
	}
	
	public static Node LCA(Node root,Node x,Node y){
	    
	    //base case
	    if(root==null || root==x || root==y) return root;
	    
	    Node left=LCA(root.left,x,y);
	    Node right=LCA(root.right,x,y);
	    
	    if(left==null){
	        return right;
	    }else if(right==null){
	        return left;
	    }else{
	        return root;
	    }
	        
	}
	
	
}
