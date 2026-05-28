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

class DeleteAllOcuuranceOfKeyInDll
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] arr={1,4,1,6,1};
		int key=1;
		
		Node head=createDLLFromArray(arr);
		print(head);
		
		print(deleteAllOccuranceOfKey(head,key));
		

	}
	public static Node deleteAllOccuranceOfKey(Node head,int key){
	    
	    if(head==null) return head;
	    
	    
	    Node temp=head;
	    
	    while(temp!=null){
	        
	        if(temp.data==key){
	            if(temp==head){
	                head=head.next;
	            }
	            
	            Node prevNode=temp.prev;
	            Node nextNode=temp.next;
	            
	            if(nextNode!=null) nextNode.prev=prevNode;
	            if(prevNode!=null) prevNode.next=nextNode;
	            
	            temp=nextNode;
	            
	        }else{
	            temp=temp.next;
	        }
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
