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
class DeleteNodeInBSt
{
	public static void main (String[] args)
	{
	    Node root=new Node(9);
	    root.left=new Node(8);
	    root.right=new Node(12);
	    root.left.left=new Node(5);
	    root.left.left.left=new Node(3);
	    root.left.left.left.left=new Node(2);
	    root.left.left.left.left.left=new Node(1);
	    root.left.left.left.right=new Node(4);
	    root.left.left.right=new Node(7);
	    root.left.left.right.left=new Node(6);
	    root.right.left=new Node(10);
	    root.right.left.right=new Node(11);
	    root.right.right=new Node(13);
	    
	    printTree(root);
	    System.out.println("\n");
	    
	    printTree(deleteNode(root,5));
	    
	}

//General Method
	public static Node deleteNode(Node root,int value){
	    if(root==null) return null;
	    
	    if(root.data==value) return helper(root);
	    Node dummy=root;
	    while(root!=null){
	        if(root.data>value){
	            if(root.left!=null && root.left.data==value){
	                root.left=helper(root.left);
	                break;
	            }else{
	                root=root.left;
	            }
	        }else{
	            if(root.right!=null && root.right.data==value){
	                root.right=helper(root.right);
	                break;
	            }else{
	                root=root.right;
	            }
	        }
	    }
	    return dummy;
	}
	
	public static Node helper(Node root){
	    if(root.left==null){
	        return root.right;
	    }else if(root.right==null){
	        return root.left;
	    }else{
	        Node rightChild=root.right;
	        Node lastRight=findLastRight(root.left);
	        lastRight.right=rightChild;
	        return root.left;
	    }
	}
	
	public static Node findLastRight(Node root){
	    if(root.right==null){
	        return root;
	    }
	    return findLastRight(root.right);
	}

  //Recursion Method
   public static Node deleteNodeRecursion(Node root, int key){
    if(root == null) return null;

    if(key < root.data){
        root.left = deleteNode(root.left, key);
    }
    else if(key > root.data){
        root.right = deleteNode(root.right, key);
    }
    else{
        // 🔥 Node found

        // Case 1: no left child
        if(root.left == null){
            return root.right;
        }

        // Case 2: no right child
        if(root.right == null){
            return root.left;
        }

        // Case 3: two children
        Node successor = findMin(root.right);
        root.data = successor.data;
        root.right = deleteNode(root.right, successor.data);
    }

    return root;
}

public static Node findMin(Node root){
    while(root.left != null){
        root = root.left;
    }
    return root;
}


//Main code is above
//Print function
	public static void printTree(Node root){
     if(root == null){
        System.out.println("Level 0 -> [null]");
        return;
     }

     Queue<Node> q = new LinkedList<>();
     q.offer(root);
 
     int level = 0;   // 🔥 start from 0

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
