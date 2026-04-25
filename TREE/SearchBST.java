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

class SearchBST
{
    static List<Character> address=new ArrayList<>();
    
	public static void main (String[] args)
	{
	    Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left=new Node(4);
        root.left.right.right=new Node(7);
        address.clear();
        address.add('S');
        
        Node root1=new Node(6);
        boolean isPresent=search(root,root1);
        System.out.println("Is node Present : "+isPresent);
        if(isPresent){
            printPath(address);
        }else{
            System.out.println("NODE NOT FOUND");
        }
        
        System.out.println("");
        
        address.add('S');
        Node node=search(root,6);
        if(node!=null){
            printPath(address);
        }else{
            System.out.println("NODE NOT FOUND");
        }
        
        

	}
	public static void printPath(List<Character> address){
	    for(char ch:address){
                if(ch=='S'){
                    System.out.print("Root -> ");
                }else if(ch=='L'){
                    System.out.print("Left -> ");
                }else if(ch=='R'){
                    System.out.print("Right -> ");
                }else{
                    System.out.print("Found\n");
                }
            }
        address.clear();    
	}
	
	
	public static boolean search(Node root,Node target){
    
     if(root == null){
        address.add('X');
        return false;
     }
     
     if(root.data==target.data){
        address.add('E');
        return true;
     }else if(root.data>target.data){
        address.add('L');
        return search(root.left,target);
     }else{
        address.add('R');
        return search(root.right,target);
     }
   }
   
   public static Node search(Node root,int target){
       
       while(root != null){
        
        if(root.data == target){
            address.add('E');
            return root;
        }
        
        if(root.data > target){
            address.add('L');
            root = root.left;
        } else {
            address.add('R');
            root = root.right;
        }
    }
    
    address.add('X');
    return null;
   }
}

