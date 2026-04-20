//Stack implemnting using java 

import java.util.*;
import java.lang.*;
import java.io.*;

class StackUsingArray
{
    private int maxSize;
    private int[] stack;
    private int top;
    
    StackUsingArray(int maxSize){
        this.maxSize=maxSize;
        this.stack=new int[maxSize];
        this.top=-1;  //means empty stack
    }
    
    //Push -> to add element to top
    public void push(int x){
        if(top==maxSize-1){
            System.out.println("Stack Ovrflow");
            return;
        }
        
        stack[++top]=x;
    }
    
    //Pop -> To remove element from top
    public int pop(){
        if(isEmpty()){
            System.out.print("Stack Underflow");
            return -1;
        }
        int z=stack[top--];
        System.out.print(z);
        stack[top+1]=0;
        return z ;
    }
    
    //Top -> give top value of stack
    public int peek(){
        if(isEmpty())
        {
            System.out.print("Stack Underflow");
            return -1;
        }
        System.out.print(stack[top]);
        return stack[top];
    }
    
    //Size -> size of stack
    public int size(){
        System.out.println(top+1);
        return top+1;
    }
        
    // to check stack is empty or not    
    public boolean isEmpty() {
        return (top == -1);
    }    
        
    public void print(){
        System.out.print("Stack : ");
        for(int x : stack){
            System.out.print(x+" ");
        }
        System.out.println("");
    }    
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		
		//Here we have to assign the max size that we require for our array
		System.out.print("Enter siz eof array : ");
		int n=sc.nextInt();
		StackUsingArray c=new StackUsingArray(n);
		int i=1;
		System.out.println("*****STACK*****\n1. Push\n2. Pop\n3. Peek\n4. Size\n5. Exit\n");
		while(i==1){
		    System.out.println("");
		    System.out.print("Enter your operation : ");
		    int x=sc.nextInt();
		    switch(x){
		        case 1:
		            int y=sc.nextInt();
		            c.push(y);
		            System.out.print("Choice  : Push  | ");
		            c.print();
		            break;
		        case 2:   
		            System.out.print("Choice  : Pop | ");
		            c.pop();
		            System.out.print(" | ");
		            c.print();
		            break;
		        case 3:
		            System.out.print("Choice  : Peek | ");
		            c.peek();
		            System.out.print(" | ");
		            c.print();
		            break;
		        case 4:
		             System.out.print("Choice  : Stack-Size -> ");
		             c.size();
		             break;
		        case 5:
		            System.out.print("EXIt");
		            i=0;
		            break;
		       default:
		            System.out.println("Choose currect choice.....");
		    }
		}

	}
}
