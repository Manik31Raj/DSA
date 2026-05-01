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

class BSTIterator
{
    private Stack<Node> stack=new Stack<>();
    boolean reverse=true;
    
    public BSTIterator(Node root,boolean isReverse){
        reverse=isReverse;
        pushAll(root);
    }
    
    public boolean hasNext(){
        return !stack.isEmpty();
    }
    
    public int next(){
        Node temp=stack.pop();
        
        if(reverse==false){
            pushAll(temp.right);
        }else{
            pushAll(temp.left);
        }
        
        return temp.data;
    } 
    
    public Node nextNode(){
        Node temp=stack.pop();
        
        if(reverse==false){
            pushAll(temp.right);
        }else{
            pushAll(temp.left);
        }
        
        return temp;
    } 
    
    public void pushAll(Node node){
        while(node != null){
          stack.push(node);
          if(reverse==false){
           node = node.left;
          }else{
              node=node.right;
          }
        }
    }
}

class TwoSumBST{
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
		
		int target=15;
        if(isTargetPresent(root,target)){
            System.out.println("Target is present : "+FindTargetPresent(root,target));
        }else{
            System.out.println("Target is not present");
        }

	}
	
	public static boolean isTargetPresent(Node root,int target){
	    if(root==null) return false;
	    
	    BSTIterator l=new BSTIterator(root,false);
	    BSTIterator r=new BSTIterator(root,true);
	    
	    int i=l.next();
	    int j=r.next();
	    while(i<j){
	        if(i+j==target){
	            return true;
	        }else if(i+j<target){
	            if(!l.hasNext()) break; 
	            i=l.next();
	        }else{
	            if(!r.hasNext()) break;
	             j=r.next();
	        }
	    }
	    return false;
	}
	
	//Return only first match
	public static Map<Node,Integer> FindTargetPresent(Node root,int target){
	 
	    Map<Node,Integer> map=new HashMap<>();
	    
	    if(root==null) return map;
	    
	    BSTIterator l=new BSTIterator(root,false);
	    BSTIterator r=new BSTIterator(root,true);
	    
	    Node i=l.nextNode();
	    Node j=r.nextNode();
	    while(i.data<j.data){
	        if(i.data+j.data==target){
	            map.put(i,i.data);
	            map.put(j,j.data);
	            return map;
	        }else if(i.data+j.data<target){
	            if(!l.hasNext()) break;
	            i=l.nextNode();
	        }else{
	            if(!r.hasNext()) break;
	            j=r.nextNode();
	        }
	    }
	    return map;
	}
}
