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

class Pair{
    int x;
    Node node;
    public Pair(int x,Node node){
        this.x=x;
        this.node=node;
    }
}

class RightAndLeftView         
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
	    
	    System.out.println("Right-View -> "+rightView(root));
	    
	    System.out.println("Left-View  -> "+leftView(root));
	    
	}
	public static List<Integer> rightView(Node root){
	    
	    if(root == null) return new ArrayList<>();
	    
	    TreeMap<Integer,Integer> map=new TreeMap<>();
	    Queue<Pair> q=new LinkedList<>();
	    q.offer(new Pair(0,root));
	    
	    while(!q.isEmpty()){
	        Pair p=q.poll();
	        Node node=p.node;
	        int z=p.x;
	        
	        if(!map.containsKey(z)){
	            map.put(z,node.data);
	        }
	        
	        if(node.left!=null){
	            q.offer(new Pair(z+1,node.left));
	        }
	        
	        if(node.right!=null){
	            q.offer(new Pair(z+1,node.right));
	        }
	    }
	    
	   return new ArrayList<>(map.values());
	}
	
	public static List<Integer> leftView(Node root){
	    
	    if(root == null) return new ArrayList<>();
	    
	    TreeMap<Integer,Integer> map=new TreeMap<>();
	    Queue<Pair> q=new LinkedList<>();
	    q.offer(new Pair(0,root));
	    
	    while(!q.isEmpty()){
	        Pair p=q.poll();
	        Node node=p.node;
	        int z=p.x;
	        
	       map.put(z,node.data);
	        
	        if(node.left!=null){
	            q.offer(new Pair(z+1,node.left));
	        }
	        
	        if(node.right!=null){
	            q.offer(new Pair(z+1,node.right));
	        }
	    }
	    
	   return new ArrayList<>(map.values());
	}
	
}

