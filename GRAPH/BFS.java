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

class BFS
{
	public static void main (String[] args) throws java.lang.Exception
	{
	   int n=9,m=9;
	   ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
	   graph(adj,n);
	   int startNode=1;
	   
	   System.out.println("\nBFS  -> "+BFSofGraph(n+1,adj,startNode));

	}
	
	public static ArrayList<Integer> BFSofGraph(int V,ArrayList<ArrayList<Integer>> adj,int start){
	    ArrayList<Integer> bfs=new ArrayList<>();
	    boolean[] visited=new boolean[V];
	    Queue<Integer> queue=new LinkedList<>();
	    
	    queue.add(start);
	    visited[start]=true;
	    
	    while(!queue.isEmpty()){
	        int node=queue.poll();
	        bfs.add(node);
	        
	        for(int it:adj.get(node)){
	            if(visited[it]==false){
	                visited[it]=true;
	                queue.add(it);
	            }
	        }
	    }
	    return bfs;
	}
	


  //focus on abov ones
	//Graph Formation
	public static void graph(ArrayList<ArrayList<Integer>> adj,int n){
	    
	     List<Pair> list=List.of(new Pair(1,2),new Pair(2,3),new Pair(2,4),new Pair(4,5),new Pair(5,8),new Pair(1,6),new Pair(6,7),new Pair(6,9),new Pair(7,8));
	     
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
