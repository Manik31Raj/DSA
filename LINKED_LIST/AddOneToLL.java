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

class AddOneToLL
{
	public static void main (String[] args) 
	{
		int[] arr={9,9,9,9};
		
		Node head=convertArrayToLL(arr);
		System.out.print("Linked list                   : ");
		print(head);
		
		head=addOneRecursion(head);
		System.out.print("Linked list after adding 1    : ");
		print(head);
		
	}
	
	//Using recursion
	public static Node addOneRecursion(Node head){
	    
	    int carry=addHelper(head);
	    
	    if(carry==1){
	        Node newHead=new Node(1);
	        newHead.next=head;
	        head=newHead;
	    }
	    
	    return head;
	}
	
	public static int addHelper(Node temp){
	    
	    if(temp==null) return 1;
	    
	    int carry=addHelper(temp.next);
	    temp.data+=carry;
	    
	    if(temp.data<10) return 0;
	    
	    temp.data=temp.data%10;
	    return 1;
	}
	
	
	
	
	public static Node addOne(Node head){
	    
	    if(head==null) return new Node(1);
	    
	    if(head.next==null && head.data<9) return new Node(head.data+1);
	    
	    Node revHead=reverse(head);
	    
	    Node temp=revHead;
	    
	    int carry=1;
	    
	    while(temp!=null){
	        
	        temp.data=temp.data+carry;
	        
	        if(temp.data<10){
	            carry=0;
	            break;
	        }else{
	            temp.data=temp.data%10;
	            carry=1;
	        }
	        
	        temp=temp.next;
	    }
	    
	    Node newHead= carry==0 ? reverse(revHead) : new Node(carry,reverse(revHead));
	    
	    return newHead;
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
