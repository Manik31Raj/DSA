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

class RemoveKthNodeFromEnd
{
	public static void main (String[] args) 
	{
		int[] arr={1,2,4,3,6,9,12,5};
		
		Node head=convertArrayToLL(arr);
		System.out.print("LInked list        : ");
		print(head);
		
		head=removeKthNode(head,5);
		System.out.print("Linked List after removal of Kth element from end : ");
		print(head);
	
		
	}
	
    public static Node removeKthNode(Node head,int k){
       
        Node fast=head;
        Node slow=head;
        
        for(int i=0;i<k;i++){
            if(fast==null) {
                System.out.print("K out of range !! \n");
                return head;
            }
            fast=fast.next;
        }
        
        if(fast==null) return head.next;
        
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        
        Node delNode=slow.next;
        slow.next=slow.next.next;
        
        return head;
      
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
