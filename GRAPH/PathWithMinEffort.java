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

class Distance implements Comparable<Distance>{
    int effort;
    Index index;
    public Distance(int effort,Index index){
        this.effort=effort;
        this.index=index;
    }
    
    @Override
    public int compareTo(Distance other) {
        return Integer.compare(this.effort, other.effort);
    }
}


class PathWithMinEffort
{
	public static void main (String[] args)
	{
	    int[][] maze = {
                         {1,2,2},
                         {3,8,2},
                         {5,3,5},
                       };
       
        System.out.println("  MAZE   ");
        print(maze);
        
        Index src=new Index(0,0);
        Index des=new Index(2,2);
        
        System.out.println("Minimum Effort neede to travel from source("+src.x+","+src.y+") to destination("+des.x+","+des.y+") -> "+minEffort(maze,src,des));
	}
	public static int minEffort(int[][] maze,Index src,Index des){
	    
	    int[][] dist=new int[maze.length][maze[0].length];
	    for(int i=0;i<maze.length;i++){
          Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
	    
	    int[] dx={-1,0,+1,0};
        int[] dy={0,+1,0,-1};
	    
	    
	    PriorityQueue<Distance> pq=new PriorityQueue<>();
	    pq.add(new Distance(0,src));
	    dist[src.x][src.y]=0;
	    
	    while(!pq.isEmpty()){
	        Distance dis=pq.poll();
	        int effortSoFar=dis.effort;
	        int ro=dis.index.x;
	        int co=dis.index.y;
	        
	        if(effortSoFar > dist[ro][co]) continue;

            if(ro == des.x && co == des.y) return effortSoFar;
	        
            for(int j=0;j<4;j++){
                int row=ro+dx[j];
                int col=co+dy[j];
            
               if(row>=0 && col>=0 && row<maze.length && col<maze[0].length){
                   
                    int edgeCost=Math.abs(maze[row][col]-maze[ro][co]);
                    int newEffort=Math.max(effortSoFar,edgeCost);
                    
                    if(newEffort <dist[row][col]){
                        dist[row][col]=newEffort;
                        pq.add(new Distance(newEffort,new Index(row,col)));
                    }
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
