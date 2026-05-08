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

class CycleDetectionInDriectedGraph
{
	public static void main (String[] args)
	{
	   int n=10;
	   ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
	   graph(adj,n);
	   System.out.println("Is cycle present in this directed graph ->  "+isCyclePresent(adj));
	   
	}
	
	private static boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] visited,boolean[] pathVisited){
	    
	    visited[node]=true;
	    pathVisited[node]=true;
	    
	    for(int x:adj.get(node)){
	        
	        if(!visited[x]){
	             if(dfs(x,adj,visited,pathVisited)) return true;
	        }else if(pathVisited[x]){
	            return true;
	        }
	       
	    }
	    
	    pathVisited[node]=false;
	    return false;
	}
	
    public static boolean isCyclePresent(ArrayList<ArrayList<Integer>> adj){
        boolean[] visited=new boolean[adj.size()];
        boolean[] pathVisited=new boolean[adj.size()];
        
        for(int i=1;i<adj.size();i++){
            if(!visited[i]){
                if(dfs(i,adj,visited,pathVisited)) return true;
            }
        }
        return false;
    }

	

    //focus on abov ones
	//Graph Formation
	public static void graph(ArrayList<ArrayList<Integer>> adj,int n){
	    
	     List<Pair> list=List.of(new Pair(1,2),new Pair(2,3),new Pair(3,4),new Pair(3,7),new Pair(4,5),new Pair(7,5),new Pair(5,6),new Pair(8,2),new Pair(8,9),new Pair(9,10),new Pair(10,8));
	     
	     for(int i=0;i<=n;i++){
	       adj.add(new ArrayList<Integer>());
	     }
	     
	     for(int i=0;i<list.size();i++){
	         adj.get(list.get(i).u).add(list.get(i).v);
	     }
	     
	    System.out.println("List Representation");
	    for(int i=1;i<adj.size();i++){
	        System.out.println(i + " : " + adj.get(i));
	    }
	  
	}
}
