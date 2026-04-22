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
    Node node;
    int index;
    public Pair(Node node,int index){
        this.node=node;
        this.index=index;
    }
}


class NodesPresentAtDistanceKFromANode
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Node root=new Node(6);
		root.left=new Node(3);
		root.right=new Node(8);
		root.left.left=new Node(4);
		root.left.right=new Node(10);
		root.left.right.left=new Node(12);
		root.left.right.right=new Node(21);
		root.right.left=new Node(1);
		root.right.right=new Node(30);
		
		int k=2;
		
		System.out.println("Nodes present at a ditance of "+k+" from Node "+root.left.data+" are  -> "+distanceK(root,root.left,k));
		
	}
    public static void markParents(Node root,Map<Node,Node> parent,Node target){
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node curr=queue.poll();
            if(curr.left!=null){
                parent.put(curr.left,curr);
                queue.offer(curr.left);
            }
            if(curr.right!=null){
                parent.put(curr.right,curr);
                queue.offer(curr.right);
            }
        }
    }
    
    public static List<Integer> distanceK(Node root,Node target,int k){
        Map<Node,Node> parent=new HashMap<>();
        markParents(root,parent,root);
        Map<Node,Boolean> visited=new HashMap<>();
        Queue<Node> q=new LinkedList<>();
        
        q.offer(target);
        visited.put(target,true);
        int curr_level=0;
        
        while(!q.isEmpty()){
            int size=q.size();
            
            if(curr_level==k) break;
            curr_level++;
            
            for(int i=0;i<size;i++){
                Node current=q.poll();
                
                if(current.left!=null && visited.get(current.left)==null){
                    q.offer(current.left);
                    visited.put(current.left,true);
                }
                
                if(current.right!=null && visited.get(current.right)==null){
                    q.offer(current.right);
                    visited.put(current.right,true);
                }
                
                if(parent.get(current) != null && visited.get(parent.get(current))==null){
                    q.offer(parent.get(current));
                    visited.put(parent.get(current),true);
                }
                
            }
        }
        List<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            Node current=q.poll();
            res.add(current.data);
        }
        return res;
        
    }
 
}
