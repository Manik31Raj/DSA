import java.util.*;
import java.lang.*;
import java.io.*;

class GraphRepresentation
{
	public static void main (String[] args) 
	{
	   int n=5,m=6;
	   
	   
	   /*
	       n = no of nodes/vertex
         m = no of edges
	       1 ----- 2 
	       |       | \
 	       |       |  5
         |       | /
	       3 ----- 4 
	   
	   */
	   
	   /*
	     
	     Using Matrix
	     
	    //edge u--v (Undirected)
	    adj[u][v]=1;
	    adj[v][u]=1;
	    
	    //edge u-->v  (Directed)
	    adj[u][v]=1;
	    
	    //edge u---w(weight)---v (Weighted Undirected)
	    adj[u][v]=w;
	    adj[v][u]=w;
	    
	    //edge u---w(weight)--->v (Weighted Directed)
	    adj[u][v]=w;
	    
	    But this takes O(N*N) space .
	    preferd in small matrix
	    
	   */
	   
	   int[][] adjM=new int[n+1][n+1];
	   
	   //edge 1-2
	   adjM[1][2]=1;
	   adjM[2][1]=1;
	   
	   //edge 1-3
	   adjM[1][3]=1;
	   adjM[3][1]=1;
	   
	   //edge 2-4
	   adjM[2][4]=1;
	   adjM[4][2]=1;
	   
	   //edge 2-5
	   adjM[2][5]=1;
	   adjM[5][2]=1;
	   
	   //edge 3-4
	   adjM[3][4]=1;
	   adjM[4][3]=1;
	   
	   //edge 4-5
	   adjM[4][5]=1;
	   adjM[5][4]=1;
	   
	   
	   /*
	     
	     Using List(ArrayList)
	     
	    //edge v-u (Undirected)
	    adj.get(u).add(v);
	    adj.get(v).add(u);
	    
	    //edge u-->v (Directed)
	    adj.get(u).add(v);
	    
	    
	    
	    
	    // clas Pair{
	        int node;
	        int weight;
	        publc Pair(int node,int weight){
	            this.node=node;
	            this.weight=weight;
	        }
	    }
	    
	    ArrayList<ArrayList<Pair>>
	    
	    //edge u---w(weight)---v (Weighted Undirected)
	    adj.get(u).add(new Pair(v,w));
	    adj.get(v).add(new pair(u,w));
	    
	    //edge u---w(weight)--->v (Weighted Directed)
	    adj.get(u).add(new Pair(v,w));
	    
	    
	    But this takes O(2*M) space .(Optimal)
	    
	   */
	   
	   ArrayList<ArrayList<Integer>> adjL=new ArrayList<ArrayList<Integer>>();
	   
	   //added n+1(size)
	   for(int i=0;i<=n;i++){
	       adjL.add(new ArrayList<Integer>());
	   }
	   
	   //edge 1-2
	   adjL.get(1).add(2);
	   adjL.get(2).add(1);
	   
	   //edge 1-3
	   adjL.get(1).add(3);
	   adjL.get(3).add(1);
	   
	   //edge 2-4
	   adjL.get(2).add(4);
	   adjL.get(4).add(2);
	   
	   //edge 2-5
	   adjL.get(2).add(5);
	   adjL.get(5).add(2);
	   
	   //edge 3-4
	   adjL.get(3).add(4);
	   adjL.get(4).add(3);
	   
	   //edge 4-5
	   adjL.get(4).add(5);
	   adjL.get(5).add(4);
	   
	   printList(adjL);
	   printMatrix(adjM);

	}
	
	public static void printMatrix(int[][] adj){
	    System.out.println("Matrix Representation");
	    for (int i = 0; i < adj.length; i++) { // Loop through rows
            for (int j = 0; j < adj[i].length; j++) { // Loop through columns
                System.out.print(adj[i][j] + " ");
            }
            System.out.println(); // Move to next line after each row
        }
	}
	
	public static void printList(ArrayList<ArrayList<Integer>> adj){
	    System.out.println("List Representation");
	    for(int i=0;i<adj.size();i++){
	        System.out.println(i + " : " + adj.get(i));
	    }
	}
}
