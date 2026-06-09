import java.util.*;
import java.lang.*;
import java.io.*;

class MinimumBitFlipRequired
{
	public static void main (String[] args)
	{
	    int start=10,goal=7;
		System.out.println("Minimum Bit flip required to convert "+start+" to "+goal+" -> " +minBitFlip(3,4));
	}
	public static int minBitFlip(int start,int goal){
	    
	    int num=start^goal;
	    
	    int count=0;
	    while(num!=0){
	        num= num & (num-1);
	        count++;
	    }
	    
	    return count;
	}
   
   /*	
	public static int minBitFlips(int start,int goal){
	    
	    int num=start^goal;
	    
	    int count=0;
	    while(num>0){
	       count += num & 1;
	       num >>=1;
	    }
	    
	    return count;
	}
	*/
}
