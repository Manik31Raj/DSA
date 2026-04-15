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

class IterativePostOrderTraversal
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
	    
	    System.out.println("PostOrder : "+ PostOrder(root));
	    
	    
	}
    public static List<Integer> PostOrder(Node root){
        List<Integer> post=new ArrayList<>();
        Stack<Node> stack1=new Stack<>();
        Stack<Node> stack2=new Stack<>();
        if(root == null) return post;
        stack1.push(root);
        while(!stack1.isEmpty()){
            root=stack1.pop();
            stack2.add(root);
            if(root.left!=null)  stack1.push(root.left);
            if(root.right!=null) stack1.push(root.right);
        }
        
        while(!stack2.isEmpty()){
            post.add(stack2.pop().data);
        }
        return post;
    }
}
