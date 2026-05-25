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

class AddTwoNumbeerStoredInLLInReverseOrder
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] l1={3,5};
		int[] l2={4,5,9,9};
		
		Node L1=convertArrayToLL(l1);
		System.out.print("Linked List L1 : ");
		print(L1);
		
		Node L2=convertArrayToLL(l2);
		System.out.print("Linked List L2 : ");
		print(L2);
		
		Node head=addTwoNumbers(L1,L2);
		System.out.print("Linked List adding L1 & L2 : ");
		print(head);
		
		
		
	}
	
	
	public static Node addTwoNumbers(Node L1,Node L2){
	    int carry=0;
	    Node dummyNode=new Node(-1);
	    Node curr=dummyNode;
	    
	    while(L1!=null || L2!=null || carry!=0){
	        int val=carry;
	        
	        if(L1!=null){
	            
	            val+=L1.data;
	            L1=L1.next;
	            
	        }
	        
	        if(L2!=null){
	            
	            val+=L2.data;
	            L2=L2.next;
	        }
	        
	        carry=val/10;
	        val=val%10;
	        
	        curr.next=new Node(val);
	        curr=curr.next;
	        
	        
	    }
	    
	    return dummyNode.next;
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
