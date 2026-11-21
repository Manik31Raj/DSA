import java.util.*;
import java.lang.*;
import java.io.*;

class InsertionSort
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] arr={6,8,3,4,2};
		
		for(int x:insertionSort(arr)){
		    System.out.println(x +" ");
		}

	}
	
	public static int[] insertionSort(int[] arr) {
        if (arr.length <= 1) return arr;

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i]; // Element to be placed in the sorted portion
            int j = i - 1;

            // Shift elements of the sorted portion that are greater than key to the right
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            
            // Insert the key into its correct position
            arr[j + 1] = key;
        }
        return arr;
	}
}
