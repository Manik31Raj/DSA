import java.util.*;
import java.lang.*;
import java.io.*;

class Index{
    int x;
    int y;
    public Index(int x,int y){
        this.x=x;
        this.y=y;
    }
}


class SurroundedRegionswithOX
{
	public static void main (String[] args)
	{
	   char[][] mat = {
                       {'X','X','X','X','X'},
                       {'X','O','O','X','O'},
                       {'X','X','O','X','O'},
                       {'X','O','X','O','X'},
                       {'O','O','X','X','X'},
                      };
        System.out.println("    Initial                       After");
        print(mat,surroundedRegion(mat));
        
        
	}
	
	private static void markBoundaryO(char[][] mat,boolean[][] visited){
	    int rLen=mat.length;
	    int cLen=mat[0].length;
	    
	    //Top-Boundary
	    for(int i=0;i<cLen;i++){
	       if(mat[0][i]=='O')      dfsBoundary0(new Index(0,i),mat,visited);
	    }
	    
	    //Right-Boundary
	    for(int i=1;i<rLen;i++){
	       if(mat[i][cLen-1]=='O')  dfsBoundary0(new Index(i,cLen-1),mat,visited);
	    }    
	    
	    //Bottom-Boundary
	    if(rLen>1){
	        for(int i=cLen-2;i>=0;i--){
	             if(mat[rLen-1][i]=='O')  dfsBoundary0(new Index(rLen-1,i),mat,visited);
	        }
	    }
	    
	    //Left-Boundary
	    if(cLen>1){
	        for(int i=rLen-2;i>0;i--){
	           if(mat[i][0]=='O')  dfsBoundary0(new Index(i,0),mat,visited);
	        }
	    }
	}
	
	private static void dfsBoundary0(Index index,char[][] mat,boolean[][] visited){
	    int ro=index.x;
	    int co=index.y;
	    
	    visited[ro][co]=true;
	    
	    int[] dx={-1,0,+1,0};
        int[] dy={0,+1,0,-1};
        
        for(int i=0;i<4;i++){
            int row=ro+dx[i];
            int col=co+dy[i];
            
            if(row>=0 && col>=0 && row<mat.length && col<mat[0].length && !visited[row][col] && mat[row][col]=='O'){
                dfsBoundary0(new Index(row,col),mat,visited);
            }
        }
	    
	}
	
	private static void dfsInner(Index index,char[][] mat,char[][] ans,boolean[][] visited){
	    int ro=index.x;
	    int co=index.y;
	    
	    ans[ro][co]='X';
	    visited[ro][co]=true;
	    
	    int[] dx={-1,0,+1,0};
        int[] dy={0,+1,0,-1};
        
        for(int i=0;i<4;i++){
            int row=ro+dx[i];
            int col=co+dy[i];
            
            if(row>=0 && col>=0 && row<mat.length && col<mat[0].length && !visited[row][col] && ans[row][col]=='O'){
                dfsInner(new Index(row,col),mat,ans,visited);
            }
        }
	}
	
    public static char[][] surroundedRegion(char[][] mat){
        
        boolean[][] visited=new boolean[mat.length][mat[0].length];
        char[][] ans=new char[mat.length][mat[0].length];
        
        for (int i = 0; i < mat.length; i++) {
            ans[i] = mat[i].clone();
        }
        
        //Only outer boundary parts 
        markBoundaryO(mat,visited);
        
        //Only traverse inner parts
        for(int i=1;i<mat.length-1;i++){
            for(int j=1;j<mat[0].length-1;j++){
                if(mat[i][j]=='O' && !visited[i][j]){
                    dfsInner(new Index(i,j),mat,ans,visited);
                }
            }
        }
        
        return ans;
    }
	
	//print 
    public static void print(char[][] mat,char[][] ans) {
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.print(" "+mat[i][j]+" ");
            }
            
            if(i==mat.length/2){ 
                System.out.print("   ------>    ");
            }else{
                System.out.print("              ");
            }
            for(int j=0;j<mat[0].length;j++){
                System.out.print(" "+ans[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
