import java.util.*;
import java.lang.*;
import java.io.*;

class ArticulationPoints
{
    private static int timer=1;
	public static void main (String[] args) throws java.lang.Exception
	{
		int V=7;
		int[][] edges= { {0,1},{0,2},{0,3},{2,4},{2,5},{4,6},{5,6}, };
		    
		ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
		createAdjacencyList(edges,V,adj);
		print(adj);
		
		System.out.println("Articulation Point -> "+findArticulationPoints(V,adj));
	}
	
	public static List<Integer> findArticulationPoints(int V,ArrayList<ArrayList<Integer>> adj){
	    
	    boolean[] visited=new boolean[V];
	    int[] tin=new int[V];
	    int[] low=new int[V];
	    boolean[] mark=new boolean[V];
	    
	    List<Integer> points =new ArrayList<>();
	    
	    for(int i=0;i<V;i++){
	        if(!visited[i]){
	            dfs(i,-1,visited,adj,tin,low,mark);
	        }
	    }
	    
	    for(int i=0;i<V;i++){
	        if(mark[i]){
	            points.add(i);
	        }
	    }
	    
	    if(points.size()==0){
	        points.add(-1);
	    }
	    
	    
	    return points;
	}
	
	private static void dfs(int node,int parent,boolean[] visited,ArrayList<ArrayList<Integer>> adj,int[] tin,int[] low,boolean[] mark){
	    
	    visited[node]=true;
	    tin[node] = low[node] = timer;
	    timer++;
	    
	    int child=0;
	    for(int x:adj.get(node)){
	        if(x==parent) continue;
	        
	        if(!visited[x]){
	            dfs(x,node,visited,adj,tin,low,mark);
	            
	            low[node]=Math.min(low[node],low[x]);
	            
	            if(low[x] >= tin[node] && parent!=-1){
	                mark[node]=true;;
	            }
	            child++;
	        }else{
	            low[node]=Math.min(low[node],tin[x]);
	        }
	    }
	    
	    if(child>1 && parent==-1){
	        mark[node]=true;
	    }
	}
	
	
	
	//focus on above code
	public static void createAdjacencyList(int[][] edges,int V,ArrayList<ArrayList<Integer>> adj){
	    
	    for(int i=0;i<V;i++){
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
	    for(int i=0;i<adj.size();i++){
	        System.out.println( i + "  : "+ adj.get(i));
	    }
	}
}
