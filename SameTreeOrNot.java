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
class SameTreeOrNot
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Node root1=new Node(1);
		root1.left=new Node(2);
	    root1.right=new Node(3);
	    root1.left.left=new Node(4);
	    root1.left.right=new Node(5);
	    root1.right.left=new Node(6);
	    root1.right.right=new Node(7);
	    
	    Node root2=new Node(1);
		root2.left=new Node(2);
	    root2.right=new Node(3);
	    root2.left.left=new Node(4);
	    root2.left.right=new Node(5);
	    root2.right.left=new Node(6);
	    root2.right.right=new Node(7);
	    
	    System.out.println("Both Trees Are Same -> "+isTreeSame(root1,root2));
	    
	}
	public static boolean isTreeSame(Node p,Node q){
	    if(p==null || q==null) return p==q;
	    
	    return p.data==q.data && isTreeSame(p.left,q.left) && isTreeSame(p.right,q.right);
	}
	
}
