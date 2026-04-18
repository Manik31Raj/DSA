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

class LevelWiseTraversal            //BFS
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
	    
	    System.out.println("leve-Wise : "+ levelOrder(root));
	    
	    
	}
    public static List<List<Integer>> levelOrder(Node root){
        Queue<Node> queue=new LinkedList<Node>();
        List<List<Integer>> wrapList=new LinkedList<List<Integer>>();
        if(root ==  null ) return wrapList;
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum=queue.size();
            List<Integer> subList=new LinkedList<Integer>();
            for(int i=0;i<levelNum;i++){
                if(queue.peek().left!=null)  queue.offer(queue.peek().left);
                if(queue.peek().right!=null) queue.offer(queue.peek().right);
                subList.add(queue.poll().data);
            }

			/*  FOR ZIG-ZAG PATTERN
			 intintalize a int flag =0 ; (0 -> Lft-Rgt)(1 -> Rgt-Lft)
			
			if(flag==1){
                Collections.reverse(subList);
                flag=0;
            }else{
                flag=1;
            } */
			
            wrapList.add(subList);
        }
        return wrapList;
    }
}
