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

class Insertion
{
	public static void main (String[] args)
	{
		int[] arr={1,2,3,4,5,6,7,8,9,12,24};
		Node head=convertArrayToLL(arr);
	    
	    print(head);
	    
	    //delete head
	    head=insertAtHead(head,25);
	    print(head);
	    
	    //delete Tail
	    head=insertAtTail(head,45);
	    print(head);
	    
	    //Insert Kth Position
	    head=insertKthPosition(head,6,18);
	    print(head);
	    
	    //Insert value val before value x
	    head=insertValue(head,9,100);
	    print(head);
	}
	
	//Insert at head
	public static Node insertAtHead(Node head,int val){
	    
	    if(head==null ) return new Node(val);
	    
	    Node newHead=new Node(val,head);
	    
	    return newHead;
	}
	
	//Insert at Tail
	public static Node insertAtTail(Node head,int val){
	    
	    if(head==null) return new Node(val);
	    
	    Node temp=head;
	    
	    while(temp.next!=null){
	        temp=temp.next;
	    }
	    
	    temp.next=new Node(val);
	    
	    return head;
	}
	
	//Inset Node at Kth Position
	public static Node insertKthPosition(Node head,int k,int val){
	    
	    if(head==null){
	        if(k==1) return new Node(val);
	        else return null;
	    }     
	    
	    if (k == 1) {
            Node curr=new Node(val,head);
            return curr;
        }
	    
	    int count=0;
	    Node temp=head;
	    
	    while(temp!=null){
	        count++;
	       
	        if(count==k-1){
	            temp.next=new Node(val,temp.next);
	            break;
	        }
	        
	        temp=temp.next;
	        
	    }
	    
	    if(count<k-1){
           System.out.println("Can reach!!");
	    }
	        
	    
	    return head;
	}
	
	//Insert  value val before value x
	public static Node insertValue(Node head,int val,int x){
	    
	    
	    if(head==null) return null;
	    
	    if (head.data == x) {
            Node temp=new Node(val,head);
            return temp;
        }
	    
	    Node temp=head;
	    
	    while(temp.next!=null){
	        
	        if(temp.next.data==x){
	            temp.next=new Node(val,temp.next);
	            return head;
	        }
	        
	        temp=temp.next;
	        
	    }
	    
	    System.out.println("Unable to find x");
	    return head;
	}
	
	
	
	
	
	//focus on above codes
	public static void print(Node head){
	    
	    if(head==null ) return ;
	    
	    System.out.print("Linked List -> ");
	    Node temp=head;
		while(temp!=null){
		    System.out.print(temp.data+" ");
		    temp=temp.next;
		}
		System.out.println("");
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
