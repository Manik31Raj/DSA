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

class BoundryOfTree           
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
	    
	    System.out.println("Boundary : "+ printBoundary(root));
	    
	    
	}
	//checks for leaf node   left(null) -> LEAF -> right(null)
	public static boolean isLeaf(Node root){
	    if(root.left==null && root.right==null){
	        return true;
	    }
	    return false;
	}
	
	//adds left part of boundary excluding leafs
	public static void addLeftBoundary(Node root,ArrayList<Integer> ans){
	    Node curr=root.left;
	    
	    while(curr!=null){
	        if(!isLeaf(curr)) ans.add(curr.data);
	        if(curr.right!=null){
	            curr=curr.right;
	        }else{
	            curr=curr.left;
	        }
	    }
	}
	
	//adds leaves 
	public static void addLeaves(Node root,ArrayList<Integer> ans){
	    if(isLeaf(root)){
	        ans.add(root.data);
	        return;
	    }
	    
	    if(root.left!=null) addLeaves(root.left,ans);
	    if(root.right!=null) addLeaves(root.right,ans);
	}
	
	
	//adds right part of boundary excluding leaf
 	public static void addRightBoundary(Node root,ArrayList<Integer> ans){
	    Node curr=root.right;
	    ArrayList<Integer> temp=new ArrayList<>();
	    while(curr!=null){
	        if(!isLeaf(curr)) ans.add(curr.data);
	        if(curr.right!=null){
	            curr=curr.right;
	        }else{
	            curr=curr.left;
	        }
	    }
	    for(int i=temp.size()-1;i>=0;--i){
	        ans.add(temp.get(i));
	    }
	}
	
    public static ArrayList<Integer> printBoundary(Node root){
        ArrayList<Integer> ans=new ArrayList<>();
        if(!isLeaf(root)) ans.add(root.data);
        addLeftBoundary(root,ans);
        addLeaves(root,ans);
        addRightBoundary(root,ans);
        
        return ans;
    }
}
