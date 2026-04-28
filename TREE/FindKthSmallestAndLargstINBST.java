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
class FindKthSmallestAndLargstINBST
{
    static int counter=0;
	public static void main (String[] args)
	{
	   Node root = new Node(25);
       root.left = new Node(10);
       root.right = new Node(35);
       root.left.left = new Node(5);
       root.left.right = new Node(15);
       root.right.left = new Node(30);
       root.right.right = new Node(40);
       root.left.left.left = new Node(2);
       root.left.left.right = new Node(7);
       root.left.right.left = new Node(12);
       root.left.right.right = new Node(18);
       int kSmallest=5;
       int kLargest=3;
	   
	   counter=0;
	   System.out.println(kSmallest+"th smallest element in this BST is -> "+kthSmallestElement(root,kSmallest));
	   
	   counter=0;
	   System.out.println(kLargest+"th largest element in this BST is  -> "+kthLargestElement(root,kLargest)); 
	   
	   counter=0;
	   System.out.println(kSmallest+"th smallest element in this BST is -> "+kSmallestMorris(root,kSmallest));
	   
	   counter=0;
	   System.out.println(kLargest+"th largest element in this BST is  -> "+kthLargestMorris(root,kLargest));
	}
	
	//using Recursion Method  kth Samllest
	public static int kthSmallestElement(Node root,int k){
	    
	    if(root==null) return -1;
	    
	   
	    // LEFT
        int left = kthSmallestElement(root.left, k);
        if(left != -1) return left;

        // NODE
        counter++;
       if(counter == k) return root.data;

       // RIGHT
       return kthSmallestElement(root.right, k);
	}
	
	//Using Recursion Method kth largest
	public static int kthLargestElement(Node root,int k){
	    
	    if(root==null) return -1;
	    
	   
	    // RIGHT
        int right = kthLargestElement(root.right, k);
        if(right != -1) return right;

        // NODE
        counter++;
       if(counter == k) return root.data;

       // LEFT
       return kthLargestElement(root.left, k);
	}
	
	//Using Morris Method kth samllest
	public static int kSmallestMorris(Node root,int k){
	    Node curr=root;
	    
	    int result=-1;
	    while(curr!=null){
	        if(curr.left==null){
	            counter++;
	            if(counter==k) result=curr.data;
	            curr=curr.right;
	        }else{
	            Node prev=curr.left;
	            while(prev.right!=null && prev.right!=curr){
	                prev=prev.right;
	            }
	            
	            if(prev.right==null){
	                prev.right=curr;
	                curr=curr.left;
	            }else{
	                prev.right=null;
	                counter++;
	                if(counter==k) result=curr.data;
	                curr=curr.right;
	            }
	        }
	        
	        
	    }
	    return result;
	}
	
	//Using Morris Method kth largest
	public static int kthLargestMorris(Node root,int k){
	    Node curr=root;
	    
	    int result=-1;
	    while(curr!=null){
	        if(curr.right==null){
	            counter++;
	            if(counter==k) result=curr.data;
	            curr=curr.left;
	        }else{
	            Node prev=curr.right;
	            while(prev.left!=null && prev.left!=curr){
	                prev=prev.left;
	            }
	            
	            if(prev.left==null){
	                prev.left=curr;
	                curr=curr.right;
	            }else{
	                prev.left=null;
	                counter++;
	                if(counter==k) result=curr.data;
	                curr=curr.left;
	            }
	        }
	        
	        
	    }
	    return result;
	}
	
	
}
