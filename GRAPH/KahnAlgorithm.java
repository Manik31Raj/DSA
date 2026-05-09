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

class KahnAlgorithm
{
	public static void main (String[] args)
	{
	   int n=6;
	   ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
	   graph(adj,n-1);
	   System.out.print("Topological Sorting(Kahn's Algorithm)  ->  [");
	   for(int x:topologicalSorting(adj)){
	       System.out.print(" "+x+" ");
	   }
	   System.out.print("]");
	   
	}
	
	/*
          -> only exits in DAG(Directed Acyclic Graph)
          -> if u & v exits in linear order  in sort - u appears before v
	*/
    public static int[]  topologicalSorting(ArrayList<ArrayList<Integer>> adj){
        int[] inDeg=new int[adj.size()];
        int[] sort=new int[adj.size()];
        int ind=0;
        
        for(int i=0;i<adj.size();i++){
	        for(int node:adj.get(i)){
	            inDeg[node]++;
	        }
	    }
	    
	    
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=0;i<inDeg.length;i++){
	        if(inDeg[i]==0){
	            q.add(i);
	        }
	    }
        
        
        while(!q.isEmpty()){
	        int node =q.poll();
	        sort[ind++]=node;
	        
	        for(int curr:adj.get(node)){
	             inDeg[curr]--;
	             if(inDeg[curr]==0){
	                q.add(curr);
	             }
	        }
	    }
	    
	    if (ind != adj.size()) {
            throw new IllegalStateException("Topological sort not possible: graph has a cycle");
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
