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

class ShortestPAthInDAG
{
	public static void main (String[] args)
	{
	   int n=7;
	   ArrayList<ArrayList<WeightPair>> adj=new ArrayList<>();
	   graph(adj,n-1);
	   int src=4;
	   System.out.println("Shoortest Path  for all node from source "+src);
	   int i=0;
	   for(long x:shortestPath(adj,src)){
	       if(x==Long.MAX_VALUE){
	           System.out.println( i++ + " : Not Reachable");
	       }else{
	           System.out.println( i++ + " : "+x);
	       }
	   }

	}
	
	private static void dfs(int curr,ArrayList<ArrayList<WeightPair>> adj,boolean[] visited,Stack<Integer> stack){
	    
	    visited[curr]=true;
	    for(WeightPair x:adj.get(curr)){
	        if(!visited[x.node]){
	            dfs(x.node,adj,visited,stack);
	        }
	    }
	    stack.push(curr);
	} 
	
    public static long[] shortestPath(ArrayList<ArrayList<WeightPair>> adj,int src){
        boolean[] visited=new boolean[adj.size()];
        long[] dist=new long[adj.size()];
        Arrays.fill(dist,Long.MAX_VALUE);
        Stack<Integer> stack=new Stack<>();
        
        for(int i=0;i<adj.size();i++){
            if(!visited[i]){
             dfs(i,adj,visited,stack);
            }
        }
        
        dist[src]=0;
        
        while(!stack.isEmpty()){
            int curr=stack.pop();
            
            if(dist[curr] != Long.MAX_VALUE){
              for(WeightPair p:adj.get(curr)){
                 dist[p.node]=Math.min(dist[p.node],((long)p.weight+dist[curr]));
              }
            }
        }
        
        return dist;
    }

	

    //focus on abov ones
	//Graph Formation
	public static void graph(ArrayList<ArrayList<WeightPair>> adj,int n){
	    
	     List<Pair> list=List.of(new Pair(6,4,2),new Pair(4,0,3),new Pair(0,1,2),new Pair(1,3,1),new Pair(6,5,3),new Pair(5,4,1),new Pair(4,2,1),new Pair(2,3,3));
	     
	     for(int i=0;i<=n;i++){
	       adj.add(new ArrayList<WeightPair>());
	     }
	     
	     for(int i=0;i<list.size();i++){
	         adj.get(list.get(i).u).add(new WeightPair(list.get(i).v,list.get(i).w));
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
