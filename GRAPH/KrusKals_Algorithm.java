import java.util.*;
import java.lang.*;
import java.io.*;


class EdgePair{
    int x;
    int y;
    public EdgePair(int x,int y){
        this.x=x;
        this.y=y;
    }
}

class DisjointSet{
    List<Integer> rank=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    
    public DisjointSet(int n){
        for(int i=0;i<n+1;i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    
    public int findUltimateParent(int node){
        
        if(node==parent.get(node)){
            return node;
        }
        
        int ultParent=findUltimateParent(parent.get(node));
        parent.set(node,ultParent);
        return parent.get(node);
    }
    
    
    public void unionByRank(int u,int v){
        
        int ultParent_u=findUltimateParent(u);
        int ultParent_v=findUltimateParent(v);
        
        if(ultParent_u == ultParent_v) return;
        
        if(rank.get(ultParent_u) < rank.get(ultParent_v)){
            parent.set(ultParent_u,ultParent_v);
        }else if(rank.get(ultParent_u) > rank.get(ultParent_v)){
            parent.set(ultParent_v,ultParent_u);
        }else{
            parent.set(ultParent_u,ultParent_v);
            int rankV=rank.get(ultParent_v);
            rank.set(ultParent_v,rankV+1);
        }
    }
    
    public void unionBySize(int u,int v){
        
        int ultParent_u=findUltimateParent(u);
        int ultParent_v=findUltimateParent(v);
        
        if(ultParent_u == ultParent_v) return;
        
        if(size.get(ultParent_u) < size.get(ultParent_v)){
            parent.set(ultParent_u,ultParent_v);
            size.set(ultParent_v,size.get(ultParent_u)+size.get(ultParent_v));
        }else{
            parent.set(ultParent_v,ultParent_u);
            size.set(ultParent_u,size.get(ultParent_u)+size.get(ultParent_v));
        }
    }
    
    public int findRank(int node){
        return rank.get(node);
    }
    
    public void print(){
        System.out.println("Rank    -> "+rank);
        System.out.println("Parent  -> "+parent);
        System.out.println("Size    -> "+size);
    }
}

class KrusKals_Algorithm
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    int V=6;
	    int[][] edges={ 
	                     {5,4,9},
	                     {5,1,4},
	                     {1,4,1},
	                     {4,3,5},
	                     {4,2,3},
	                     {1,2,2},
	                     {2,3,3},
	                     {3,6,8},
	                     {2,6,7},
	                  };
	                  
	    ArrayList<EdgePair> MST=new ArrayList<>();    
	    
	    System.out.println("MST sum is  -> "+krusKalsAlgorithm(edges,V,MST));
	                  
	    System.out.print("\nMST Graph is  -> [ ");
	    for(EdgePair ind:MST){
	        System.out.print("("+ind.x+","+ind.y+") ");
	    }
	    System.out.print(" ]");
	   
	}
	
	public static int krusKalsAlgorithm(int[][] edges,int V,ArrayList<EdgePair> MST){
	    
	    
	    //Sort teh array/List(given) by weight in asc 
	    Arrays.sort(edges, Comparator.comparingInt(a -> a[2])); 
	    
	    //Apply DisjointSet
	    DisjointSet ds=new DisjointSet(V);
	    
	    //Initialize a viarble tp store MST sum 
	    int sum=0;
	    
	    for(int i=0;i<edges.length;i++){
	        
	        if(ds.findUltimateParent(edges[i][0])!=ds.findUltimateParent(edges[i][1])){

	            //Add to MST
	            ds.unionByRank(edges[i][0],edges[i][1]);
	            sum+=edges[i][2];
	            MST.add(new EdgePair(edges[i][0],edges[i][1]));
	        }
	        
	        if(MST.size() == V - 1) break;
	    }
	    
	    return sum;
	}
}
