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

class DFS
{
	public static void main (String[] args) throws java.lang.Exception
	{
	   int n=8,m=8;
	   ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
	   graph(adj,n);
	   int startNode=1;
	   
       System.out.println("\nDFS  -> "+DFSofGraph(n+1,adj,startNode));
       System.out.println("\nDFS  -> "+DFSofGraphStack(n+1,adj,startNode));
	}
	
	
	//Using Recursion Method
	
	public static void dfs(int node,boolean[] visited,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> li){
	    
	    visited[node]=true;
	    li.add(node);
	    
	    for(int it:adj.get(node)){
	        if(!visited[it]){
	            dfs(it,visited,adj,li);
	        }
	    }
	}
	
	public static ArrayList<Integer> DFSofGraph(int V,ArrayList<ArrayList<Integer>> adj,int start){
	    ArrayList<Integer> li=new ArrayList<>();
	    boolean[] visited=new boolean[V];
	    visited[start]=true;
	    dfs(start,visited,adj,li);
	    return li;
	    
	}
	
	//Using Iterative Method
	public static ArrayList<Integer> DFSofGraphStack(int V, ArrayList<ArrayList<Integer>> adj, int start){
        ArrayList<Integer> li = new ArrayList<>();
        boolean[] visited = new boolean[V];

        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while(!stack.isEmpty()){
           int node = stack.pop();

           if(!visited[node]){
             visited[node] = true;
             li.add(node);

            // push neighbors (reverse order for same result as recursion)
            ArrayList<Integer> neighbors = adj.get(node);
            for(int i = neighbors.size() - 1; i >= 0; i--){
                int it = neighbors.get(i);
                if(!visited[it]){
                    stack.push(it);
                }
            }
         }
       }
       return li;
    }
	
	
	
	//focus on above codes
	//Graph Formation
	public static void graph(ArrayList<ArrayList<Integer>> adj,int n){
	    
	     List<Pair> list=List.of(new Pair(1,2),new Pair(2,5),new Pair(2,6),new Pair(3,4),new Pair(4,8),new Pair(8,7),new Pair(3,7),new Pair(1,3));
	     
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
