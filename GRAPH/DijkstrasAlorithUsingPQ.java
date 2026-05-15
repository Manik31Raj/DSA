import java.util.*;
import java.lang.*;
import java.io.*;

class Pair{
    int u;
    int v;
    int w;
    public Pair(int u,int v,int w){
        this.u=u;
        this.v=v;
        this.w=w;
    }
}

class WeightPair{
    int node;
    int weight;
    public WeightPair(int node,int weight){
        this.node=node;
        this.weight=weight;
    }
}

class Distance implements Comparable<Distance>{
    long distance;
    int element;
    public Distance(long distance,int element){
        this.distance=distance;
        this.element=element;
    }
    
    @Override
    public int compareTo(Distance other) {
        return Long.compare(this.distance, other.distance);
    }
}

/*               DIJKSTRA'S ALOGITHM  

       NOt applicable for  negative weighted graphs ,negaive cycle
                                           |       
                                 (** MAKES INFINTE LOOP**)
*/

class DijkstrasAlorithUsingPQ
{
	public static void main (String[] args)
	{
	   int n=6;
	   int src=0;
	   ArrayList<ArrayList<WeightPair>> adj=new ArrayList<>();
	   graph(adj,n-1);
	   System.out.println("Shoortest Path  for all node from source "+src);
	   int i=0;
	   for(long x:shortestPath(adj,src)){
	           System.out.println( i++ + " : "+x);
	   }

	}
	
	public static long[] shortestPath(ArrayList<ArrayList<WeightPair>> adj,int start){
	    
	    long[] dist=new long[adj.size()];
	    Arrays.fill(dist,Long.MAX_VALUE);
	    dist[start]=0;
	    PriorityQueue<Distance> minHeap=new PriorityQueue<>();
	    minHeap.add(new Distance(0,start));
	    
	    while(!minHeap.isEmpty()){
	        
	        Distance d=minHeap.poll();
	        long dis=d.distance;
	        int curr=d.element;
	        
	        if(dis > dist[curr]) continue;
	        
	        for(WeightPair w:adj.get(curr)){
	           if(dist[w.node] > (dis+w.weight)){
                   dist[w.node]=dis+w.weight;
                   minHeap.add(new Distance(dist[w.node],w.node));
	            }
	        }
	        
	    }
	    
	    return dist;
	}
	

    //focus on abov ones
	//Graph Formation
	public static void graph(ArrayList<ArrayList<WeightPair>> adj,int n){
	    
	     List<Pair> list=List.of(new Pair(0,2,4),new Pair(0,1,4),new Pair(1,2,2),new Pair(2,3,3),new Pair(2,4,1),new Pair(2,5,6),new Pair(3,5,2),new Pair(4,5,3));
	     
	     for(int i=0;i<=n;i++){
	       adj.add(new ArrayList<WeightPair>());
	     }
	     
	     for(int i=0;i<list.size();i++){
	         adj.get(list.get(i).u).add(new WeightPair(list.get(i).v,list.get(i).w));
	         adj.get(list.get(i).v).add(new WeightPair(list.get(i).u,list.get(i).w));
	     }
	     
	    System.out.println("List Representation");
	    for(int i=0;i<adj.size();i++){
	        System.out.print(i + " : ");
	        for(WeightPair p:adj.get(i)){
	            System.out.print("{"+p.node+","+p.weight+"}");
	        }
	        System.out.println("");
	    }
	  
	}
}
