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

class PalindromeCheck
{
	public static void main (String[] args) 
	{
		int[] arr={1,3,4,5,7,5,4,3,1};
		
		Node head=convertArrayToLL(arr);
		System.out.print("Linked list        : ");
		print(head);
		
		System.out.println("Is this Linked List a Plaindrome : "+isPlaindrome(head));
		
		
	}
	
	public static boolean isPlaindrome(Node head){
	    
	    if(head==null || head.next==null) return true;
	    
	    Node slow=head;
	    Node fast=head;
	    Node start=head;
	    Node first=head;
	    
	    while(fast!=null && fast.next!=null){
	        
	        slow=slow.next;
	        fast=fast.next.next;
	    }
	    
	    Node newHead= fast==null ? reverseLLIterative(slow):reverseLLIterative(slow.next);
	    
	    Node second=newHead;
	    
	    while(second!=null){
	        
	        if(second.data!=first.data){
	            return false;
	        }
	        
	        second=second.next;
	        first=first.next;
	    }
	    
	    if(fast==null){
	        first=reverseLLIterative(newHead);
	    }else{
	        first.next=reverseLLIterative(newHead);
	    }
	    
	    return true;
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
