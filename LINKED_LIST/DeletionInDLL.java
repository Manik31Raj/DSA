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

class DeletionInDLL
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] arr={1,2,3,4,5,6,7,8,9,10};
		Node head=createDLLFromArray(arr);
		print(head);
		
		//Delete head
		head=deleteHead(head);
		System.out.println("DLL after deltetion of head");
		print(head);
		
		//Delete tail
		head=deleteTail(head);
		System.out.println("DLL after deltetion of tail");
		print(head);
		
		//Delete Node at position k 
		System.out.println("DLL after deltetion of Node from Position k");
		head=deleteNodeAtKthPosition(head,5);
		print(head);
		
		//Delete Node with value val
		System.out.println("DLL after deltetion of Node of value");
		head=deleteNodeWithValue(head,8);
		print(head);

	}
	
	
	public static Node deleteHead(Node head){
	    if(head==null || head.next==null) return null;
	    
	    head=head.next;
	    head.prev=null;
	    return head;
	}
	
	
	public static Node deleteTail(Node head){
	    if(head==null || head.next==null) return null;
	    
	    Node temp=head;
	    
	    while(temp.next!=null){
	        temp=temp.next;
	    }
	    
	    Node newTail=temp.prev;
	    newTail.next=null;
	    temp.prev=null;
	    return head;
	}
	
	
	public static Node deleteNodeAtKthPosition(Node head,int k){
	    if(head==null || (head.next==null && k==1 )) return null;
	    
	    if(k==1){
	        head=head.next;
	        head.prev=null;
	        return head;
	    }
	    
	    int count=0;
	    Node temp=head;
	    while(temp!=null){
	        count++;
	        if(count==k){
	            if(temp.next==null){
	                temp.prev.next=null;
	            }else{
	                temp.prev.next=temp.next;
	                temp.next.prev=temp.prev;
	            }
	           break;
	        }
	        
	        temp=temp.next;
	    }
	   
	   if(count<k){
	      System.out.println("Position K out of bounds");    
	   }
	   
	   return head;
	}
	
	public static Node deleteNodeWithValue(Node head,int val){
	    
	    if(head==null || (head.data==val && head.next==null)) return null;
	    
	    if(head.data==val){
	         head=head.next;
	         head.prev=null;
	         return head;
	    }
	    
	    Node temp=head;
	    boolean changed=false;
	    while(temp!=null){
	        
	        if(temp.data==val){
	           if(temp.next==null){
	               temp.prev.next=null;
	           }else{
	               temp.prev.next=temp.next;
	               temp.next.prev=temp.prev;
	           }
	           changed=true;
	           break;
	        }
	        temp=temp.next;
	    }
	    
	    if(!changed) System.out.println("Value Not Found ");
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
