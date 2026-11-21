import java.util.*;
import java.lang.*;
import java.io.*;

class SelectionSort
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] arr={6,8,3,4,2};
		
		for(int x:selectionSort(arr)){
		    System.out.println(x +" ");
		}

	}
	
	public static int[] selectionSort(int[] arr){
	    
	    if(arr.length==0 || arr.length==1) return arr;
	    
	    for(int i=0;i<arr.length-1;i++){
	        
	        int minVal=arr[i];
	        int loc=i;
	        
	        for(int j=i+1;j<arr.length;j++){
	            
	            if(minVal>arr[j]){
	                minVal=arr[j];
	                loc=j;
	            }
	        }
	        
	        if(loc!=i){
	            int temp=arr[i];
	            arr[i]=minVal;
	            arr[loc]=temp;
	        }
	    }
	    
	    return arr;
	}    
}
