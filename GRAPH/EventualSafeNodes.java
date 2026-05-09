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

class EventualSafeNodes
{
	public static void main (String[] args)
	{
	   int n=11;
	   ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
	   graph(adj,n);
	   System.out.println("Safe Nodes Present  ->  "+eventualSafeNodes(adj));
	   
	}
	
	private static boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] visited,boolean[] pathVisited,boolean[] safe){
	    
	    visited[node]=true;
	    pathVisited[node]=true;
	    safe[node]=false;
	    
	    for(int x:adj.get(node)){
	        
	        if(!visited[x]){
	             if(dfs(x,adj,visited,pathVisited,safe)){
	                 safe[node]=false;
	                 return true;
	             } 
	        }else if(pathVisited[x]){
	            safe[node]=false;
	            return true;
	        }
	       
	    }
	    
	    pathVisited[node]=false;
	    safe[node]=true;
	    return false;
	}
	
    public static List<Integer> eventualSafeNodes(ArrayList<ArrayList<Integer>> adj){
        boolean[] visited=new boolean[adj.size()];
        boolean[] pathVisited=new boolean[adj.size()];
        boolean[] safe=new boolean[adj.size()];
        
        for(int i=0;i<adj.size();i++){
            if(!visited[i]){
             dfs(i,adj,visited,pathVisited,safe);
            }
        }
        
        List<Integer> safeNodes = new ArrayList<>();
        for(int j=0;j<safe.length;j++){
            if(safe[j]){
                safeNodes.add(j);
            }
        }
        
        return safeNodes;
    }

	

    //focus on abov ones
	//Graph Formation
	public static void graph(ArrayList<ArrayList<Integer>> adj,int n){
	    
	     List<Pair> list=List.of(new Pair(0,1),new Pair(1,2),new Pair(2,3),new Pair(3,4),new Pair(3,5),new Pair(5,6),new Pair(6,7),new Pair(4,6),new Pair(8,1),new Pair(8,9),new Pair(9,10),new Pair(10,8),new Pair(11,9));
	     
	     for(int i=0;i<=n;i++){
	       adj.add(new ArrayList<Integer>());
	     }
	     
	     for(int i=0;i<list.size();i++){
	         adj.get(list.get(i).u).add(list.get(i).v);
	     }
	     
	    System.out.println("List Representation");
	    for(int i=0;i<adj.size();i++){
	        System.out.println(i + " : " + adj.get(i));
	    }
	  
	}
}
