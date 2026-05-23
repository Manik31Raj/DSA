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

class LinkedList
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] arr={1,2,3,4};
		int element=2;
		
		Node head=convertArrayToLL(arr);
		
		System.out.println("\nLength of Linked List  -> "+lengthOfLL(head));
		
		System.out.println("Element "+element+" is present in Linked list -> "+checkIfPresent(head,element));
		
	}
	
	public static int lengthOfLL(Node head){
	    int count=0;
	    
	    Node temp=head;
		while(temp!=null){
		    System.out.print(temp.data+" ");
		    temp=temp.next;
		    count++;
		}
		
		return count;
	}
	
	public static boolean checkIfPresent(Node head,int val){
	    Node temp=head;
		while(temp!=null){
		    if(temp.data==val) return true;
		    temp=temp.next;
		}
		
		return false;
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
