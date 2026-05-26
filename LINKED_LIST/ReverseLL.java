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

class ReverseLL
{
	public static void main (String[] args) 
	{
		int[] arr={1,2,4,3,6,9,12,5};
		
		Node head=convertArrayToLL(arr);
		System.out.print("LInked list        : ");
		print(head);
		
		//head=reverseLLIterative(head);
		//System.out.print("Reverse Linked     : ");
		//print(head);
		
		head=reverseLLRecurrsion(head);
		System.out.print("Reverse Linked     : ");
		print(head);
	
		
	}
	
    public static Node reverseLLIterative(Node head){
        
        if(head==null || head.next==null) return head;
        
        Node prev=null;
        Node temp=head;
        Node front=head.next;
        
        while(temp!=null){
            
            
            front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
            
        }
        
        return prev;
        
    }
    
    public static Node reverseLLRecurrsion(Node head){
        
        if(head==null || head.next==null) return head;
        
        Node newHead=reverseLLRecurrsion(head.next);
        Node front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
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
