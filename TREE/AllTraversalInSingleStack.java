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
    int num;
    Pair(Node x,int y){
        this.node=x;
        this.num=y;
    }
}

class AllTraversalInSingleStack
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
	    
	    preInPostOrder(root);
	    
	}
    public static void preInPostOrder(Node root){
        Stack<Pair> stack=new Stack<Pair>();
        stack.push(new Pair(root,1));    // push the root
        List<Integer> preOrder=new ArrayList<>();
        List<Integer> inOrder=new ArrayList<>();
        List<Integer> postOrder=new ArrayList<>();
        
        if(root==null)  return ;
        
        while(!stack.isEmpty()){
            Pair it=stack.pop();
            
            
            //PreOrder -> increment num from 1->2 and push node.left into stack
            if(it.num==1){
                preOrder.add(it.node.data);
                it.num++;
                stack.push(it);
                if(it.node.left != null)  stack.push(new Pair(it.node.left,1));
            }
            
            //Inorder  -> increment num from 2 -> 3 and push node.right if exists
            else if(it.num==2){
                inOrder.add(it.node.data);
                it.num++;
                stack.push(it);
                if(it.node.right != null) stack.push(new Pair(it.node.right,1));
            }
            
            //PostOrder  -> Just add to List
            else{
                postOrder.add(it.node.data);
            }
        }
        System.out.println("InOrder   -> "+inOrder);
        System.out.println("PreOrder  -> "+preOrder);
        System.out.println("PostOrder -> "+postOrder);
    }
}
