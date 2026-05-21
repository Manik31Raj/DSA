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

class MakingLargestIsland
{
	public static void main (String[] args)
	{
	    int r=6,c=5;
	    int[][] grid={ 
	                     {1,1,0,1,1},
	                     {1,1,0,1,1},
	                     {1,1,0,1,1},
	                     {0,0,1,0,0},
	                     {0,0,1,1,1},
	                     {0,0,1,1,1},
	                  };
	                  
	   System.out.println("Size of Large Island  - >  "+makingLargeIsland(grid,r,c));
	                  
	}
	public static int makingLargeIsland(int[][] grid,int r,int c){
	    
	    int[] dx={-1,+1,0,0};
	    int[] dy={0,0,-1,+1};
	    
	    
	    int maxSize=1;
	    
	    DisjointSet ds=new DisjointSet(r*c);
	    
	    for(int i=0;i<r;i++){
	        for(int j=0;j<c;j++){
	            if(grid[i][j]==0) continue;
	            
	            int node=i*c+j;
	            
	            for(int k=0;k<4;k++){
	                int row = i + dx[k];
	                int col = j + dy[k];
	                
	                if(row>=0 && col>=0 && row<grid.length && col<grid[0].length && grid[row][col]==1){
	                    
	                    int currNode= row*c + col;
	                    if(ds.findUltimateParent(currNode)!=ds.findUltimateParent(node)){
	                        ds.unionBySize(node,currNode);
	                        maxSize=Math.max(maxSize,ds.size.get(ds.findUltimateParent(currNode)));
	                    }
	                }
	            }
	            
	            
	        }
	    }
	    
	     for(int i=0;i<r;i++){
	        for(int j=0;j<c;j++){
	            if(grid[i][j]==1) continue;
	            
	            int currSize=0;
	            Set<Integer> set=new HashSet<>();
	            for(int k=0;k<4;k++){
	                int row = i + dx[k];
	                int col = j + dy[k];
	                
	                if(row>=0 && col>=0 && row<grid.length && col<grid[0].length && grid[row][col]==1){
	                    
	                    int currNode= row * c +col;
	                    
	                    int par=ds.findUltimateParent(currNode);
	                    
	                    set.add(par);
	                }
	            }
	            
	            for(int x:set){
	                currSize+=ds.size.get(x);
	            }
	            
	            
	            if(maxSize < currSize+1)  maxSize=currSize+1;
	            
	        }
	    }
	    
	    
	    
	    
	    
	    return maxSize;
	    
	}

}
