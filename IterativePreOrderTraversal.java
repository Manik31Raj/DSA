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

class IterativePreOrderTraversal
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
	    
	    System.out.println("PreOrder : "+ PreOrder(root));
	    
	    
	}
    public static List<Integer> PreOrder(Node root){
        List<Integer> pre=new ArrayList<>();
        if(root == null ) return pre;
        
        Stack<Node> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root=stack.pop();
            pre.add(root.data);
            if(root.right != null) stack.push(root.right);
            if(root.left  != null) stack.push(root.left);
        }
        return pre;
    }
}
