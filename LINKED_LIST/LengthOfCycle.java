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

class LengthOfCycle
{
	public static void main (String[] args) 
	{
		int[] arr={1,2,4,3,9,12,5,6,7,8};
		Integer loopPoint=3;
		
		Node head=convertArrayToLL(arr,loopPoint);
		
		System.out.println("IS Loop present in this Linkd List Length of Loop  ->  "+findLength(head));
		
	}
	
	public static int findLengthOfLoop(Node loopNode){
	    
	    int len=1;
	    Node curr=loopNode;    
	    curr=curr.next;
	    
	    while(curr!=loopNode){
	        len++;
	        curr=curr.next;
	    }
	    
	    return len;
	}
	
	public static int findLength(Node head){
	    
	    if(head==null || head.next==null) return 0;
	    
	    Node temp=head;
	    Node slow=head;
	    Node fast=head;
	    
	    while(fast!=null  && fast.next!=null){
	   
	        slow=slow.next;
	        fast=fast.next.next;
	        
	        if(slow==fast){
	            return findLengthOfLoop(slow);
	        }
	    }
	    
	    return 0;
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
