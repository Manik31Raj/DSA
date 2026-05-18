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

class Bellman_Ford_Algorithm
{
	public static void main (String[] args)
	{
		int V=6;
		int src=0;
		ArrayList<ArrayList<Integer>> edges = new ArrayList<>(List.of(
            new ArrayList<>(List.of(0, 1, 5)),    
            new ArrayList<>(List.of(1, 2, -2)),
            new ArrayList<>(List.of(1, 5, -3)),
            new ArrayList<>(List.of(5, 3, 1)),
            new ArrayList<>(List.of(3, 2, 6)),
            new ArrayList<>(List.of(3, 4, -2)),
            new ArrayList<>(List.of(2, 4, 3))
        ));
		System.out.println("Edges Representation : "+edges);
		
		
		System.out.println(" Edge     Distance");
		int i=0;
		for(int x:bellmanFord(edges,V,src)){
		    System.out.println("   "+i++ + "  -->     " + x);
		}

	}
	
	public static int[] bellmanFord(ArrayList<ArrayList<Integer>> edges,int V,int src){
	    
	    int[] dist=new int[V];
	    Arrays.fill(dist,(int)1e8);
	    
	    dist[src]=0;
	    
	    for(int i=0;i<V-1;i++){
	        for(ArrayList<Integer> arr:edges){
	            int u=arr.get(0);
	            int v=arr.get(1);
	            int w=arr.get(2);
	            
	            if(dist[u]!=1e8 && dist[u]+w<dist[v]){
	                dist[v]=dist[u]+w;
	            }
	        }
	    }
	    
	    //Nth Relaxation to check negative cycle
	    for(ArrayList<Integer> arr:edges){
	            int u=arr.get(0);
	            int v=arr.get(1);
	            int w=arr.get(2);
	            
	            if(dist[u]!=1e8 && dist[u]+w<dist[v]){
	                int[] temp={-1};
	                return temp;
	            }
	   }
        	   
	    return dist;
	}
}
