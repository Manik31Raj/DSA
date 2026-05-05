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


class FloodFillAlgorithm
{
	public static void main (String[] args) throws java.lang.Exception
	{
	   int[][] image = {
                       {1, 1, 1},
                       {2, 2, 0},
                       {2, 2, 2},
                      };
        int sr=2,sc=0,newColour=3;
        
        
        System.out.println(" INITIAL           AFTER COLORING(BFS)");
        print(image,floodFillBFS(image,sr,sc,newColour));
        
        System.out.println(" INITIAL           AFTER COLORING(DFS)");
        print(image,floodFillDFS(image,sr,sc,newColour));
      
	}
	
	 /*
	    Flood Fill Algorithm
	    
                        (-1, 0)     
                           ↑         
              
            ( 0,-1)   ←  ( 0,0 ) →   (0,+1)
                          CELL       
                          
                           ↓         
                        (+1, 0)     
            
            
            Range (-1  ->  +1) 
             
       */

 // Using DFS
    private static void dfs(int sr,int sc,int[][] ans,int[][] image,int[] dRow,int[] dCol,int intitialColour,int newColour){
        
        ans[sr][sc]=newColour;
        int n=image.length;
        int m=image[0].length;
        
        for(int i=0;i<4;i++){
            int row=sr+dRow[i];
            int col=sc+dCol[i];
            
            if(isValid(image,row,col) && image[row][col]==intitialColour && ans[row][col]!=newColour){
                dfs(row,col,ans,image,dRow,dCol,intitialColour,newColour);
            }
        }
    }   
       
    public static int[][]  floodFillDFS(int[][] image,int sr,int sc,int newColour){
        int intitialColour=image[sr][sc];
        
        int[][] ans = new int[image.length][image[0].length];

        for(int i = 0; i < image.length; i++){
              ans[i] = image[i].clone();
        }
        
        int[] dRow={-1,0,+1,0};
        int[] dCol={0,+1,0,-1};
        dfs(sr,sc,ans,image,dRow,dCol,intitialColour,newColour);
        return ans;
    }  

   // Using BFS
    public static int[][] floodFillBFS(int[][] image,int sr,int sc,int newColour){
        int currColour=image[sr][sc];
        
        int[][] ans = new int[image.length][image[0].length];

        for(int i = 0; i < image.length; i++){
              ans[i] = image[i].clone();
        }
        
        if(currColour == newColour) return ans; 
        
        Queue<Index> queue=new LinkedList<>();
        int[] dRow={-1,0,+1,0};
        int[] dCol={0,+1,0,-1};
        queue.add(new Index(sr,sc));
        ans[sr][sc]=newColour;
        
        while(!queue.isEmpty()){
            Index curr=queue.poll();
            int ro=curr.x;
            int co=curr.y;
            
            for(int i=0;i<4;i++){
              int row=ro+dRow[i];
              int col=co+dCol[i];
            
                if(isValid(image,row,col) && image[row][col]==currColour && ans[row][col]!=newColour){
                     ans[row][col]=newColour;
                     queue.add(new Index(row,col));
                  }
             }
            
        }
        
        return ans;
    }   
    
    private static boolean isValid(int[][] image,int r,int c){
        if(r>=0 && c>=0 && r<image.length && c<image[0].length){
            return true;
        }
        return false;
    }
    
    
	//print 
    public static void print(int[][] image,int[][] ans) {
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                System.out.print(" "+image[i][j]+" ");
            }
            
            if(i==image.length/2){ 
                System.out.print("   ------>    ");
            }else{
                System.out.print("              ");
            }
            for(int j=0;j<image[0].length;j++){
                System.out.print(" "+ans[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
