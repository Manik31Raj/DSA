#include<stdio.h>
#define size 10
int arr[size],i,j,front=-1,rear=0;
 void push(int);
 void pop();
 void show();
 int main()
  {
     int ch,x,n=1;
     while(n)
      {
        printf("MENU \n1.Push \n2.Pop \n3.Show \n4.Exit \nEnter your choice : ");
        scanf("%d",&ch);
        switch(ch)
         {
            case 1:
            printf("Enter the element : ");
            scanf("%d",&x);
            push(x);
            break;
            case 2:
            pop();
            break;
            case 3:
            show();
            break;
            case 4:
            n=0;
            break;
            default:
            printf("Enter correct choice!!");
            break;
            
         }
      }
      return 0;
  }
void push(int n)
  {
    if(rear==size)
     {
         printf("Overflow\n");
     }
    else
     {
       if(front==-1)
        front++;
        arr[rear]=n;
        rear++;
     }
  }
void pop()
 {
     if(front==-1)
      {
        printf("Underflow\n");
      }
     else
      {
        printf("%d is deleted\n",arr[front]);
        front++;
      }
 }
void show()
 {
    for(i=front;i<rear;i++)
     {
        printf("%d\n",arr[i]);
     }
 }
  
  
  
  
  
  
  
