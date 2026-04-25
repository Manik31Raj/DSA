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

class FloorValueInBST
{
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
        
        int key=5;
    
        System.out.println("Floor value for "+key+"  found in Tree is -> "+findFloor(root,key));

	}
	
	//value < = key (greatest)
	public static int findFloor(Node root,int key){
	   int floor=-1;
	   while(root!=null){
	        if(root.data==key){
	            floor=root.data;
	            return floor;
	        }else if(root.data>key){
	            root=root.left;
	        }else{
	            floor=root.data;
	            root=root.right;
	        }
	    }
	    return floor;
	}
    
}

