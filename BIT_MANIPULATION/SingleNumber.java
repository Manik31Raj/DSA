import java.util.*;
import java.lang.*;
import java.io.*;

class SingleNumber
{
	public static void main (String[] args) 
	{
	    int[] nums={1,2,2,3,3,43,23,23,43,1,25};
		System.out.println("Single Number present ina array -> "+findSingleNumber(nums));

	}
	public static int findSingleNumber(int[] nums){
	    if(nums.length==0) return -1;
	    
	    int ans=nums[0];
	    for(int i=1;i<nums.length;i++){
	        
	        ans=ans^nums[i];
	    }
	    
	    return ans;
	}
}
