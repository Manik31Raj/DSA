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

class DetectACycleInLL
{
	public static void main (String[] args) 
	{
		int[] arr={1,2,4,3,9,12,5,6,7,8};
		Integer loopPoint=3;
		
		
		Node head=convertArrayToLL(arr,loopPoint);
		
		System.out.println("IS Loop present in this Linkd List  ->  "+isLoopPresent(head));
		
	}
	
	public static boolean isLoopPresent(Node head){
	    
	    if(head==null || head.next==null) return false;
	    
	    Node temp=head;
	    Node slow=head;
	    Node fast=head;
	    
	    while(fast!=null  && fast.next!=null){
	   
	        slow=slow.next;
	        fast=fast.next.next;
	        
	        if(slow==fast){
	            return true;
	        }
	    }
	    
	    return false;
	}
    
	public static Node convertArrayToLL(int[] arr,Integer loopPoint){
	    
	    Node head=new Node(arr[0]);
		Node mover=head;
		
		Node loop=null;
		
		for(int i=1;i<arr.length;i++){
		   
		   Node temp=new Node(arr[i]);
		   mover.next=temp;
		   mover=temp;
		   
		   if(loopPoint!=null && loopPoint==arr[i]){
		       loop=temp;
		   }
		   
		}
		
		mover.next=loop;
		
		return head;
	} 
}
