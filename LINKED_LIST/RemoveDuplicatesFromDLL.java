import java.util.*;
import java.lang.*;
import java.io.*;

class Node{
    int data;
    Node prev;
    Node next;
    
    Node(int data){
        this.data=data;
    }
    
    Node(int data,Node prev,Node next){
        this.data=data;
        this.prev=prev;
        this.next=next;
    }
}

class RemoveDuplicatesFromDLL
{
	public static void main (String[] args) 
	{
		int[] arr={1,1,2,2,4,6,6,8,9,9,10};
		
		Node head=createDLLFromArray(arr);
		print(head);
		
		print(removeDuplicates(head));

	}
	
	public static Node removeDuplicates(Node head){
	    if(head==null || head.next==null) return head;
	    
	    Node temp=head;
	    
	    while(temp!=null && temp.next!=null){
	       
	       Node nextNode=temp.next;
	            
	       while(nextNode!=null && nextNode.data==temp.data){
	           nextNode=nextNode.next;
	       }
	            
	       temp.next=nextNode;
           if(nextNode!=null) nextNode.prev=temp;
	            
	       temp=temp.next;
	        
	    }
	    
	    return head;
	}
	
	public static Node findTail(Node head){
	    
	    Node temp=head;
	    
	    while(temp.next!=null){
	        temp=temp.next;
	    }
	    
	    return temp;
	}
	 

	
	
	
	public static Node createDLLFromArray(int[] arr){
	    if(arr.length==0) return null;
	    
	    Node head=new Node(arr[0]);
	    
	    if(arr.length==1) return head;
	    
	    Node curr=head;
	    for(int i=1;i<arr.length;i++){
	        
	        Node temp=new Node(arr[i]);
	        temp.prev=curr;
	        curr.next=temp;
	        curr=temp;
	    }
	    
	    return head;
	}
	
	public static void print(Node head) {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }

        Node temp=head;
        System.out.print("Doubly Linked List      : ");
        while(temp!=null){
            
            if(temp.next!=null) System.out.print(temp.data+" <--> ");
            else  System.out.println(temp.data);
            
            temp=temp.next;
        }
        
        System.out.println("");
    }
	
}
