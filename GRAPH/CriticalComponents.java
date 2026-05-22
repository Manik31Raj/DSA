import java.util.*;
import java.lang.*;
import java.io.*;

class CriticalComponents
{
    private static int timer=1;
	public static void main (String[] args) throws java.lang.Exception
	{
		int V=12;
		int start=1;
		int[][] edges= { {1,2},{1,4},{2,3},{3,4},{4,5},{5,6},{6,7},{6,9},{7,8},{9,8},{8,10},{10,11},{10,12} };
		    
		ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
		createAdjacencyList(edges,V,adj);
		print(adj);
		
		System.out.println("Bridges  -> "+criticalConnections(start,V+1,adj));
	}
	
	public static List<List<Integer>> criticalConnections(int start,int V,ArrayList<ArrayList<Integer>> adj){
	    
	    boolean[] visited=new boolean[V];
	    int[] tin=new int[V];
	    int[] low=new int[V];
	    
	    List<List<Integer>> bridges =new ArrayList<>();
	    
	    dfs(start,-1,visited,adj,tin,low,bridges);
	    
	    return bridges;
	}
	
	private static void dfs(int node,int parent,boolean[] visited,ArrayList<ArrayList<Integer>> adj,int[] tin,int[] low,List<List<Integer>> bridges){
	    
	    visited[node]=true;
	    tin[node] = low[node] = timer;
	    timer++;
	    
	    for(int x:adj.get(node)){
	        if(x==parent) continue;
	        
	        if(!visited[x]){
	            dfs(x,node,visited,adj,tin,low,bridges);
	            
	            low[node]=Math.min(low[node],low[x]);
	            
	            if(low[x] > tin[node]){
	                bridges.add(Arrays.asList(x,node));
	            }
	        }else{
	            low[node]=Math.min(low[node],tin[x]);
	        }
	    }
	}
	
	
	
	//focus on above code
	public static void createAdjacencyList(int[][] edges,int V,ArrayList<ArrayList<Integer>> adj){
	    
	    for(int i=0;i<=V;i++){
	        adj.add(new ArrayList<>());
	    }      
	    
	    for(int i=0;i<edges.length;i++){
	        int u=edges[i][0];
	        int v=edges[i][1];
	        
	        adj.get(u).add(v);
	        adj.get(v).add(u);
	    }
	}
	
	private static void print(ArrayList<ArrayList<Integer>> adj){
	    System.out.println("Adjacency List");
	    for(int i=1;i<adj.size();i++){
	        System.out.println( i + "  : "+ adj.get(i));
	    }
	}
}
