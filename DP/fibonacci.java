import java.util.*;
import java.lang.*;
import java.io.*;

class fibonacci
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println(fibonacci(n));

	}
	
	public static int fibonacci(int n){
	    
	    int prev=1;
	    int prev2=0;
	    
	    if(n==0) return prev2;
	    if(n==1) return prev;
	    
	    for(int i=2;i<=n;i++){
	        int curr=prev+prev2;
	        prev2=prev;
	        prev=curr;
	    }
	    
	    return prev;
	}
}
