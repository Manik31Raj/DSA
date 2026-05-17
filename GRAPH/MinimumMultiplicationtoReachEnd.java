import java.util.*;
import java.lang.*;
import java.io.*;


class Pair{
    int steps;
    int num;
    public Pair(int steps,int num){
        this.steps=steps;
        this.num=num;
    }
}

class MinimumMultiplicationtoReachEnd
{
    static final int mod=100000;
	public static void main (String[] args)
	{
	   int[] arr={2,5,7};
	   int start=3;
	   int end=84;
	   
	   System.out.println("Minimum Multiplication To Reach from "+start+" to "+end+" is -> "+minMultiplicationToReachEnd(arr,start,end));

	}
	
	public static int minMultiplicationToReachEnd(int[] arr,int start,int end){
	    
	    if(start==end) return 0;
	    
	    int[] dist=new int[100000];
	    Arrays.fill(dist,Integer.MAX_VALUE);
	    
	    Queue<Pair> q=new LinkedList<>();
	    q.add(new Pair(0,start));
	    dist[start]=0;
	    
	    while(!q.isEmpty()){
	        Pair p=q.poll();
	        int step=p.steps;
	        int node=p.num;
	        
	        for(int i=0;i<arr.length;i++){
	            int multi=(node*arr[i])%mod;
	            
	            if(dist[multi]>step+1){
	                dist[multi]=step+1;
	                
	                if(multi==end) return step+1;
	                
	                q.add(new Pair(step+1,multi));
	            }
	        }
	    }
	    return -1;
	    
	}
}
