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

class SortLL01&2
{
	public static void main (String[] args) 
	{
		int[] arr={1,0,0,1,1,2,0,1,2,2,1};
		
		Node head=convertArrayToLL(arr);
		System.out.print("LInked list        : ");
		print(head);
		
		head=sortLL(head);
		System.out.print("Sorted Linked list : ");
		print(head);
	
		
	}
	
    public static Node sortLL(Node head){
        if(head==null || head.next==null) return head;
        
        Node temp=head;
        Node dummy0=new Node(-1);
        Node dummy1=new Node(-1);
        Node dummy2=new Node(-1);
        
        Node start0=dummy0;
        Node start1=dummy1;
        Node start2=dummy2;
        
        while(temp!=null){
            
            if(temp.data==0){
                
                dummy0.next=temp;
                dummy0=dummy0.next;
                
            }else if(temp.data==1){
                
                dummy1.next=temp;
                dummy1=dummy1.next;
                
            }else{
                
                dummy2.next=temp;
                dummy2=dummy2.next;

            }
            
            temp=temp.next;
        }
        
        dummy0.next = (start1.next != null) ? start1.next : start2.next;
    
        dummy1.next = start2.next;
    
        dummy2.next = null; 
    
        return start0.next;
        
    }
	
	public static Node arrangeAsOddEvenIndexByCreatingNewDummy(Node head){
	    
	    if(head==null || head.next==null || head.next.next==null) return head;
	    
	    Node odd=head;
	    Node even=head.next;
	    Node dummy=new Node(-1);
	    Node curr=dummy;
	    
	    while(odd!=null){
	        curr.next=new Node(odd.data);
	        curr=curr.next;
	        if(odd.next==null) break;
	        odd=odd.next.next;
	    }
	    
	    while(even!=null){
	        curr.next=new Node(even.data);
	        curr=curr.next;
	        if(even.next==null) break;
	        even=even.next.next;
	    }
	    
	    
	    return dummy.next;
	    
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
