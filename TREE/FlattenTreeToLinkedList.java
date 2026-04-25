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

class FlattenTreeToLinkedList
{
     static Node prev = null; 
    
	public static void main (String[] args)
	{
	    Node root1 = buildTree();
        Node root2 = buildTree();
        Node root3 = buildTree();


        System.out.println("Using Reverse Preorder:");
        prev = null;
        FlattenPreOrder(root1);
        printList(root1);

        System.out.println("\nUsing Stack:");
        FlattenStack(root2);
        printList(root2);

        System.out.println("\nUsing Morris:");
        FlattenMorris(root3);
        printList(root3);
	    

	}
	
	static Node buildTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(6);
        root.right.right.left = new Node(7);
        return root;
    }
	
   //Using Reverse PreOrder Method
   public static void FlattenPreOrder(Node root){
	    if(root==null) return;
	    
	    FlattenPreOrder(root.right);
	    FlattenPreOrder(root.left);
	    
	    root.right=prev;
	    root.left=null;
	    prev=root;
	    
	}
	

   //Using Stack Method	
   public static void FlattenStack(Node root){
       Stack<Node> st=new Stack<>();
       st.push(root);
       while(!st.isEmpty()){
           Node curr=st.pop();
           
           if(curr.right!=null) st.push(curr.right);
           
           if(curr.left!=null)  st.push(curr.left);
           
           if(!st.isEmpty()){
               curr.right=st.peek();
           }
           curr.left=null;
       }
   }
   
   
   //Using Morris Method
   public static void FlattenMorris(Node root){
       Node curr=root;
       while(curr!=null){
           if(curr.left!=null){
               prev=curr.left;
               while(prev.right!=null){
                   prev=prev.right;
               }
               prev.right=curr.right;
               curr.right=curr.left;
           }
           curr=curr.right;
       }
   }
	
	//To Print 
	public static void printList(Node root) {
        Node curr = root;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.right;
        }
        System.out.println("null");
	}
}

