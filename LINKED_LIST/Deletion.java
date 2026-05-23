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

class Deletion
{
	public static void main (String[] args)
	{
		int[] arr={1,2,3,4,5,6,7,8,9,12,24};
		Node head=convertArrayToLL(arr);
	    
	    print(head);
	    
	    //delete head
	    head=deleteHead(head);
	    print(head);
	    
	    //delete Tail
	    head=deleteTail(head);
	    print(head);
	    
	    //delete Kth Position
	    head=deleteKthPosition(head,5);
	    print(head);
	    
	    //delete value
	    head=deleteValue(head,9);
	    print(head);
	}
	
	//Delete Head
	public static Node deleteHead(Node head){
	    
	    if(head==null || head.next==null) return null;
	
	    return head.next;
	}
	
	//Delete Tail
	public static Node deleteTail(Node head){
	    
	    if(head==null || head.next==null) return null;
	    
	    Node temp=head;
	    
	    while(temp.next.next!=null){
	        temp=temp.next;
	    }
	    
	    temp.next=null;
	    
	    return head;
	}
	
	//Delete Node at Kth Position
	public static Node deleteKthPosition(Node head,int k){
	    
	    if(head==null) return null;
	    
	    if (k == 1) {
            return head.next;
        }
	    
	    int count=0;
	    Node temp=head;
	    Node prev=null;
	    
	    while(temp!=null){
	        count++;
	        
	        if(count==k){
	            prev.next=prev.next.next;
	            break;
	        }
	        
	        prev=temp;
	        temp=temp.next;
	        
	    }
	    
	    return head;
	}
	
	//Delete Node with value val
	public static Node deleteValue(Node head,int val){
	    
	    
	    if(head==null) return null;
	    
	    if (head.data == val) {
            return head.next;
        }
	    
	    Node temp=head;
	    Node prev=null;
	    
	    while(temp!=null){
	        
	        if(temp.data==val){
	            prev.next=prev.next.next;
	            break;
	        }
	        
	        prev=temp;
	        temp=temp.next;
	        
	    }
	    
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
