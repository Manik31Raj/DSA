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


class DijkstrasAlgorithPrintPath
{
	public static void main (String[] args)
	{
	   int n=5;
	   int src=0;
	   ArrayList<ArrayList<WeightPair>> adj=new ArrayList<>();
	   graph(adj,n-1);
	   System.out.println("Shortest path from source to destination ");
	   for(int x:printShortestPath(adj,src,n-1)){
	       if(x==n-1){
	           System.out.print(x);
	       }else{
	           System.out.print(x+" -> ");
	       }
	   }

	}
	
	public static ArrayList<Integer> printShortestPath(ArrayList<ArrayList<WeightPair>> adj,int start,int end){
	    
	    ArrayList<Integer> path=new ArrayList<>();
	    
	    int[] parent=new int[adj.size()];
	    Arrays.fill(parent,-1);
	    
	    long[] dist=new long[adj.size()];
	    Arrays.fill(dist,Long.MAX_VALUE);
	    
	    dist[start]=0;
	    parent[start]=start;
	    
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
                   parent[w.node]=curr;
                   minHeap.add(new Distance(dist[w.node],w.node));
	            }
	        }
	        
	    }
	   
	    int n=end;
	    while(parent[n]!=n){
	       path.add(n);
	       n=parent[n];
	    }
	    path.add(start);
	    
	    Collections.reverse(path);
	    return path;
	}
	

    //focus on abov ones
	//Graph Formation
	public static void graph(ArrayList<ArrayList<WeightPair>> adj,int n){
	    
	     List<Pair> list=List.of(new Pair(0,1,2),new Pair(1,4,5),new Pair(0,3,1),new Pair(3,2,3),new Pair(1,2,4),new Pair(2,4,1));
	     
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
