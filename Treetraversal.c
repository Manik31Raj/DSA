#include<stdio.h>
#include<stdlib.h>
struct node
 {
    int data;
    struct node *left;
    struct node *right;
 };
struct node *getnode(int val)
 {
    struct node *newnode;
    newnode=malloc(sizeof(struct node));
    newnode->data=val;
    newnode->left=NULL;
    newnode->right=NULL;
    return newnode;
 }
struct node *insert(struct node *root,int val)
 {
    if(root==NULL)
     return getnode(val);
    if(root->data<val)
     root->right=insert(root->right,val);
    if (root->data>val)
     root->left=insert(root->left,val);
    return root; 
 }
void inorder(struct node *root)
 {
    if(root==NULL)
     return;
    inorder(root->left);
    printf("%d",root->data);
    inorder(root->right);
 }
void postorder(struct node *root)
 {
    if(root==NULL)
     return;
    printf("%d",root->data); 
    postorder(root->left);
    postorder(root->right);
 }
void preorder(struct node *root)
 {
    if(root==NULL)
     return;
    preorder(root->left);
    preorder(root->right);
    printf("%d",root->data);
 }
int main()
 {
    struct node *root=NULL;
    int ch,val;
    while(ch!=7)
     {
        printf("1.Insert \n2.Inorder \n3.Postorder \n4.Preorder \n5.Exit \nEnter your choice : ");
        scanf("%d",&ch);
        switch(ch)
         {
            case 1:
            printf("Enter the value : ");
            scanf("%d",&val);
            root=insert(root,val);
            break;
            case 2:
            inorder(root);
            printf("\n");
            break;
            case 3:
            postorder(root);
            printf("\n");
            break;
            case 4:
            preorder(root);
            printf("\n");
            break;
            case 5:
            exit(0);
            break;
            default:
            printf("Enter correct choice !!");
            break;
         }
     }
 }
 
 
 
 
 
 
 
 
