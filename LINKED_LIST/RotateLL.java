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

class RotateLL
{
	public static void main (String[] args) 
	{
		int[] arr={1,2,3,4,5};
		
		Node head=convertArrayToLL(arr);
		System.out.print("Linked list                : ");
		print(head);
		
		Node head1=convertArrayToLL(arr);;
		Node head2=convertArrayToLL(arr);;
		
		int noOfRotation=2;
		head1=rightRotataion(head1,noOfRotation);
		System.out.print("Linked list right rotation : ");
		print(head1);
		
		head2=leftRotataion(head2,noOfRotation);
		System.out.print("Linked list left rotation  : ");
		print(head2);
		
		
		
	}
	
	//Left Rotation
	public static Node leftRotataion(Node head,int k){
	    int len=getLength(head);
	    
	    if(len==0 || k%len==0) return head;
	    
	    int sizeToGo=k%len;
	    
	    Node temp=head;
	    Node tail=getTail(head);
	    tail.next=head;
	    
	   for(int i=0;i<sizeToGo-1;i++){
	       temp=temp.next;
	   }
	    
	    head=temp.next;
	    temp.next=null;
	    
	    return head;
	    
	}
	
	
	//Right Rotation
	public static Node rightRotataion(Node head,int k){
	    int len=getLength(head);
	    
	    if(len==0 || k%len==0) return head;
	    
	    int sizeToGo=len-(k%len)-1;
	    
	    Node temp=head;
	    Node tail=getTail(head);
	    tail.next=head;
	    
	    while(temp!=null && sizeToGo>0){
	        
	        sizeToGo--;
	        temp=temp.next;
	    }
	    
	    head=temp.next;
	    temp.next=null;
	    
	    return head;
	    
	}
	
	private static Node getTail(Node head){
	    if(head==null) return head;
	    
	    Node temp=head;
	    while(temp.next!=null){
	        temp=temp.next;
	    }
	    
	    return temp;
	}
	
	private static int getLength(Node head){
	    if(head==null) return 0;
	    
	    Node temp=head;
	    int count=0;
	    while(temp!=null){
	        count++;
	        temp=temp.next;
	    }
	    
	    return count;
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
