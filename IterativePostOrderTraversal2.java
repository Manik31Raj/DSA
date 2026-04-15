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

class IterativePostOrderTraversal2
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
        Stack<Node> stack=new Stack<>();
        Node curr=root;
        
        while(curr!=null || !stack.isEmpty()){
            if(curr!=null){
                stack.push(curr);
                curr=curr.left;
            } else {
                Node temp = stack.peek().right;
                if(temp == null){
                    temp = stack.pop();
                    post.add(temp.data);
                    while(!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        post.add(temp.data);
                    }
                } else {
                    curr = temp;
                }
            }
        }
        return post;
    }
}
