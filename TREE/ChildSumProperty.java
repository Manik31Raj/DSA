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

class Pair{
    Node node;
    int index;
    public Pair(Node node,int index){
        this.node=node;
        this.index=index;
    }
}


class ChildSumProperty
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Node root=new Node(50);
		root.left=new Node(7);
		root.right=new Node(2);
		root.left.left=new Node(3);
		root.left.right=new Node(5);
		root.right.left=new Node(1);
		root.right.right=new Node(30);
		
	   System.out.println("**************************Before***************************\n");
	   
	   printTree(root);
	   
	   changeTree(root);
	   
	   System.out.println("\n***************************After***************************\n");
	   
	   printTree(root);
	}
	
	public static void changeTree(Node root){
	    
	    if(root==null ) return ;
	    
	    int child=0;
	    if(root.left!=null){
	        child+=root.left.data;
	    }
	    
	    if(root.right!=null){
	        child+=root.right.data;
	    }
	    
	    if(child>=root.data){
	       root.data=child;
	    } else{
	        if(root.left!=null) root.left.data=root.data;
	        else if(root.right!=null) root.right.data=root.data;
	    }
	   
	    changeTree(root.left);
	    changeTree(root.right);
	    
	    int total=0;
	    if(root.left!=null) total+=root.left.data;
	    if(root.right!=null) total+=root.right.data;
	    if(root.left !=null || root.right!=null) root.data=total;
	    
	}





// for printing (all main code are above)
	
    public static void printTree(Node root) {
        int h = getHeight(root);
        // Calculate total width: each node slot is roughly 6 chars for "null " or "val  "
        int width = (int) Math.pow(2, h) * 6;
        String[][] canvas = new String[h][width];
        for (String[] row : canvas) Arrays.fill(row, "");

        fill(canvas, root, 0, 0, width - 1);

        for (int i = 0; i < h; i++) {
            System.out.print("Level " + i + " -> ");
            for (int j = 0; j < width; j++) {
                System.out.print(canvas[i][j].isEmpty() ? " " : canvas[i][j]);
            }
            System.out.println();
        }
    }

    private static void fill(String[][] canvas, Node n, int row, int L, int R) {
        if (row >= canvas.length) return;

        int mid = (L + R) / 2;
        if (n == null) {
            canvas[row][mid] = "null";
            // Even if null, we "fill" children as null to maintain the spacing grid
            fill(canvas, null, row + 1, L, mid);
            fill(canvas, null, row + 1, mid, R);
            return;
        }

        canvas[row][mid] = String.valueOf(n.data);
        fill(canvas, n.left, row + 1, L, mid);
        fill(canvas, n.right, row + 1, mid, R);
    }

    private static int getHeight(Node n) {
        return n == null ? 0 : 1 + Math.max(getHeight(n.left), getHeight(n.right));
    }
 
}
