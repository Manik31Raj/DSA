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


class SerializeAndDeSerializeTree
{
	public static void main (String[] args)
	{
	   Node root=new Node(1);
	   root.left=new Node(2);
	   root.right=new Node(13);
	   root.right.left=new Node(4);
	   root.right.right=new Node(5);
	   
	   System.out.println("Actual Tree\n");
	   printTree(root);
	   System.out.println("");
	   
	   System.out.println("Serialize Value -> "+serialize(root));
	   
	   System.out.println("");
	   
	   System.out.println("Deserialize back to Tree");
	   printTree(deserialize(serialize(root)));
       
	}
	
	public static String serialize(Node root){
	    StringBuilder str = new StringBuilder();
	    Queue<Node> q=new LinkedList<>();
	    q.offer(root);
	    
	    while(!q.isEmpty()){
	        int size=q.size();
	        for(int i=0;i<size;i++){
	            Node node=q.poll();
	            if(node==null){
	                str.append("#,");
	            }else{
	                str.append(Integer.toString(node.data)).append(",");
	                q.offer(node.left);
	                q.offer(node.right);
	            }
	        }
	    }
	    
	    
	    return str.toString();
	    
	}
	
	public static Node deserialize(String str){
	    if(str=="" || str.length()==0) return null;
	    
	    Queue<Node> q=new LinkedList<>();
	    String[] values=str.split(",");
	    
	    Node root=new Node(Integer.parseInt(values[0]));
	    q.offer(root);
	    
	    for(int i=1;i<values.length;i++){
	        Node parent=q.poll();
	        if(!values[i].equals("#")){
	            Node left=new Node(Integer.parseInt(values[i]));
	            parent.left=left;
	            q.offer(left);
	        }
	        
	        if(!values[++i].equals("#")){
	            Node right=new Node(Integer.parseInt(values[i]));
	            parent.right=right;
	            q.offer(right);
	        }
	    }
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
