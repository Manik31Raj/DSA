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

class SortALinkedList
{
	public static void main (String[] args) 
	{
		int[] arr={10,2,1,8,6,9,12,5};
		
		Node head=convertArrayToLL(arr);
		System.out.print("Linked list          : ");
		print(head);
		
		head=sort(head);
		System.out.print("Sorted Linked List   : ");
		print(head);
		
	
	}
	
	public static Node sort(Node head){
	    if(head==null || head.next==null) return head;
	    
	    Node middle=findMiddle(head);
	    Node righthead=middle.next;
	    Node lefthead=head;
	    middle.next=null;
	    
	    lefthead=sort(lefthead);
	    righthead=sort(righthead);
	    
	    return merge(lefthead,righthead);
	}
	
	private static Node merge(Node left,Node right){
	    if(left==null || right==null) return left==null?right:left;
	    
	    Node dummy = new Node(-1);
        Node curr = dummy;

        Node temp1 = left;
        Node temp2 = right;

       while(temp1 != null && temp2 != null){

          if(temp1.data <= temp2.data){
              curr.next = temp1;   
              temp1 = temp1.next;
          }else{
              curr.next = temp2;  
              temp2 = temp2.next;
          }

          curr = curr.next;
        }
        
	    if(temp1 !=null ) curr.next=temp1;
	    else curr.next=temp2;
	    
	    return dummy.next;
	}
	
	private static Node findMiddle(Node head){
	    if(head==null || head.next==null) return head;
	    
	    Node slow=head;
	    Node fast=head.next;
	    
	    while(fast!=null && fast.next!=null){
	        slow=slow.next;
	        fast=fast.next.next;
	    }
	    
	    return slow;
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
