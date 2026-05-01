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
    
    public BSTIterator(Node root){
        pushAll(root);
    }
    
    public boolean hasNext(){
        return !stack.isEmpty();
    }
    
    public int next(){
        Node temp=stack.pop();
        pushAll(temp.right);
        return temp.data;
    } 
    
    public void pushAll(Node node){
        while(node != null){
          stack.push(node);
          node = node.left;
        }
    }
    
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
		
	
	    BSTIterator iterator=new BSTIterator(root);
	    iterator.next();
	    iterator.next();
	    iterator.next();
	    System.out.println(iterator.next());
	    System.out.println(iterator.hasNext());

	}
}
