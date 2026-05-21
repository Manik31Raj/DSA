import java.util.*;
import java.lang.*;
import java.io.*;

class StronglyConnectedComponent
{
	public static void main (String[] args)
	{
	   int V=8;
	   int[][] edges={
	                    {0,1},
	                    {1,2},
	                    {2,0},
	                    {2,3},
	                    {3,4},
	                    {4,7},
	                    {4,5},
	                    {5,6},
	                    {6,7},
	                    {6,4},
                	 };
                	 
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();   
        createAdjacencyList(edges,adj,V);
        print(adj);
        System.out.println("Stringly Connected Component (SSC) of Graphs present  - > "+SCC(adj,V));
	                  
	}
	
	public static List<List<Integer>> SCC(ArrayList<ArrayList<Integer>> adj,int V){
	    
	    
	    List<List<Integer>> ans=new ArrayList<>();
	    Stack<Integer> stack=new Stack<>();
	    boolean[] visited=new boolean[V];
	    for(int i=0;i<V;i++){
	        if(!visited[i]){
	            dfs(adj,stack,visited,i);
	        }     
	    }
	    
	    ArrayList<ArrayList<Integer>> revAdj=new ArrayList<>();
	    
	    for(int i=0;i<V;i++){
	        revAdj.add(new ArrayList<>());
	    }
	    
	    //reverse the edges of graph
	    for(int i=0;i<adj.size();i++){
	        for(int node:adj.get(i)){
	            revAdj.get(node).add(i);
	        }
	    }
	    
	    
	    Arrays.fill(visited, false);
	    
	    
	    while(!stack.isEmpty()){
	        
	        int ver=stack.pop();
	        if(visited[ver]) continue;
	        List<Integer> temp=new ArrayList<>();
	        dfs(revAdj,visited,temp,ver);
	        ans.add(temp);
	    }
	    
	    return ans;   
	}
	
	private static void dfs(ArrayList<ArrayList<Integer>> revAdj,boolean[] visited,List<Integer> temp,int node){
	    
	    visited[node]=true;
	    temp.add(node);
	    
	    for(int next:revAdj.get(node)){
	        if(!visited[next]){
	             dfs(revAdj,visited,temp,next);
	        }
	    }
	}
	
	private static void dfs(ArrayList<ArrayList<Integer>> adj,Stack<Integer> stack,boolean[] visited,int node){

        visited[node]=true;
        
	    for(int next:adj.get(node)){
	        if(!visited[next]){
	             dfs(adj,stack,visited,next);
	        }
	    }
	    
	    stack.push(node);
	}
	
	public static void createAdjacencyList(int[][] edges,ArrayList<ArrayList<Integer>> adj,int V){
	    
	    for(int i=0;i<V;i++){
	        adj.add(new ArrayList<>());
	    }
	    
	    for(int i=0;i<edges.length;i++){
	        adj.get(edges[i][0]).add(edges[i][1]);
	    }
	}
	
	public static void print(ArrayList<ArrayList<Integer>> adj){
	    
	    System.out.println("Adjacency List");
	    for(int i=0;i<adj.size();i++){
	        System.out.println(i+" : " +adj.get(i));
	    }
	}
     
}
