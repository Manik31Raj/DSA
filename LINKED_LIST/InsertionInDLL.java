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

class InsertionInDLL
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] arr={1,2,3,4,5,6,7,8,9,10};
		Node head=createDLLFromArray(arr);
		print(head);
		
		//Insert At head
		head=insertAtHead(head,18);
		System.out.println("DLL after Inseting value  at head");
		print(head);
		
		//Insert at tail
		head=insertAtTail(head,45);
		System.out.println("DLL after Inserting value at tail");
		print(head);
		
		//Insert Node at position k 
		System.out.println("DLL after Inserting  Node at Position k");
		head=insertNodeAtKthPosition(head,33,5);
		print(head);
		
		//Insert Node with with value val just after node with value
		System.out.println("DLL after Insering  Node with value x just adter node with value y");
		head=insertNodeWithValueAfterNode(head,99,33);
		print(head);

	}
	
	
	public static Node insertAtHead(Node head,int value){
	    if(head==null) return new Node(value);
	    
	    Node newHead=new Node(value);
	    newHead.next=head;
	    head.prev=newHead;
	    return newHead;
	}
	
	
	public static Node insertAtTail(Node head,int value){
	    if(head==null) return new Node(value);
	    
	    Node temp=head;
	    
	    while(temp.next!=null){
	        temp=temp.next;
	    }
	    
	    Node newTail=new Node(value);
	    newTail.prev=temp;
	    temp.next=newTail;
	    return head;
	}
	
	
	public static Node insertNodeAtKthPosition(Node head,int value,int k){
	    if(head==null && k==1 ) return new Node(value);
	    
	    if(k <= 0) return head;
	    
	    if(k==1){
	        Node newHead=new Node(value);
	        newHead.next=head;
	        head.prev=newHead;
	        return newHead;
	    }
	    
	    int count=0;
	    Node temp=head;
	    while(temp!=null){
	        count++;
	        if(count==k){
	           Node curr=new Node(value);
	            
	           curr.prev=temp.prev;
	           curr.next=temp;
	           temp.prev.next=curr;
	           temp.prev=curr;
	           break;
	        }
	        
	        if(temp.next==null && count == k - 1) {
	            Node curr=new Node(value);
	            temp.next=curr;
	            curr.prev=temp;
	            break;
	        }
	        
	        temp=temp.next;
	    }
	   
	   if(count<k){
	      System.out.println("Position K out of bounds");    
	   }
	   
	   return head;
	}
	
	public static Node insertNodeWithValueAfterNode(Node head,int val,Integer target){
	    
	    if(head==null && target==null) return null;

	    
	    Node temp=head;
	    boolean changed=false;
	    while(temp!=null){
	        
	        if(temp.data==target){
	           Node curr=new Node(val);
	           if(temp.next==null){
	               curr.prev=temp;
	               temp.next=curr;
	           }else{
	               curr.prev=temp;
	               curr.next=temp.next;
	               temp.next.prev=curr;
	               temp.next=curr;
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
