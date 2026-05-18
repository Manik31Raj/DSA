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

class FloydWarshallAlgorithm
{
	public static void main (String[] args){
	    
	    int n=4;
	    int[][] edges={
	                  {0,1,2},
	                  {1,0,1},
	                  {1,2,3},
	                  {3,0,3},
	                  {3,1,5},
	                  {3,2,4},
	                };
	  
	  int[][] cost=new int[n][n];
	  createAdjMatrix(edges,cost);
	  
	  floydWarshall(cost,n);
	    
	}
	
	private static void floydWarshall(int[][] cost,int n){
	    
	    for(int i=0;i<n;i++){
	        for(int j=0;j<cost.length;j++){
	            for(int k=0;k<cost[0].length;k++){
	                if(cost[j][i]!=Integer.MAX_VALUE && cost[i][k]!=Integer.MAX_VALUE){
	                   cost[j][k]=Math.min(cost[j][k],(cost[j][i]+cost[i][k]));
	                }    
	            }
	        }
	        System.out.println("\n   "+i+" MATRIX");
	        print(cost);
	        
	    }
	}
	
	
	private static void createAdjMatrix(int[][] edges,int[][] adj){
	    for(int i=0;i<adj.length;i++){
	        Arrays.fill(adj[i],Integer.MAX_VALUE);
	    }
	    
	    for(int i=0;i<adj.length;i++){
	        adj[i][i]=0;
	    }
	    
	    for(int i=0;i<edges.length;i++){
	        int x=edges[i][0];
	        int y=edges[i][1];
	        adj[x][y]=edges[i][2];
	    }
	    System.out.println("INITIAL MATRIX");
	    print(adj);
	    
	}
	
	private static void print(int[][] adj){
	    
	   boolean negCycle=false;
	    for(int i=0;i<adj.length;i++){
	        for(int j=0;j<adj[0].length;j++){
	            if(i==j && adj[i][j]<0) negCycle=true;
	            if(adj[i][j]==Integer.MAX_VALUE){
	                System.out.print("  x");
	            }else{
	                System.out.print("  "+adj[i][j]);
	            }
	        }
	        System.out.println("");
	    }
	    
	    if(negCycle){
	        System.out.println("Contains Negative cycle");
	    }
	}
	
}
