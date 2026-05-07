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
    
    
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Index other = (Index) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode(){
        return Objects.hash(x, y);
    }
}


class DistinctIslands
{
	public static void main (String[] args)
	{
	   int[][] mat = {
                       {1, 1, 0, 1, 1, 0, 0, 1},
                       {1, 0, 0, 0, 1, 0, 1, 1},
                       {0, 0, 1, 0, 0, 0, 0, 0},
                       {1, 1, 1, 0, 1, 1, 0, 0},
                       {0, 0, 0, 0, 1, 0, 0, 1},
                       {1, 1, 0, 0, 0, 0, 1, 1},
                       {1, 1, 0, 1, 1, 0, 0, 1}
                     };
       
        System.out.println("      MAP  ");
        print(mat);
        
        System.out.println("\nTotal number of distinct islands present -> "+distinctIslands(mat));

	}
	private static void bfs(int sr,int sc,int[][] mat,boolean[][] visited,HashSet<ArrayList<Index>> set){
	    
	    ArrayList<Index> list=new ArrayList<>();
	    list.add(new Index(0,0));
	    
	    Queue<Index> queue=new LinkedList<>();
	    queue.add(new Index(sr,sc));
	    
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
                   list.add(new Index(sr-row,sc-col));
                   queue.add(new Index(row,col));
               }
            }
	    }
	    set.add(list);
	}
	
    public static int distinctIslands(int[][] mat){
        
        boolean[][] visited=new boolean[mat.length][mat[0].length];
        HashSet<ArrayList<Index>> set=new HashSet<>();
        
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1 && !visited[i][j]){
                    visited[i][j]=true;
                    bfs(i,j,mat,visited,set);
                }
            }
        }
        return set.size();
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
