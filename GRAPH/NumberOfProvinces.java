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

class NumberOfProvinces
{
	public static void main (String[] args) throws java.lang.Exception
	{
	   int n=8,m=5;
	   ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
	   graph(adj,n);
	   
       System.out.println("\nNumber  of Provinces  -> "+getProvince(n+1,adj));
       System.out.println("\nNumber  of Provinces  -> "+getProvinceUsingStack(n+1,adj));
	}
	
	
	//Using Recursion Method
	
	public static void dfs(int node,boolean[] visited,ArrayList<ArrayList<Integer>> adj){
	    
	    visited[node]=true;
	    
	    for(int it:adj.get(node)){
	        if(!visited[it]){
	            dfs(it,visited,adj);
	        }
	    }
	}
	
	public static int getProvince(int V,ArrayList<ArrayList<Integer>> adj){
	    
	    int province=0;
	    boolean[] visited=new boolean[V];
	    for(int i=1;i<V;i++){
	        if(!visited[i]){
	            province++;
	            dfs(i,visited,adj);
	        }
	    }
	    return province;
	}
	
	//Using Iterative Method
	public static int getProvinceUsingStack(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[V];
        int province=0;
        
        for(int i = 1; i < V; i++){
           if(!visited[i]){
             province++;

             Stack<Integer> stack = new Stack<>();
             stack.push(i);
             visited[i] = true;

             while(!stack.isEmpty()){
                int node = stack.pop();

                for(int it : adj.get(node)){
                    if(!visited[it]){
                        visited[it] = true;
                        stack.push(it);
                    }
                }
              }
           }
         }
       
       return province;
    }
	
	
	//focus on above codes
	//Graph Formation
	public static void graph(ArrayList<ArrayList<Integer>> adj,int n){
	    
	     List<Pair> list=List.of(new Pair(1,2),new Pair(2,3),new Pair(4,5),new Pair(5,6),new Pair(7,8));
	     
	     for(int i=0;i<=n;i++){
	       adj.add(new ArrayList<Integer>());
	     }
	     
	     for(int i=0;i<list.size();i++){
	         adj.get(list.get(i).u).add(list.get(i).v);
	         adj.get(list.get(i).v).add(list.get(i).u);
	     }
	     
	    System.out.println("List Representation");
	    for(int i=0;i<adj.size();i++){
	        System.out.println(i + " : " + adj.get(i));
	    }
	  
	}
}
