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


class NumberOfEnclaves
{
    public static int noOfEnclaves=0; 
	public static void main (String[] args)
	{
	    int[][] mat = {
                       {0,0,0,1,1},
                       {0,0,1,1,0},
                       {0,1,0,0,0},
                       {0,1,1,0,0},
                       {0,0,0,1,1},
                      };
       
        System.out.println("    Initial                       After");
        print(mat,NoOfEnclaves(mat));
        
        System.out.println("\nTotal Number of Enclaves present(in Fig marked with 2)  ->  "+ noOfEnclaves);
        noOfEnclaves=0;
        
        
	}
	
	//BFS
	private static void markBoundaryLand(Queue<Index> queue,int[][] mat,boolean[][] visited){
	    int rLen=mat.length;
	    int cLen=mat[0].length;
	    
	    //Top-Boundary
	    for(int i=0;i<cLen;i++){
	       if(mat[0][i]==1)  {
	           visited[0][i]=true;
	           queue.add(new Index(0,i));
	       }
	    }
	    
	    //Right-Boundary
	    for(int i=1;i<rLen;i++){
	       if(mat[i][cLen-1]==1) {
	           visited[i][cLen-1]=true;
	           queue.add(new Index(i,cLen-1));
	       }
	    }    
	    
	    //Bottom-Boundary
	    if(rLen>1){
	        for(int i=cLen-2;i>=0;i--){
	             if(mat[rLen-1][i]==1) {
	                 visited[rLen-1][i]=true;
	                 queue.add(new Index(rLen-1,i));
	             }
	        }
	    }
	    
	    //Left-Boundary
	    if(cLen>1){
	        for(int i=rLen-2;i>0;i--){
	           if(mat[i][0]==1){
	              visited[i][0]=true;
	              queue.add(new Index(i,0));
	           } 
	        }
	    }
	}
	
	private static void bfs(Queue<Index> queue,int[][] mat,boolean[][] visited){
	    
	    int[] dx={-1,0,+1,0};
        int[] dy={0,+1,0,-1};
	    
	    
	    while(!queue.isEmpty()){
             Index curr=queue.poll();	        
	         int ro=curr.x;
	         int co=curr.y;
	    
             for(int i=0;i<4;i++){
               int row=ro+dx[i];
               int col=co+dy[i];
            
               if(row>=0 && col>=0 && row<mat.length && col<mat[0].length && !visited[row][col] && mat[row][col]==1){
                   visited[row][col]=true;
                   queue.add(new Index(row,col));
               }
            }
	    }
	}
	
    public static int[][] NoOfEnclaves(int[][] mat){
        
        boolean[][] visited=new boolean[mat.length][mat[0].length];
        int[][] ans=new int[mat.length][mat[0].length];
        Queue<Index> queue=new LinkedList<>();
        
        for (int i = 0; i < mat.length; i++) {
            ans[i] = mat[i].clone();
        }
        

        markBoundaryLand(queue,mat,visited);
        bfs(queue,mat,visited);
       
        for(int i=1;i<mat.length-1;i++){
            for(int j=1;j<mat[0].length-1;j++){
                if(mat[i][j]==1 && !visited[i][j]){
                    ans[i][j]=2;
                    noOfEnclaves++;
                }
            }
        }
        
        return ans;
    }
	
	//print 
    public static void print(int[][] mat,int[][] ans) {
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
