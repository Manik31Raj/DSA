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

class MakingTheGraphConncted
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    int V=9;
	    int[][] edges={ 
	                     {1,2},
	                     {2,3},
	                     {3,1},
	                     {4,2},
	                     {4,1},
	                     {5,6},
	                     {6,7},
	                     {8,9},
	                  };
    
	    ArrayList<EdgePair> graph=new ArrayList<>();
	    
	    System.out.println("No of Opertains to connect the graph  -> "+edgesToConnectGraph(edges,V,graph));
	    
	    System.out.print("\nNew Connected Graph edges  -> [");
	    for(EdgePair e:graph){
	        System.out.print("("+e.x+","+e.y+") ");
	    }
	    System.out.print("]");
	}
	
	public static int edgesToConnectGraph(int[][] edges,int V,ArrayList<EdgePair> graph){
	    
	    
	    int component=0;
	    int extraEdges=0;
	    
	    //Apply DisjointSet
	    DisjointSet ds=new DisjointSet(V);
	    
	    for(int i=0;i<edges.length;i++){
	        if(ds.findUltimateParent(edges[i][0])!=ds.findUltimateParent(edges[i][1])){
	           ds.unionBySize(edges[i][0],edges[i][1]);
	           graph.add(new EdgePair(edges[i][0],edges[i][1]));
	        }else{
	            
	            extraEdges++;
	        }
	    }
	    
	    int node=-1;
	    for(int i=1;i<=V;i++){
	        if(ds.findUltimateParent(i)==i){
	            if(node!=-1 && node!=ds.findUltimateParent(i)){
	                graph.add(new EdgePair(node,i));
	            }
	            node=i;
	            component++;
	        }
	    }    
	
	    return extraEdges>=component-1 ? (component-1):-1;
	}
}
