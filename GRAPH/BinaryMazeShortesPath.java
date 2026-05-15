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

class Distance{
    int distance;
    Index index;
    public Distance(int distance,Index index){
        this.distance=distance;
        this.index=index;
    }
}


class BinaryMazeShortesPath
{
    public static int noOfEnclaves=0; 
	public static void main (String[] args)
	{
	    int[][] maze = {
                       {1,1,1,1},
                       {1,1,0,1},
                       {1,1,1,1},
                       {1,1,0,0},
                       {1,0,0,0},
                      };
       
        System.out.println("    MAZE   ");
        print(maze);
        
        Index src=new Index(0,1);
        Index des=new Index(2,2);
        
        System.out.println("Shortest Path Distance from source("+src.x+","+src.y+") to destination("+des.x+","+des.y+") -> "+shorstesPathDistance(maze,src,des));
	}
	public static int shorstesPathDistance(int[][] maze,Index src,Index des){
	    
	    int[][] dist=new int[maze.length][maze[0].length];
	    for(int i=0;i<maze.length;i++){
          Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
	    
	    if(maze[src.x][src.y]!=1 || maze[des.x][des.y]!=1) return -1;
	    
	    if(src.x==des.x && src.y==des.y) return 0;
	    
	    int[] dx={-1,0,+1,0};
        int[] dy={0,+1,0,-1};
	    
	    
	    Queue<Distance> q=new LinkedList<>();
	    q.add(new Distance(0,src));
	    dist[src.x][src.y]=0;
	    
	    while(!q.isEmpty()){
	        Distance dis=q.poll();
	        int d=dis.distance;
	        int ro=dis.index.x;
	        int co=dis.index.y;
	        
	           
            for(int j=0;j<4;j++){
                int row=ro+dx[j];
                int col=co+dy[j];
            
               if(row>=0 && col>=0 && row<maze.length && col<maze[0].length && maze[row][col]==1 && dist[row][col] > d + 1){
                   
                      dist[row][col]=d+1;
                      if(des.x==row && des.y==col) return dist[row][col];
                      
                      q.add(new Distance(dist[row][col],new Index(row,col)));
                }   
            }
	    }
	    
	    return -1;
	}
	
	//print 
    public static void print(int[][] mat) {
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.print(" "+mat[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
