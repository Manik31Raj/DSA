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

class KReverseLL
{
	public static void main (String[] args) 
	{
		int[] arr={1,2,3,4,5,6,7,8,9,10};
		
		Node head=convertArrayToLL(arr);
		System.out.print("Linked list             : ");
		print(head);
	
		head=reverseNodesInKGroup(head,3);
		System.out.print("Reverse Linked  List    : ");
		print(head);
	
		
	}
	
	public static Node getKthNode(Node temp,int k){
	    k-=1;
	    while(temp!=null && k>0){
	        k--;
	        temp=temp.next;
	    }
	    
	    return temp;
	}
	
	public static Node reverseNodesInKGroup(Node head,int k){
	    if(head==null || head.next==null) return head;
	    
	    Node temp=head;
	    Node prevLast=null;
	    
	    while(temp!=null){
	        
	        Node kthNode=getKthNode(temp,k);
	        
	        if(kthNode==null){
	            if(prevLast!=null) prevLast.next=temp;
	            break;
	        }
	        
	        Node nextNode=kthNode.next;
	        kthNode.next=null;
	        reverse(temp);
	        
	        if(temp==head){
	            head=kthNode;
	        }else{
	            prevLast.next=kthNode;
	        }
	        
	        prevLast=temp;
	        temp=nextNode;
	    }
	    
	    return head;
	}
	
    public static Node reverse(Node head){
        
        if(head==null || head.next==null) return head;
        
        Node prev=null;
        Node temp=head;
        Node front=head.next;
        
        while(temp!=null){
            
            
            front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
            
        }
        
        return prev;
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
