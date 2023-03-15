#include <stdio.h>
#include<stdlib.h>
#define size 20
int top=-1,head=0;
char stack[size];
void push(char);
void pop();
int main()
{
   char ch[30];
   printf("Enter the expression : ");
   scanf("%s",ch);
   for(int j=0;j<20;j++)
    {
        switch(ch[j])
         {
            case '+':
            case '-':
            if(stack[top]=='*'||stack[top]=='/')
            pop();
            push(ch[j]);
            break;
            case '*':
            case '/':
            push(ch[j]);
            break;
            case '(':
            break;
            case ')':
            break;
            default:
            printf("%C",ch[j]);
            break;
         }
    }
    pop();
    return 0;
}
void push(char x)
 {
    if(top!=size-1) 
     {
         top++;
         stack[top]=x;
     }
 }
void pop()
 {
    for(int i=top;i>=0;i--)
     {
         printf("%c",stack[i]);
     }
     top=-1;
 }









