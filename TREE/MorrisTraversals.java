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

class MorrisTraversals
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.left.right.right=new Node(6);
		
        System.out.println("Morris InOrder Traversal -> "+getInOrder(root));
        System.out.println("Morris PreOrder Traversal -> "+getPreOrder(root));
        System.out.println("Morris PostOrder Traversal -> "+getPostOrder(root));
	}
	
	//MORRIS INORDER TRAVERSAL
	public static List<Integer> getInOrder(Node root){
	    List<Integer> inOrder=new ArrayList<>();
	    Node curr=root;
	    
	    while(curr!=null){
	        if(curr.left==null){
	            inOrder.add(curr.data);
	            curr=curr.right;
	        }else{
	            Node prev=curr.left;
	            while(prev.right!=null && prev.right!=curr){
	                prev=prev.right;
	            }
	            
	            if(prev.right==null){
	                prev.right=curr;
	                curr=curr.left;
	            }else{
	                prev.right=null;
	                inOrder.add(curr.data);
	                curr=curr.right;
	            }
	        }
	        
	        
	    }
	    return inOrder;
	}
	
	//MORRIS PREORDER TRAVERSAL
	public static List<Integer> getPreOrder(Node root){
	    List<Integer> preOrder=new ArrayList<>();
	    Node curr=root;
	    
	    while(curr!=null){
	        if(curr.left==null){
	            preOrder.add(curr.data);
	            curr=curr.right;
	        }else{
	            Node prev=curr.left;
	            while(prev.right!=null && prev.right!=curr){
	                prev=prev.right;
	            }
	            
	            if(prev.right==null){
	                prev.right=curr;
	                preOrder.add(curr.data);
	                curr=curr.left;
	            }else{
	                prev.right=null;
	                curr=curr.right;
	            }
	        }
	        
	        
	    }
	    return preOrder;
	}
	
	//MORRIS POSTORDER TRAVERSAL (reverse right boundary of left subtree)
	public static List<Integer> getPostOrder(Node root){
       List<Integer> postOrder = new ArrayList<>();
       Node curr = root;

       while(curr != null){
          if(curr.right == null){
            postOrder.add(curr.data);
            curr = curr.left;
          } else {
            Node prev = curr.right;

              while(prev.left != null && prev.left != curr){
                prev = prev.left;
              }

              if(prev.left == null){
                prev.left = curr;
                postOrder.add(curr.data);  
                curr = curr.right;
              } else {
                prev.left = null;
                curr = curr.left;
              }
           }
       }
    for(int i=0;i<postOrder.size()/2;i++){
        int temp=postOrder.get(i);
        postOrder.set(i, postOrder.get(postOrder.size() - i - 1));
        postOrder.set(postOrder.size() - i - 1, temp);
    }
    return postOrder;
  }
}
