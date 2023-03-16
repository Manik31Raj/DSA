#include<stdio.h>
#include<stdlib.h>
int search(int a[],int x,int n)
 {
    for(int i=0;i<n;i++)
     {
        if(a[i]==x)
         return i;
     }
     return-1;
 }
int main()
 {
    int a[]={1,2,3,4,5,6,7,8};
    int  n=sizeof(a)/sizeof(a[0]);
    int x;
    printf("Enter the element to be searched : ");
    scanf("%d",&x);
    int result=search(a,x,n);
    if(result==-1)
     printf("Element not found!!");
    else
     printf("Element found at index %d",result);
 }
