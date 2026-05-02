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

class RecoverBST
{
	public static void main (String[] args) throws java.lang.Exception
	{
	   Node root = new Node(25);
       root.left = new Node(10);
       root.right = new Node(35);
       root.left.left = new Node(7);
       root.left.right = new Node(15);
       root.right.left = new Node(30);
       root.right.right = new Node(40);
       root.left.left.left = new Node(2);
       root.left.left.right = new Node(5);
       root.left.right.left = new Node(12);
       root.left.right.right = new Node(18);
       
       printTree(root);
       
       //printTree(swapVoilted(root));
       
       recoverTree(root);
       printTree(root);
       

	}
	
	
	//Method 1
	
	private static Node first;
	private static Node prev;
	private static Node middle;
	private static Node last;
	
	private static void inorder(Node root){
	    if(root==null) return;
	    
	    inorder(root.left);
	    
	    if(prev!=null && (root.data<prev.data)){
	        if(first==null){
	            first=prev;
	            middle=root;
	        }else{
	            last=root;
	        }
	    }
	    prev=root;
	    inorder(root.right);
	}
	public static void recoverTree(Node root){
	    first=middle=last=null;
	    
	    prev=new Node(Integer.MIN_VALUE);
	    inorder(root);
	    if(first!=null && last!=null){
	        int temp=first.data;
	        first.data=last.data;
	        last.data=temp;
	    }else if(first!=null && middle!=null){
	        int temp=first.data;
	        first.data=middle.data;
	        middle.data=temp;
	    }
	}
	
	
	
	//Method 2
	
	public static Node swapVoilted(Node root){
	    List<Node> toSwap=new ArrayList<>();
	    getVoiolatedNode(root,toSwap);
	    if(toSwap.size()==0){
	        System.out.println("No Voilation found");
	    }else{
	         Node first = toSwap.get(0);
             Node second = toSwap.get(1);

             System.out.println("Swapped values are "+first.data+" and "+second.data);	
             
             int temp = first.data;
             first.data = second.data;
             second.data = temp;
	    }
	    
	    return root;
	    
	}
	
	public static List<Node> getVoiolatedNode(Node root,List<Node> toSwap){
	    Node curr=root;
	    Node prevNode=null;
	    while(curr!=null){
	        if(curr.left==null){
	            if(prevNode!=null && curr.data<prevNode.data){
	                if(toSwap.size()==0){
	                       toSwap.add(prevNode);
	                       toSwap.add(curr);
	                }else{
	                       toSwap.set(1,curr);
	                 }
	            }
	            prevNode=curr;
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
	                if(prevNode!=null && curr.data<prevNode.data){
	                    if(toSwap.size()==0){
	                       toSwap.add(prevNode);
	                       toSwap.add(curr);
	                    }else{
	                        toSwap.set(1,curr);
	                    }
	                }
	                prevNode=curr;
	                curr=curr.right;
	            }
	        }
	        
	        
	    }
	    return toSwap;
	}
	
	
	
	//above are main codes
	//Print tree
	public static void printTree(Node root){
     if(root == null){
        System.out.println("Level 0 -> [null]");
        return;
     }

     Queue<Node> q = new LinkedList<>();
     q.offer(root);
 
     int level = 0;   

     while(!q.isEmpty()){
        int size = q.size();
        boolean allNull = true;

        System.out.print("Level " + level + " -> [");

        for(int i = 0; i < size; i++){
            Node curr = q.poll();

            if(curr == null){
                System.out.print("-");
                q.offer(null);
                q.offer(null);
            }else{
                System.out.print(curr.data);

                if(curr.left != null || curr.right != null){
                    allNull = false;
                }

                q.offer(curr.left);
                q.offer(curr.right);
            }

            if(i != size - 1) System.out.print(", ");
        }

        System.out.println("]");

        if(allNull) break;  // stop when next level all null

        level++;
     }
   }
}
