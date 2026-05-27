import java.util.*;
import java.lang.*;
import java.io.*;


class Node{
    int data;
    Node next;
    
    Node(int data){
        this.data=data;
        this.next=null;
    }
    
    Node(int data,Node next){
        this.data=data;
        this.next=next;
    }
}

class Tortoise&HareAlgoForFindingMiddle
{
	public static void main (String[] args) 
	{
		int[] arr={1,2,4,3,9,12,5};
		
		Node head=convertArrayToLL(arr);
		System.out.print("LInked list  : ");
		print(head);
		
		System.out.println("Middle node of Linked List  -> "+middleNode(head).data);
		
	}
	
	//tortoise & hare Algorithm
	public static Node middleNode(Node head){
	    
	    if(head==null || head.next==null) return head;
	    
	    Node temp=head;
	    Node slow=head;
	    Node fast=head;
	    
	    while(fast!=null && fast.next!=null){
	        slow=slow.next;
	        fast=fast.next.next;
	    }
	    
	    return slow;
	}
	
   
	
    public static void print(Node head){
	    
	    Node temp=head;
		while(temp!=null){
		    if(temp.next!=null) System.out.print(temp.data+" -> ");
		    else System.out.println(temp.data);
		    temp=temp.next;
		}
	}
	
	
	public static Node convertArrayToLL(int[] arr){
	    
	    Node head=new Node(arr[0]);
		Node mover=head;
		
		for(int i=1;i<arr.length;i++){
		   
		   Node temp=new Node(arr[i]);
		   mover.next=temp;
		   mover=temp;;
		   
		}
		
		return head;
	} 
}
