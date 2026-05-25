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

class ArrangeOddEvenIndexees
{
	public static void main (String[] args) 
	{
		int[] arr={1,3,4,2,5,6,7};
		
		Node head=convertArrayToLL(arr);
		System.out.print("LInked list  : ");
		print(head);
		
		
		head=arrangeAsOddEvenIndex(head);
		System.out.print("LInked list  : ");
		print(head);
		
	}
	
	public static Node arrangeAsOddEvenIndex(Node head){
	    
	    if(head==null || head.next==null) return head;
	    
	    Node odd=head;
	    Node even=head.next;
	    Node evenStart=even;
	    
	    while(even!=null && even.next!=null){
	       
	       odd.next=even.next;
	       odd=odd.next;
	       
	       even.next=odd.next;
	       even=even.next;
	    }
	    
	    odd.next=evenStart;
	    
	    return head;
	    
	}
	
	
	
	public static Node arrangeAsOddEvenIndexByCreatingNewDummy(Node head){
	    
	    if(head==null || head.next==null || head.next.next==null) return head;
	    
	    Node odd=head;
	    Node even=head.next;
	    Node dummy=new Node(-1);
	    Node curr=dummy;
	    
	    while(odd!=null){
	        curr.next=new Node(odd.data);
	        curr=curr.next;
	        if(odd.next==null) break;
	        odd=odd.next.next;
	    }
	    
	    while(even!=null){
	        curr.next=new Node(even.data);
	        curr=curr.next;
	        if(even.next==null) break;
	        even=even.next.next;
	    }
	    
	    
	    return dummy.next;
	    
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
