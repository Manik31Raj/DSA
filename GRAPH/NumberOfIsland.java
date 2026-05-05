import java.util.*;
import java.lang.*;
import java.io.*;

class Pair{
    int u;
    int v;
    public Pair(int u,int v){
        this.u=u;
        this.v=v;
    }
}

class Index{
    int x;
    int y;
    public Index(int x,int y){
        this.x=x;
        this.y=y;
    }
}


class NumberOfIsland
{
	public static void main (String[] args) throws java.lang.Exception
	{
	   int[][] grid = {
                       {1, 1, 0, 0},
                       {0, 1, 0, 1},
                       {1, 0, 0, 1},
                       {0, 0, 1, 1}
                      };
                      
       System.out.println("Numbr of Island present  -> "+getIsland(grid));
	}
	
	 /*
            (-1,-1)       (-1,0)     (-1,+1)
               ↖            ↑         ↗
              
            ( 0,-1)   ←  ( 0,0 ) →   (0,+1)
                          CELL       
                          
               ↙            ↓         ↘
            (+1,-1)       (+1,0)     (+1,+1)
            
            
            Range (-1  ->  +1) 
             
       */
	
    private static void  bfs(int ro,int co,int[][] grid,boolean[][] visited){
        visited[ro][co]=true;
        Queue<Index> queue=new LinkedList<>();
        queue.add(new Index(ro,co));
        
        while(!queue.isEmpty()){
            int row=queue.peek().x;
            int col=queue.peek().y;
            queue.remove();
            
            for(int x=-1;x<=1;x++){
            for(int y=-1;y<=1;y++){
                int newRow=row + x;
                int newCol=col + y;
                
                if(newRow>=0 && newCol>=0 && newRow<grid.length &&  newCol<grid[0].length &&!visited[newRow][newCol] && grid[newRow][newCol]==1){
                    visited[newRow][newCol]=true;
                    queue.add(new Index(newRow,newCol));
                }
            }
          } 
        }
    }
    
    
    
    public static int getIsland(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int island = 0;

       
       
        for(int i = 0; i < n; i++){
          for(int j = 0; j < m; j++){
              if(!visited[i][j] && grid[i][j]==1){
                  island++;
                  bfs(i,j,grid,visited);
              }
          }
        }  
          return island;
    }
}
