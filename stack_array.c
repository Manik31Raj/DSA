#include<stdio.h>
#include<stdlib.h>
#define max 100
int top=-1;
int a[max];
void push();
void pop();
void show();
void push()
 {
    int item;
    if(top==max-1)
     printf("Stack is full!!!");
    else
     {  
        printf("Enter the element : ");
        scanf("%d",&item); 
        top=top+1;
        a[top]=item;
     }
 }
void pop()
 {
    if(top==-1)
     printf("Stack is empty!!");
    else 
     {
        printf("Element deleted %d ",a[top]);
        top=top-1;
     }
 }
void show()
{
    if(top==-1)
     printf("Stack is empty!!");
    else
     {
        printf("Stack elements : ");
         for(int i=top;i>-1;--i)
          {
            printf("%d ",a[i]);  
          }
     }
}
int main()
 {
    int ch,item;
    while(ch!=7)
     {
        printf("1.Push \n2.Pop \n3.Show \n4.Exit \n Enter your choice : ");
        scanf("%d",&ch);
        switch(ch)
         {
            case 1:
            push();
            break;
            case 2:
            pop();
            break;
            case 3:
            show();
            break;
            case 4:
            exit(0);
            break;
            default:
            printf("Enter right choice!!");
            break;
         }
     }
 }
















