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
class InsertNodeInBST
{
	public static void main (String[] args)
	{
	    Node root=new Node(4);
	    root.left=new Node(2);
	    root.right=new Node(7);
	    root.left.left=new Node(1);
	    root.left.right=new Node(3);
	    
	    printTree(root);
	    System.out.println("\n");
	    Node newRoot=InsertNode(root,10);
	    printTree(newRoot);
	    
	}
	
	//Using Recursion Method
	public static Node InsertNodeRecusion(Node root,int value){
	    if(root==null) return new Node(value);
	    
	    if(root.data<value){
	        root.right=InsertNodeRecusion(root.right,value);
	    }
	    else if(root.data>value){
	        root.left=InsertNodeRecusion(root.left,value);
	    }
	    
	    return root;
	}
	
	//Using Gneral Method
	public static Node InsertNode(Node root,int value){
	    if(root==null) return new Node(value);
	    
	    Node curr=root;
	    
	    while(true){
	        if(curr.data<=value){
	            if(curr.right!=null){
	              curr=curr.right;  
	            } else{
	                curr.right=new Node(value);
	                break;
	            }
	        }else {
	            if(curr.left!=null){
	                curr=curr.left;
	            }else{
	                curr.left=new Node(value);
	                break;
	            }
	        }
	    }
	    
	    return root;
	}
	
	


  //manik code above 
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
