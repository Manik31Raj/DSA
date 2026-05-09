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

class TopoSort
{
	public static void main (String[] args)
	{
	   int n=6;
	   ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
	   graph(adj,n-1);
	   System.out.print("Topological Sorting  ->  [");
	   for(int x:topologicalSorting(adj)){
	       System.out.print(" "+x+" ");
	   }
	   System.out.print("]");
	   
	}
	
	/*
          -> only exits in DAG(Directed Acyclic Graph)
          -> if u & v exits in linear order  in sort - u appears before v
	*/
	private static void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] visited,Stack<Integer> stack){
	    
	    visited[node]=true;
	    for(int x:adj.get(node)){
	        if(!visited[x]){
	            dfs(x,adj,visited,stack);
	        }
	    }
	    stack.push(node);
	} 
	
    public static int[] topologicalSorting(ArrayList<ArrayList<Integer>> adj){
        boolean[] visited=new boolean[adj.size()];
        Stack<Integer> stack=new Stack<>();
        
        for(int i=0;i<adj.size();i++){
            if(!visited[i]){
             dfs(i,adj,visited,stack);
            }
        }
        
        int[] sort=new int[stack.size()];
        int j=0;
        while(!stack.isEmpty()){
            sort[j++]=stack.pop();
        }
        
        return sort;
    }

	

    //focus on abov ones
	//Graph Formation
	public static void graph(ArrayList<ArrayList<Integer>> adj,int n){
	    
	     List<Pair> list=List.of(new Pair(5,0),new Pair(4,0),new Pair(4,1),new Pair(5,2),new Pair(2,3),new Pair(3,1));
	     
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
