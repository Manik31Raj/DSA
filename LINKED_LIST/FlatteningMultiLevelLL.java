import java.util.*;
import java.lang.*;
import java.io.*;


class Node{
    int data;
    Node next;
    Node child;
    
    Node(int data){
        this.data=data;
        this.next=null;
        this.child=null;
    }
    
    Node(int data,Node next){
        this.data=data;
        this.next=next;
        this.child=null;
    }
    
    Node(int data,Node next,Node child){
        this.data=data;
        this.next=next;
        this.child=child;
    }
}
//all childs are given in sorted order
class FlatteningMultiLevelLL

{
	public static void main (String[] args) 
	{
		int[][] arr={
		              {3},
		              {2,10},
		              {1,7,11,12},
		              {4,9},
		              {5,6,8},
		            };
		
		Node head=convertArrayToLL(arr);
		print(head);
		
		System.out.println("Ater Flatten");
		head=flattenLinkedList(head);
		print(head);
		
	}
	
	public static Node flattenLinkedList(Node head){
	    if(head==null || head.next==null) return head;
	    
	    Node mergedHead=flattenLinkedList(head.next);
	    head=merge(head,mergedHead);
	    return head;
	}
	
	public static Node merge(Node n1,Node n2){
	    
	    Node dummy=new Node(-1);
	    Node res=dummy;
	    
	    while(n1!=null && n2!=null){
	        
	        if(n1.data<n2.data){
	            res.child=n1;
	            n1=n1.child;
	        }else{
	            res.child=n2;
	            n2=n2.child;
	        }
	        
	        res=res.child;
	        res.next=null;
	    }
	    
	    if(n1!=null) res.child=n1;
	    else res.child=n2;
	    
	    if(dummy.child!=null) dummy.child.next=null;
	    
	    return dummy.child;
	}
	
	
	
	public static void print(Node head){ 
	    System.out.println("***** Multi Level Linked List *****");
	    Node temp=head; 
	    
	    while(temp!=null){ 
	       System.out.print("Root ["+temp.data +"] --> " );
	       Node nextChild=temp.child;
	       while(nextChild!=null){
	           if(nextChild.child!=null) System.out.print("Child ("+nextChild.data +") -> ");
	           else System.out.print("Child ("+nextChild.data +")");
	           nextChild=nextChild.child;
	       }
	       System.out.println("");
	       
	       temp=temp.next;
	   } 
	    
	}
	
	
	public static Node convertArrayToLL(int[][] arr){
	    
	    Node dummy=new Node(-1);
	    Node head=dummy;
	    for(int i=0;i<arr.length;i++){
	        Node curr=new Node(arr[i][0]);
	        dummy.next=curr;
	        dummy=dummy.next;
	        for(int j=1;j<arr[i].length;j++){
	            curr.child=new Node(arr[i][j]);
	            curr=curr.child;
	        }
	        
	    }
	    return head.next;
	} 
}
