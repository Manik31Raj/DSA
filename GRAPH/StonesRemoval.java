import java.util.*;
import java.lang.*;
import java.io.*;


class DisjointSet{
    List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    
    public DisjointSet(int n){
        for(int i=0;i<n;i++){
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
}

class StonesRemoval
{
	public static void main (String[] args)
	{
	    int r=5,c=4;
	    int[][] stones={ 
	                     {1,0,1,0},
	                     {0,0,0,1},
	                     {0,0,0,0},
	                     {0,1,1,0},
	                     {0,0,0,1},
	                  };
	                  
	   System.out.println("Max Stone that can be removed  - >  "+maxStoneRemoval(stones,r,c));
	                  
	}
	public static int maxStoneRemoval(int[][] stones,int r,int c){
	    
	   int stone=0;
	   int component=0;
	   
	   DisjointSet ds=new DisjointSet(r+c);
	   
	   for(int i=0;i<r;i++){
	       for(int j=0;j<c;j++){
	           if(stones[i][j]==0) continue;
	           
	           stone++;
	           int col=j+r;
	           
	           if(ds.findUltimateParent(i)!=ds.findUltimateParent(col)){
	               ds.unionBySize(i,col);
	           }
	       }
	   }
	   
	   for(int i=0;i<r+c;i++){
	       if(ds.findUltimateParent(i)==i && ds.size.get(i)>1){
	           component++;
	       }
	   }
	  
	   
	   return stone - component;
	}

}
