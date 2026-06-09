import java.util.*;
import java.lang.*;
import java.io.*;

class PowerSet
{
	public static void main (String[] args) 
	{
	    int[] nums={1,2,3};
	    int n=3;
		System.out.println("Power set -> "+powerSet(nums,n));

	}
	public static List<List<Integer>> powerSet(int[] nums,int n){
	    List<List<Integer>> sets=new ArrayList<>();
	    
	    int subsets=1<<n;
	    
	    for(int i=0;i<subsets;i++){
	        List<Integer> subList=new ArrayList<>();
	        
	        for(int j=0;j<n;j++){
	            
	            if((i & (1<<j)) != 0){
	                subList.add(nums[j]);
	            }
	        }
	        
	        sets.add(subList);
	    }
	    
	    return sets;
	}
}
