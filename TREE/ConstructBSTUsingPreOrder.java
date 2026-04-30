import java.util.*;
import java.lang.*;
import java.io.*;

class Node{
    int data;
    Node left;
    Node right;
    public Node(int key){
        this.data=key;
    }
}
class ConstructBSTUsingPreOrder
{
	public static void main (String[] args)
	{
	   int[] preOrder={8,5,1,7,10,12};
	   printTree(ConstructBST(preOrder));
	}
	
   public static Node ConstructBST(int[] preOrder){
      return ConstructBST(preOrder,Integer.MAX_VALUE,new int[]{0});
   }
   public static Node ConstructBST(int[] preOrder,int bound,int[] newArr){
       
       if(newArr[0] ==preOrder.length || preOrder[newArr[0]]>bound) return null;
       
       Node root=new Node(preOrder[newArr[0]++]);
       root.left=ConstructBST(preOrder,root.data,newArr);
       root.right=ConstructBST(preOrder,bound,newArr);
       return root;
   }

	
	public static void printTree(Node root){
     if(root == null){
        System.out.println("Level 0 -> [null]");
        return;
     }

     Queue<Node> q = new LinkedList<>();
     q.offer(root);
 
     int level = 0;   

     while(!q.isEmpty()){
        int size = q.size();
        boolean allNull = true;

        System.out.print("Level " + level + " -> [");

        for(int i = 0; i < size; i++){
            Node curr = q.poll();

            if(curr == null){
                System.out.print("-");
                q.offer(null);
                q.offer(null);
            }else{
                System.out.print(curr.data);

                if(curr.left != null || curr.right != null){
                    allNull = false;
                }

                q.offer(curr.left);
                q.offer(curr.right);
            }

            if(i != size - 1) System.out.print(", ");
        }

        System.out.println("]");

        if(allNull) break;  // stop when next level all null

        level++;
     }
   }
}
