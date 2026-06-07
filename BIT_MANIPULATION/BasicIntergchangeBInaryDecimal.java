import java.util.*;
import java.lang.*;
import java.io.*;

class BasicIntergchangeBInaryDecimal
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int deci=13;
		String binary="1011";
		System.out.println(binaryToDecimal(binary));
		System.out.println(decimalToBinary(deci));
		

	}
	public static int binaryToDecimal(String binary){
	    if(binary.length()==0) return 0;
	    
	    int decimal=0;
	    int power=1;
	    for(int i=binary.length()-1;i>=0;i--){
	        if(binary.charAt(i)=='1') decimal+=power;
	        
	        power=power*2;
	    }
	    
	    return decimal;
	}
	
	public static String decimalToBinary(int decimal){
	    if(decimal==0) return "0";
	    
	    StringBuilder sb=new StringBuilder();
	    while(decimal!=1){
	        
	        if(decimal%2==1) sb.append('1');
	        else sb.append('0');
	        
	        decimal=decimal/2;
	    }
	    sb.append('1');
	    
	    return sb.reverse().toString();
	}
}
