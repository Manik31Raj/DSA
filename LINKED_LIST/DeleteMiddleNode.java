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

class DeleteMiddleNode

{
	public static void main (String[] args) 
	{
		int[] arr={1,2,4,3,9,12,5};
		
		Node head=convertArrayToLL(arr);
		System.out.print("Linked list      : ");
		print(head);
		
		head=deleteMiddleNode(head);
		System.out.print("New Linked list  : ");
		print(head);
		
	}
	

	public static Node deleteMiddleNode(Node head){
	    
	    if(head==null || head.next==null) return null;
	    
	    Node temp=head;
	    Node slow=head;
	    Node fast=head;
	    fast=fast.next.next;
	    
	    while(fast!=null && fast.next!=null){
	        slow=slow.next;
	        fast=fast.next.next;
	    }
	    
	   slow.next=slow.next.next;

	   return head;
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
