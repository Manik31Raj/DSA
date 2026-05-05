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


class RottenOranges
{
    public static int time=0;
    public static int countFresh=0;
	public static void main (String[] args) throws java.lang.Exception
	{
	   int[][] oranges = {
                       {1, 2, 1},
                       {0, 1, 0},
                       {0, 2, 1},
                      };
        
        System.out.println(" INITIAL              AFTER ROTTEN");
        print(oranges,rottenOranges(oranges));
        
        if(countFresh>0){
            System.out.println("All oranges cannot be rotten ");
            System.out.println("Total fresh Oranges still left -> "+countFresh);
            countFresh=0;
            time=0;
        }else{
             System.out.println("Time taken to make all fresh oranges rotten  -> "+time);
             countFresh=0;
             time=0;
        }
	}
	
	 /*
	     Rotten Oranges 0 -> empty , 1 -> fresh ,2 -> rotten
	    
                        (-1, 0)     
                           ↑         
              
            ( 0,-1)   ←  ( 0,0 ) →   (0,+1)
                          CELL       
                          
                           ↓         
                        (+1, 0)     
            
            
            Range (-1  ->  +1) 
             
       */
       
    private static void findAllRottenOranges(int[][] oranges,Queue<Index> queue){
        for(int i=0;i<oranges.length;i++){
            for(int j=0;j<oranges[0].length;j++){
                if(oranges[i][j]==2){
                    queue.add(new Index(i,j));
                }
                if(oranges[i][j]==1){
                    countFresh++;
                }
            }
        }
    }
    public static int[][] rottenOranges(int[][] oranges){
        
        Queue<Index> queue=new LinkedList<>();
        findAllRottenOranges(oranges,queue);
        
        int[][] ans = new int[oranges.length][oranges[0].length];

        for(int i = 0; i < oranges.length; i++){
              ans[i] = oranges[i].clone();
        }
    
        int[] dRow={-1,0,+1,0};
        int[] dCol={0,+1,0,-1};
        
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean infected = false;
            
             for(int i = 0; i < size; i++){
               Index curr = queue.poll();

               for(int d = 0; d < 4; d++){
                  int row = curr.x + dRow[d];
                  int col = curr.y + dCol[d];

                  if(isValid(oranges,row,col) && ans[row][col] == 1){
                     ans[row][col] = 2;
                     countFresh--;
                     queue.add(new Index(row,col));
                     infected = true;
                   }
                }
            }
            
            if(infected) time++;
        }
        return ans;
    }   
    
    private static boolean isValid(int[][] oranges,int r,int c){
        if(r>=0 && c>=0 && r<oranges.length && c<oranges[0].length){
            return true;
        }
        return false;
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
