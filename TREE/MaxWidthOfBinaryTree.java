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


class MaxWidthOfBinaryTree
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
		
		System.out.println("Maximum - Width Of Binary Tree -> "+maxWidth(root));
	}
	
    public static int maxWidth(Node root){
        
        if(root==null) return 0;
        
        int maxWid=0;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
        
        while(!q.isEmpty()){
            
            int size=q.size();
            int mMin=q.peek().index;
            int first=0,last=0;
            
            for(int i=0;i<size;i++){
                
                int cur_idx=q.peek().index-mMin;
                Node node=q.peek().node;
                q.poll();
                
                if(i==0) first = cur_idx;
                
                if(i==size-1) last = cur_idx;
                
                if(node.left != null) q.offer(new Pair(node.left,cur_idx*2+1));
                
                if(node.right!=null) q.offer(new Pair(node.right,cur_idx*2+2));
            }
            
            maxWid=Math.max(maxWid,last-first+1);
            
        }
        return maxWid;
        
    }
	
}
