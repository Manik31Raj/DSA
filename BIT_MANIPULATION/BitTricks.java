import java.util.*;
import java.lang.*;
import java.io.*;

class BitTricks
{
	public static void main (String[] args) 
	{
		int n=13,i=2;
		
		System.out.println("****Check if ith bit is set or unset****");
		System.out.print(" . Left Shift <<  :");
		if((n & (1<<i) )!= 0) {
		    System.out.print(" set");
		}else{
		    System.out.print(" unset");
		}
		System.out.println("");
		
		System.out.print(" . Right Shift << :");
			if((n>>i & 1 )!= 0) {
		    System.out.print(" set");
		}else{
		    System.out.print(" unset");
		}
		
		System.out.println("\n");
		System.out.println("****Set ith bit****");
		
		System.out.print(" . Left Shift <<  : ");
		System.out.print(n +" -> "+(n|(1<<i)));
		
		System.out.println("\n");
		System.out.println("****Clear ith bit****");
		System.out.print(" . Left Shift <<  : ");
		System.out.print(n +" -> "+(n & ~(1<<i)));
		
		System.out.println("\n");
		System.out.println("****Toggle ith bit****");
		System.out.print(" . Left Shift <<  : ");
		System.out.print(n +" -> "+(n ^ (1<<i)));
		
		System.out.println("\n");
		System.out.println("****Remove the last set bit****");
		System.out.print(" . Simple  : ");
		System.out.print(n +" -> "+(n & n-1));
		
		System.out.println("\n");
		System.out.println("****Check the number is power of 2****");
		System.out.print(" . Is "+n+" power of 2  : ");
		System.out.print(((n & n-1)==0 ? true:false));
		
		System.out.println("\n");
		System.out.println("****Count Number of set bit****");
		int count=0;
		int x=n;
		
		
		/*
		   while(x!=0){
		       x= x & x-1;
		       count++;
		   }
		*/
		while(x>1){
		    count += x&1;
		    x=x>>1;
		}
		if(x==1) count +=1;
		
		System.out.print(" . Number of set bits : "+count);

	}
}
