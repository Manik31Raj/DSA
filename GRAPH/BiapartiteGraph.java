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

class BiapartiteGraph
{
	public static void main (String[] args)
	{
	   int n=9,m=8;
	   ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
	   graph(adj,n);
	   
	   System.out.println("Is this graph Bipartite  -> "+isBipartiteGraph(adj));
	   
	   
	}
	
	// -1 -> no colour , 0 -> Black , 1 -> white  (you can take any colour or given ones) 
	
	public static boolean isBipartiteGraph(ArrayList<ArrayList<Integer>> adj){
	    int[] colour=new int[adj.size()];
	    Arrays.fill(colour,-1);
	    
	    for(int i=1;i<adj.size();i++){
	        if(colour[i]==-1){
	            if(!dfs(adj,0,colour,i)) return false;
	        }
	        
	       /*  if(colour[i]==-1){
	            if(!bfs(adj,0,colour,i)) return false;
	        } */
	    }
	    return true;
	}
	
	//BFS
	private static boolean bfs(ArrayList<ArrayList<Integer>> adj,int col,int[] colour,int src){
	    Queue<Integer> q=new LinkedList<>();
	    colour[src]=col;
	    q.add(src);
	    
	    while(!q.isEmpty()){
	       int curr=q.poll();
	       
	       int c=colour[curr];
	            
	       for(int node:adj.get(curr)){
	           if(colour[node]==-1){
	              colour[node]=1-c;
	              q.add(node);
	           }else if(colour[node]==colour[curr]){
	               return false;
	           }
	        }
	    }
	    return true;
	    
	}
	
	//DFS
	private static boolean dfs(ArrayList<ArrayList<Integer>> adj,int col,int[] colour,int curr){
	    
	    colour[curr]=col;
	    
	    for(int node:adj.get(curr))
	    {
	       if(colour[node]==-1){
	            colour[node]=1-col;
	            if(!dfs(adj,1-col,colour,node)) return false;
	       }else if(colour[node]==colour[curr]){
	            return false;
	       }
	   }
	   
	   return true;
	}
	

    //focus on abov ones
	//Graph Formation
	public static void graph(ArrayList<ArrayList<Integer>> adj,int n){
	    
	     List<Pair> list=List.of(new Pair(1,2),new Pair(2,3),new Pair(2,6),new Pair(3,4),new Pair(6,9),new Pair(9,5),new Pair(4,5),new Pair(4,7),new Pair(7,8));
	     
	     for(int i=0;i<=n;i++){
	       adj.add(new ArrayList<Integer>());
	     }
	     
	     for(int i=0;i<list.size();i++){
	         adj.get(list.get(i).u).add(list.get(i).v);
	         adj.get(list.get(i).v).add(list.get(i).u);
	     }
	     
	    System.out.println("List Representation");
	    for(int i=1;i<adj.size();i++){
	        System.out.println(i + " : " + adj.get(i));
	    }
	  
	}
}
