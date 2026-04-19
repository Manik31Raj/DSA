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

class RootToNode         
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
	    
	    System.out.println("Path  -> "+RootToNodePath(root,5));
	   
	   
	}
     public static List<Integer> RootToNodePath(Node root,int key){
        
         List<Integer> list=new ArrayList<>();
         
         findPath(root,key,list);        
         
         return list;
     }
     
     private static boolean findPath(Node root, int key, List<Integer> list){
    
       if(root == null) return false;
    
       // add current node
       list.add(root.data);
      
      // found target
      if(root.data == key){
         return true;
       }
    
      // search left or right
      if(findPath(root.left, key, list) || 
        findPath(root.right, key, list)){
         return true;
       }
    
      // backtrack (remove if not found)
      list.remove(list.size() - 1);
    
    return false;
  }
     
}

