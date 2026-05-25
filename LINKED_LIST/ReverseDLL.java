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

class ReverseDLL
{
	public static void main (String[] args)
	{
		int[] arr={1,2,3,4,5,6,7,8,9,10};
		Node head=createDLLFromArray(arr);
		print(head);
		
		head=reverseLinks(head);
		print(head);
		
	
		
	}
	
	public static Node reverseLinks(Node head){
	    if(head==null) return null;
	    
	    Node temp=head;
	    Node last=null;
	    
	    while(temp!=null){
	        
	        last=temp.prev;
	        temp.prev=temp.next;
	        temp.next=last;
	        
	        temp=temp.prev;
	    }
	    
	    return last.prev;
	}
	
	public static Node reverseByStack(Node head){
	    if(head==null ) return null;
	    
	    Node temp=head;
	    Stack<Integer> st=new Stack<>();
          
	    while(temp!=null){
	         st.add(temp.data);
	         temp=temp.next;
	    }
	    
	    temp=head;
	    while(temp!=null){
	        
	        temp.data=st.pop();
	        temp=temp.next;
	    }
	    
	    return head;
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
        System.out.print("Doubly Linked List   : ");
        while(temp!=null){
            
            if(temp.next!=null) System.out.print(temp.data+" <--> ");
            else  System.out.println(temp.data);
            
            temp=temp.next;
        }
        
        System.out.println("");
    }
	
}
