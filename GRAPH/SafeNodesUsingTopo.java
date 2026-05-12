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

class SafeNodesUsingTopo
{
	public static void main (String[] args)
	{
	   int n=12;
	   ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
	   graph(adj,n);
	   System.out.print("Safe Nodes using Topological Sorting(Kahn's Algorithm)  ->  [");
	   for(int x:safeNodeUsingTopoSort(adj)){
	       System.out.print(" "+x+" ");
	   }
	   System.out.print("]");
	   
	   
	}
	
	//reverse-edges to apply indegree 
	private static void reverseGraphEdges(ArrayList<ArrayList<Integer>> adj,ArrayList<ArrayList<Integer>> rev){
	    
	    for (int i = 0; i < adj.size(); i++) {
          rev.add(new ArrayList<Integer>());
        }
        
        for (int u = 0; u < adj.size(); u++) {
           for (int v : adj.get(u)) {
             rev.get(v).add(u);
           }
        }
	}
	
	public static int[] safeNodeUsingTopoSort(ArrayList<ArrayList<Integer>> adj){
	    
	    ArrayList<ArrayList<Integer>> rev=new ArrayList<>();
	    reverseGraphEdges(adj,rev);
	    
        int[] inDeg=new int[adj.size()];
        boolean[] safe=new boolean[adj.size()];
        int ind=0;
        
        for(int i=0;i<rev.size();i++){
	        for(int node:rev.get(i)){
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
	        safe[node]=true;
	        ind++;
	        
	        for(int curr:rev.get(node)){
	             inDeg[curr]--;
	             if(inDeg[curr]==0){
	                q.add(curr);
	             }
	        }
	    }
	    
	    int[] safeNodes=new int[ind];
	    int j=0;
	    
	    for(int i=0;i<safe.length;i++){
	        if(safe[i]) safeNodes[j++]=i;
	    }
        return safeNodes;
    }

	
	

	

    //focus on abov ones
	//Graph Formation
	public static void graph(ArrayList<ArrayList<Integer>> adj,int n){
	    
	     List<Pair> list=List.of(new Pair(0,1),new Pair(1,2),new Pair(2,3),new Pair(3,4),new Pair(3,5),new Pair(5,6),new Pair(6,7),new Pair(4,6),new Pair(8,1),new Pair(8,9),new Pair(9,10),new Pair(10,8),new Pair(11,9));
	     
	     
	     for(int i=0;i<n;i++){
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
