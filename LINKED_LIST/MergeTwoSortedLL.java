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

class MergeTwoSortedLL
{
	public static void main (String[] args) 
	{
		int[] arr1={1,3,6,9};
		int[] arr2={2,5,7,8,13};
		
		Node head1=convertArrayToLL(arr1);
		System.out.print("Linked list 1        : ");
		print(head1);
		
		Node head2=convertArrayToLL(arr2);
		System.out.print("Linked list 2        : ");
		print(head2);
		
		
		Node newHead=mergeSortedLl(head1,head2);
		System.out.print("Merged Linked list  : ");
		print(newHead);
		
	
		
		
		
	}
	
	public static Node mergeSortedLl(Node head1,Node head2){
	    if(head1==null || head2==null) return head1==null?head2:head1;
	    
	    Node dummy = new Node(-1);
        Node curr = dummy;

        Node temp1 = head1;
        Node temp2 = head2;

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
	
	
	public static void print(Node head){ 
	    Node temp=head; 
	    
	    while(temp!=null){ 
	        if(temp.next!=null) System.out.print(temp.data+" -> "); 
	        else System.out.println(temp.data); temp=temp.next;
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
