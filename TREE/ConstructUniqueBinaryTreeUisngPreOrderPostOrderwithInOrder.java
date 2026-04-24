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


class ConstructUniqueBinaryTreeUisngPreOrderPostOrderwithInOrder
{
	public static void main (String[] args)
	{
	   int[] inOrder  ={40,20,50,10,60,30};
	   int[] preOrder ={10,20,40,50,30,60};
	   int[] postOrder={40,50,20,60,30,10};
	   
	   System.out.print("InOder    -> [");
	   for(int x:inOrder){
           System.out.print(x+" ");
       }
       System.out.print("] \n");
       
       System.out.print("PreOder   -> [");
	   for(int x:preOrder){
           System.out.print(x+" ");
       }
       System.out.print("] \n");
       
       System.out.print("PostOder  -> [");
	   for(int x:postOrder){
           System.out.print(x+" ");
       }
       System.out.print("] \n\n");
       
       System.out.println("Using InOrder and PostOrder Unique Binary Tree \n ");
       printTree(buildTreePostIn(inOrder,postOrder));
       System.out.println("");
       
       System.out.println("Using InOrder and PretOrder Unique Binary Tree \n");
       printTree(buildTreePreIn(preOrder,inOrder));
       
	}

  // INORDER + PREORDER
	
	public static Node buildTreePreIn(int[] preOrder,int[] inOrder){
	    Map<Integer,Integer> inMap=new HashMap<Integer,Integer>();
	    
	    for(int i=0;i<inOrder.length;i++){
	        inMap.put(inOrder[i],i);
	    }
	    
	    Node root=buildTreePreIn(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1,inMap);
	    
	    return root;
	}
	
	public static Node buildTreePreIn(int[] preOrder,int preStart,int preEnd,int[] inOrder,int inStart,int inEnd,Map<Integer,Integer> inMap){
	    
	    if(preStart>preEnd || inStart>inEnd) return null;
	    
	    Node root=new Node(preOrder[preStart]);
	    
	    int inRoot=inMap.get(root.data);
	    int numsLeft=inRoot-inStart;
	    
	    root.left=buildTreePreIn(preOrder,preStart+1,preStart+numsLeft,inOrder,inStart,inRoot-1,inMap);
	    
	    root.right=buildTreePreIn(preOrder,preStart+numsLeft+1,preEnd,inOrder,inRoot+1,inEnd,inMap);
	    
	    return root;
	}
	
	//INORDER + POSTORDER
	
	public static Node buildTreePostIn(int[] inOrder,int[] postOrder){
	    Map<Integer,Integer> inMap=new HashMap<Integer,Integer>();
	    
	    for(int i=0;i<inOrder.length;i++){
	        inMap.put(inOrder[i],i);
	    }
	    
	    Node root=buildTreePostIn(inOrder,0,inOrder.length-1,postOrder,0,postOrder.length-1,inMap);
	    
	    return root;
	}
	
	public static Node buildTreePostIn(int[] inOrder,int inStart,int inEnd,
	int[] postOrder,int postStart,int postEnd,Map<Integer,Integer> inMap){
	    
	    if(postStart>postEnd || inStart>inEnd) return null;
	    
	    Node root=new Node(postOrder[postEnd]);
	    
	    int inRoot=inMap.get(root.data);
	    int numsLeft=inRoot-inStart;
	    
	    root.left=buildTreePostIn(inOrder,inStart,inRoot-1,postOrder,postStart,postStart+numsLeft-1,inMap);
	    
	    root.right=buildTreePostIn(inOrder,inRoot+1,inEnd,postOrder,postStart+numsLeft,postEnd-1,inMap);
	    
	    return root;
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
