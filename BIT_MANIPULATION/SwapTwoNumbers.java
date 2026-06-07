import java.util.*;
import java.lang.*;
import java.io.*;

class SwapTwoNumbers
{
	public static void main (String[] args)
	{
		int x=12,y=23;
		System.out.println("Before  -> x : "+x+" , y : "+y );
		
		//swap using BITs
		
		x=x^y;
        y=x^y;
        x=x^y;
        
		
		System.out.println("After   -> x : "+x+" , y : "+y );
		

	}
}
