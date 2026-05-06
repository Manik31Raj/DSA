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


class 01MatrixProblem
{
	public static void main (String[] args)
	{
	   int[][] grid = {
                       {0, 0, 0},
                       {0, 1, 0},
                       {1, 0, 1},
                      };
        System.out.println(" Initial                 After");
        print(grid,distanceOfnearstOnes(grid));
        
	}
	
	private static void FindOnes(int[][] grid,Queue<Index> queue,int[][] ans,boolean[][] visited){
	    for(int i=0;i<grid.length;i++){
	        for(int j=0;j<grid[0].length;j++){
	            if(grid[i][j]==1){
	                queue.add(new Index(i,j));
	                ans[i][j]=0;
	                visited[i][j]=true;
	            }
	        }
	    }
	}
	
	
	public static int[][] distanceOfnearstOnes(int[][] grid){
	    int[][] ans=new int[grid.length][grid[0].length];
	    boolean[][] visited=new boolean[grid.length][grid[0].length];
	    Queue<Index> queue=new LinkedList<>();
	    
	    FindOnes(grid,queue,ans,visited);
	
	    
	    int[] dx={-1,0,+1,0};
        int[] dy={0,+1,0,-1};
        
        while(!queue.isEmpty()){
           Index ind=queue.poll();
           int ro=ind.x;
           int co=ind.y;
               
            
           for(int i=0;i<4;i++){
              int row=ro+dx[i];
              int col=co+dy[i];
                
              if(row>=0 && col>=0 && row<grid.length && col<grid[0].length && !visited[row][col]){
                  
                ans[row][col]=ans[ro][co]+1;
                visited[row][col]=true;
                queue.add(new Index(row,col));
              }
            }
        }
        
        return ans;
	}
	
	
	//print 
    public static void print(int[][] oranges,int[][] ans) {
        for(int i=0;i<oranges.length;i++){
            for(int j=0;j<oranges[0].length;j++){
                System.out.print(" "+oranges[i][j]+" ");
            }
            
            if(i==oranges.length/2){ 
                System.out.print("   ------>    ");
            }else{
                System.out.print("              ");
            }
            for(int j=0;j<oranges[0].length;j++){
                System.out.print(" "+ans[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
