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

class NodeData{
    public int maxNode,minNode,maxSize;
    NodeData(int maxSize,int minNode,int maxNode){
        this.maxSize=maxSize;
        this.minNode=minNode;
        this.maxNode=maxNode;
    }
}

class LargestBSTPrsentInBT
{
	public static void main (String[] args) throws java.lang.Exception
	{
	   Node root = new Node(50);

       root.left = new Node(30);
       root.right = new Node(60);

       root.left.left = new Node(5);
       root.left.right = new Node(20);  

       root.right.left = new Node(55);
       root.right.right = new Node(70);

       root.right.right.left = new Node(65);
       root.right.right.right = new Node(80);
       
       System.out.println(largestBSTSubtree(root));

	}
	
	public static int largestBSTSubtree(Node root){
	    return largestBSTSubtreeHelper(root).maxSize;
	}
	
	
	private static NodeData largestBSTSubtreeHelper(Node root){
	    if(root==null){
	        return new NodeData(
	            0,
	            Integer.MAX_VALUE,
	            Integer.MIN_VALUE
	            );
	    }
	    
	    NodeData left=largestBSTSubtreeHelper(root.left);
	    NodeData right=largestBSTSubtreeHelper(root.right);
	    
	    if(left.maxNode<root.data && root.data<right.minNode){
	        
	        return new NodeData(
	            left.maxSize+right.maxSize+1,
	            Math.min(root.data,left.minNode),
	            Math.max(root.data,right.maxNode)
	            );
	    }
	    
	    return new NodeData(
	        Math.max(left.maxSize,right.maxSize),
	        Integer.MIN_VALUE,
	        Integer.MAX_VALUE
	        );
	    
	}
}
