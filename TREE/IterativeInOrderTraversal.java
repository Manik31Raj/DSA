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

class IterativeInOrderTraversal
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
	    
	    System.out.println("InOrder : "+ InOrder(root));
	    
	    
	}
    public static List<Integer> InOrder(Node root){
        List<Integer> in=new ArrayList<>();
        Stack<Node> stack=new Stack<>();
        Node node=root;
        
        while(true){
            if(node!=null){
                stack.push(node);
                node=node.left;
            }else{
                if(stack.isEmpty()) break;
                node=stack.pop();
                in.add(node.data);
                node=node.right;
                
            }
        }
        return in;
    }
}
