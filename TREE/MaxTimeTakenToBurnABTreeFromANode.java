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

class MaxTimeTakenToBurnABTreeFromANode
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
	    root.left.left=new Node(4);
	    root.left.left.right=new Node(7);
	    root.right.left=new Node(5);
        root.right.right=new Node(6);
        
        
       System.out.println("Max Time Taken To Burn -> "+maxTimeToBurn(root,root.left));
        
	}
	public static void markParent(Node root,HashMap<Node,Node> parent){
	    Queue<Node> queue=new LinkedList<>();
	    queue.offer(root);
	    while(!queue.isEmpty()){
          Node node = queue.poll();

         if(node.left != null){
             parent.put(node.left, node);
             queue.offer(node.left);
         }

         if(node.right != null){
             parent.put(node.right, node);
             queue.offer(node.right);
         }
       }
	    
	    //for printing HashMap 
	    /*System.out.println("Child     Parent");
        for(Map.Entry<Node,Node> map:parent.entrySet()){
            System.out.println( "  "+map.getKey().data+"   ->    "+map.getValue().data);
        } */
	}
	
	public static int maxTimeToBurn(Node root,Node target){
	    HashMap<Node,Node> parent=new HashMap<>();
	    
	    markParent(root,parent);   //mark child -> parent
	    
	    HashMap<Node,Boolean> visited=new HashMap<>();
	    
	    int maxTime=0;
	    
	    Queue<Node> queue=new LinkedList<>();
	    queue.offer(target);
	    visited.put(target,true);
	    
	    while(!queue.isEmpty()){
	        int size=queue.size();
	        boolean burn=false;
	        for(int i=0;i<size;i++){
	            Node node=queue.poll();
	            
	            if(parent.containsKey(node) && visited.getOrDefault(parent.get(node), false)==false){
	                 queue.offer(parent.get(node));
	                 visited.put(parent.get(node),true);
	                 burn=true;
	            }
	            
	            if(node.left!=null && visited.getOrDefault(node.left,false)==false){
	                 queue.offer(node.left);
	                 visited.put(node.left,true);
	                 burn=true;
	            }
	            
	            if(node.right!=null && visited.getOrDefault(node.right,false)==false){
	                 queue.offer(node.right);
	                 visited.put(node.right,true);
	                 burn=true;
	            }
	           
	        }
	        if(burn) maxTime++;
	    }
	    
	    return maxTime;
	}
	
	
}
