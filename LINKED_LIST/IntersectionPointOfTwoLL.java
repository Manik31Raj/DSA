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

class IntersectionPointOfTwoLL
{
	public static void main (String[] args) 
	{
		int[] arr1={1,2,3,4};
		int[] arr2={1};
		int[] common={5,4,3,2};
		
		Node head1=new Node(-1);
		Node head2=new Node(-1);
		
		convertArrayToLL(arr1,arr2,common,head1,head2);
		System.out.print("Linked list 1   : ");
		print(head1.next);
		System.out.print("Linked list 2   : ");
		print(head2.next);
		
		Node ans=findCollisonPoint(head1.next,head2.next);
		System.out.println("Collision Point of 2 Linked List  -> "+ (ans==null? "No Point":ans.data));
		
		
	}
	
	public static Node findCollisonPoint(Node head1,Node head2){
	    
	    if(head1==null || head2==null) return null;
	    
	    Node temp1=head1;
	    Node temp2=head2;
	    
	    while(temp1!=temp2){
	        
	        temp1=(temp1==null) ? head2:temp1.next;
	        temp2=(temp2==null) ? head1:temp2.next;
	    }
	    
	    return  temp1;
	}
	

	
    
    
	
    public static void print(Node head){
	    
	    Node temp=head;
		while(temp!=null){
		    if(temp.next!=null) System.out.print(temp.data+" -> ");
		    else System.out.println(temp.data);
		    temp=temp.next;
		}
	}
	
	
	public static void convertArrayToLL(int[] arr1,int[] arr2,int[] common,Node head1,Node head2){
	    
	    for(int i=0;i<arr1.length;i++){
	        head1.next=new Node(arr1[i]);
	        head1=head1.next;
	    }
	    
	    for(int i=0;i<arr2.length;i++){
	        head2.next=new Node(arr2[i]);
	        head2=head2.next;
	    }
	    
	    for(int i=0;i<common.length;i++){
	        Node x=new Node(common[i]);
	        
	        head1.next=x;
	        head2.next=x;
	        
	        head1=head1.next;
	        head2=head2.next;
	    }
	} 
}
