import java.util.*;
import java.lang.*;
import java.io.*;

class Pair{
    int u;
    int v;
    public Pair(int u,int v){
        this.u=u;
        this.v=v;
    }
}

class ShortestPathUndirectedGraph
{
	public static void main (String[] args) throws java.lang.Exception
	{
	   int n=9;
	   ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
	   graph(adj,n-1);
	   int startNode=3;
	   int i=0;
	   System.out.println("\nShortest path from source Node("+startNode + ")\nNODE     :  MIN DISTANCE");
	   for(long x:shortestPath(n,adj,startNode)){
	       System.out.println(" "+i++ + "       :       "+x);
	   }
	   
	}
	
	public static long[] shortestPath(int V,ArrayList<ArrayList<Integer>> adj,int start){
	    long[] dist=new long[V];
	    Arrays.fill(dist,Long.MAX_VALUE);
	    Queue<Integer> queue=new LinkedList<>();
	    
	    queue.add(start);
	    dist[start]=0;
	    
	    while(!queue.isEmpty()){
	        int node=queue.poll();
	        
	          
	        for(int it:adj.get(node)){
                if(dist[node] + 1 < dist[it]){
                  dist[it] = dist[node] + 1;
                  queue.add(it);
                }
	        }
	    }
	    return dist;
	}
	


  //focus on abov ones
	//Graph Formation
	public static void graph(ArrayList<ArrayList<Integer>> adj,int n){
	    
	     List<Pair> list=List.of(new Pair(0,1),new Pair(1,2),new Pair(2,6),new Pair(0,3),new Pair(3,4),new Pair(4,5),new Pair(5,6),new Pair(6,7),new Pair(6,8),new Pair(7,8));
	     
	     for(int i=0;i<=n;i++){
	       adj.add(new ArrayList<Integer>());
	     }
	     
	     for(int i=0;i<list.size();i++){
	         adj.get(list.get(i).u).add(list.get(i).v);
	         adj.get(list.get(i).v).add(list.get(i).u);
	     }
	     
	    System.out.println("List Representation");
	    for(int i=0;i<adj.size();i++){
	        System.out.println(i + " : " + adj.get(i));
	    }
	  
	}
}
