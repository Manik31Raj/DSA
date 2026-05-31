import java.util.*;
import java.lang.*;
import java.io.*;


class Node {
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

class Pair implements Comparable<Pair>{
    int value;
    Node node;
    public Pair(int value,Node node){
        this.value=value;
        this.node=node;
    }
    
    @Override
    public int compareTo(Pair other){
        return Integer.compare(this.value, other.value);
    }
}

class MergeKSortedLL
{
	public static void main (String[] args) 
	{
		int[] arr1={1,3,6,9};
		int[] arr2={2,5,7,8,13};
		int[] arr3={1,4,7,10};
		int[] arr4={5,8,12,23};
		
		Node head1=convertArrayToLL(arr1);
		System.out.print("Linked list 1        : ");
		print(head1);
		
		Node head2=convertArrayToLL(arr2);
		System.out.print("Linked list 2        : ");
		print(head2);
		
		Node head3=convertArrayToLL(arr3);
		System.out.print("Linked list 3        : ");
		print(head3);
		
		Node head4=convertArrayToLL(arr4);
		System.out.print("Linked list 4        : ");
		print(head4);
		
	    List<Node> list=List.of(head1,head2,head3,head4);
	   
		Node head=mergeKSortedLinkedList(list);
		System.out.print("MergeK Linked List   : ");
		print(head);
		
	}
	
	public static Node mergeKSortedLinkedList(List<Node> list){
	    
	    if(list.size()==0) return null;
	    
	    Node dummy=new Node(-1);
	    Node curr=dummy;
	    
	    PriorityQueue<Pair> pq=new PriorityQueue<>();
	    
	    for(Node n:list){
	        if(n!=null){
	            pq.add(new Pair(n.data,n));
	        }
	    }
	    
	    while(!pq.isEmpty()){
	        Pair p=pq.poll();
	        
	        curr.next=p.node;
	        curr=curr.next;
	        
	        if(p.node.next!=null) pq.add(new Pair(p.node.next.data,p.node.next));
	    }
	    
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
