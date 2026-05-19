import java.util.*;
import java.lang.*;
import java.io.*;

class WeightPair{
    int node;
    int weight;
    public WeightPair(int node,int weight){
        this.node=node;
        this.weight=weight;
    }
}

class Pair implements Comparable<Pair>{
    int wt;
    int child;
    int parent;
    public Pair(int wt,int child,int parent){
        this.wt=wt;
        this.child=child;
        this.parent=parent;
    }
    
    @Override
    public int compareTo(Pair other){
        return Integer.compare(this.wt,other.wt);
    }
    
}

class EdgePair{
    int x;
    int y;
    public EdgePair(int x,int y){
        this.x=x;
        this.y=y;
    }
}

class PrimsAlgorithm
{
	public static void main (String[] args)
	{
	    int N=5;
		int[][] edges={
		                 {0,1,2},
		                 {0,2,1},
		                 {1,2,1},
		                 {2,4,2},
		                 {2,3,2},
		                 {3,4,1},
		              };
		              
	   ArrayList<ArrayList<WeightPair>> adj=new ArrayList<>();
	   createAdjacencyList(edges,adj,N);
	   System.out.println("**Adjacency List**");
	   printAdjacencyList(adj);
	   
	   System.out.println("\nMST sum is -> "+primsAlgorithmForMSt(adj,N));
	   
	   
	}
	
	public static int primsAlgorithmForMSt(ArrayList<ArrayList<WeightPair>> adj,int N){
	    
	    ArrayList<EdgePair> MST=new ArrayList<>();
	    int sum=0;
	    
	    boolean[] visited=new boolean[N];
	    
	    PriorityQueue<Pair> minHeap=new PriorityQueue<>();
	    
	    minHeap.add(new Pair(0,0,-1));
	    
	    while(!minHeap.isEmpty()){
	        Pair p=minHeap.poll();
	        int wts=p.wt;
	        int childNode=p.child;
	        int parentNode=p.parent;
	        
	        if(visited[childNode]) continue;
              
            if(parentNode!=-1) MST.add(new EdgePair(parentNode,childNode));
            sum+=wts;
            visited[childNode] = true;
        
	        for(WeightPair wp:adj.get(childNode)){
	           if(!visited[wp.node]){
	               minHeap.add(new Pair(wp.weight,wp.node,childNode));
	             }
	        }
	         
	    }

       System.out.print("MST  : ->  [ ");
	   for(EdgePair ep:MST){
	       System.out.print("("+ep.x+","+ep.y+") ");
	   }
	   System.out.print("]");
	   
	   return sum;
	}
	
	
	
	
	private static void createAdjacencyList(int[][] edges,ArrayList<ArrayList<WeightPair>> adj,int N){
	    
	    for(int i=0;i<N;i++){
	        adj.add(new ArrayList<>());
	    }
	    
	    for(int i=0;i<edges.length;i++){
	        adj.get(edges[i][0]).add(new WeightPair(edges[i][1],edges[i][2]));
	        adj.get(edges[i][1]).add(new WeightPair(edges[i][0],edges[i][2]));
	    }
	}
	
	private static void printAdjacencyList(ArrayList<ArrayList<WeightPair>> adj){
	    for(int i=0;i<adj.size();i++){
	        System.out.print(i + " -> ");
	        for(WeightPair wp:adj.get(i)){
	            System.out.print("{"+wp.node+","+wp.weight+"}");
	        }
	        System.out.println("");
	    }
	}
}
