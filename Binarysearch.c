#include<stdio.h>
#include<stdlib.h>
int search(int a[],int x,int low,int high)
 {
    while(low<=high)
     {
        int mid=low+(high-low)/2;
        if(a[mid]==x)
         return mid;
        if(a[mid]>x)
         high=mid-1;
        if(a[mid]<x)
         low=mid+1;
     }
    return -1; 
 }  
int main()
 {
    int a[]={1,2,3,4,5,6,7,8};
    int  n=sizeof(a)/sizeof(a[0]);
    int x;
    printf("Enter the element to be searched : ");
    scanf("%d",&x);
    int result=search(a,x,0,n-1);
    if(result==-1)
     printf("Element not found!!");
    else
     printf("Element found at index %d",result);
 }
