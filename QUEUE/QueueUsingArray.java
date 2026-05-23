import java.util.*;
import java.lang.*;
import java.io.*;


class QueueImpl{
    private int maxsize;
    private int[] queue;
    private int start;
    private int end;
    private int currSize;
    QueueImpl(int maxsize){
        this.maxsize=maxsize;
        this.queue=new int[maxsize];
        this.start=-1;
        this.end=-1;
        this.currSize=0;
    }
    
    public void push(int element){
        
        if(currSize==maxsize){
            System.out.println("Queue is Full");
            return;
        }
        
        if(start==-1 && end==-1){
            queue[++end]=element;
            start++;
            currSize++;
        }else{
            end=(end+1)%maxsize;
            queue[end]=element;
            currSize++;
        }
    }
    
    public int pop(){
        
        if(currSize<=0){
            
            System.out.println("Queue is empty");
            return (int)1e8;
        }
            
            
        int popped=queue[start];
            
        start=(start+1)%maxsize;
        currSize--;
            
            
            
        if (currSize == 0) {
            start = -1;
            end = -1;
        }
        
        return popped;
    }
    
    public int top(){
        
        if(currSize<=0){
            System.out.println("Queue is empty");
            return (int)1e8;
        }   
        return queue[start];
    }
    
    public int size(){
        return currSize;
    }
}

class QueueUsingArray
{
	public static void main (String[] args)
	{
		QueueImpl q=new QueueImpl(4);
		q.push(3);
		q.push(4);
		q.push(2);
		System.out.println("Top -> "+ q.top());
		System.out.println("Size -> "+ q.size());
		System.out.println("Poped element -> "+q.pop());
		System.out.println("Poped element -> "+q.pop());
		System.out.println("Size -> "+ q.size());
		System.out.println("Top -> "+ q.top());
		q.push(6);
		q.push(8);
		System.out.println("Size -> "+ q.size());
		q.push(10);
		q.push(11);
	}
}
