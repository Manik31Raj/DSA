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

class ParentChild{
    int parent;
    int child;
    public ParentChild(int child,int parent){
        this.child=child;
        this.parent=parent;
    }
}

class DetectACycle
{
	public static void main (String[] args)
	{
	   int n=7,m=7;
	   ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
	   graph(adj,n);
	   int startNode=1;
	   
	   System.out.println("IS CYCLE PRESENT IN GRAPH  -> "+isCycle(n+1,adj));
	}
	
	//BFS
	private static boolean checkForCycleBFS(int src,int V,ArrayList<ArrayList<Integer>> adj,boolean[] visited){
	    visited[src]=true;
	    
	    Queue<ParentChild> queue=new LinkedList<>();
	    queue.add(new ParentChild(src,-1));
	    
	    while(!queue.isEmpty()){
	        ParentChild pc=queue.poll();
	        int childNode=pc.child;
	        int parentNode=pc.parent;
	        
	        for(int node:adj.get(childNode)){
	            if(!visited[node]){
	                visited[node]=true;
	                queue.add(new ParentChild(node,childNode));
	            }else if(parentNode!=node){
	                return true;
	            }
	        }
	    }
	    return false;
	}
	 
	//DFS 
	private static boolean checkForCycleDFS(int child,int parent,int V,ArrayList<ArrayList<Integer>> adj,boolean[] visited){
	    
	    visited[child]=true;
	    
	    for(int node:adj.get(child)){
	        if(!visited[node]){
	            if(checkForCycleDFS(node,child,V,adj,visited)) return true;
	        }else if(parent!=node){
	            return true;
	        }
	    }
	    return false;
	}  
	 
	public static boolean isCycle(int V,ArrayList<ArrayList<Integer>> adj){
	    boolean[] visited=new boolean[V];
	    for(int i=0;i<V;i++){
	        if(!visited[i]){
	            if(checkForCycleDFS(i,-1,V,adj,visited)){
	                return true;
	            }
	            /*if(checkForCycleBFS(i,V,adj,visited)){
	                return true;
	            }*/
	        }
	    }
	    return false;
	}

    //focus on abov ones
	//Graph Formation
	public static void graph(ArrayList<ArrayList<Integer>> adj,int n){
	    
	     List<Pair> list=List.of(new Pair(1,2),new Pair(2,5),new Pair(5,7),new Pair(7,6),new Pair(6,3),new Pair(3,1),new Pair(3,4));
	     
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
