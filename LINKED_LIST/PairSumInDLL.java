import java.util.*;
import java.lang.*;
import java.io.*;

class Node{
    int data;
    Node prev;
    Node next;
    
    Node(int data){
        this.data=data;
    }
    
    Node(int data,Node prev,Node next){
        this.data=data;
        this.prev=prev;
        this.next=next;
    }
}

class PairSumInDLL
{
	public static void main (String[] args) 
	{
		int[] arr={1,2,3,4,9};
		int sum=5;
		
		Node head=createDLLFromArray(arr);
		print(head);
		
		
		System.out.println("All sum pair present -> "+sumPair(head,sum));

	}
	
	public static List<List<Integer>> sumPair(Node head,int sum){
	    
	    if(head==null || head.data>sum) return new ArrayList<>();
	    
	    List<List<Integer>> pair=new ArrayList<>();
	    Node left=head;
	    Node right=findTail(head);
	    
	    //if given sorted and non duplicate can use left.data<right.data
	    while(left != null && right != null && left != right && left.prev != right) {
	        
	        int currSum=left.data+right.data;
	        
	        if(currSum == sum){
	            pair.add(Arrays.asList(left.data,right.data));
	            left=left.next;
	            right=right.prev;
	        }else if(currSum>sum){
	            right=right.prev;
	        }else{
	            left=left.next;
	        }
	        
	    }
	    
	    return pair;
	}
	
	public static Node findTail(Node head){
	    
	    Node temp=head;
	    
	    while(temp.next!=null){
	        temp=temp.next;
	    }
	    
	    return temp;
	}
	 

	
	
	
	public static Node createDLLFromArray(int[] arr){
	    if(arr.length==0) return null;
	    
	    Node head=new Node(arr[0]);
	    
	    if(arr.length==1) return head;
	    
	    Node curr=head;
	    for(int i=1;i<arr.length;i++){
	        
	        Node temp=new Node(arr[i]);
	        temp.prev=curr;
	        curr.next=temp;
	        curr=temp;
	    }
	    
	    return head;
	}
	
	public static void print(Node head) {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }

        Node temp=head;
        System.out.print("Doubly Linked List   : ");
        while(temp!=null){
            
            if(temp.next!=null) System.out.print(temp.data+" <--> ");
            else  System.out.println(temp.data);
            
            temp=temp.next;
        }
        
        System.out.println("");
    }
	
}
