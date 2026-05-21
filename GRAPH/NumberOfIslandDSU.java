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

class NumberOfIslandDSU
{
	public static void main (String[] args)
	{
	    int r=4,c=5;
	    int[][] index={ 
	                     {0,0},
	                     {0,0},
	                     {1,1},
	                     {1,0},
	                     {0,1},
	                     {0,3},
	                     {1,3},
	                     {0,4},
	                     {3,2},
	                     {2,2},
	                     {1,2},
	                     {0,2},
	                  };
	                  
	   System.out.println("Number of island present at while putting each index   - >  "+noOfIsland(index,r,c));
	                  
	}
	public static List<Integer> noOfIsland(int[][] index,int r,int c){
	    
	    List<Integer> ans=new ArrayList<>();
	    int[][] grid=new int[r][c];
	    boolean[][] visited=new boolean[r][c];
	    int island=0;
	    int[] dx={-1,+1,0,0};
	    int[] dy={0,0,-1,+1};
	    
	    DisjointSet ds=new DisjointSet(r*c);
	    
	    for(int i=0;i<index.length;i++){
	        
	        int currR=index[i][0];
	        int currC=index[i][1];
	        if(visited[currR][currC]){
	            ans.add(island);
	            continue;
	        } 
	        
	        visited[currR][currC]=true;
	        grid[currR][currC]=1;
	        int node=currR*c + currC;
	        island+=1;
	        
	        for(int j=0;j<4;j++){
	            int row=currR+dx[j];
	            int col=currC+dy[j];
	            
	            if(row>=0 && col>=0 && row<grid.length && col<grid[0].length && visited[row][col]){
	                 int currNode=row*c+col;
	                 if(ds.findUltimateParent(node)!=ds.findUltimateParent(currNode)){
	                     ds.unionBySize(node,currNode);
	                     island--;
	                 }
	            }
	        }
	        
	        ans.add(island);
	    }
	    
	    return ans;
	    
	}

}
