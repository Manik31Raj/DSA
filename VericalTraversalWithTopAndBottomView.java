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

class Tuple{
    Node node;
    int row; //vertical x axis
    int col; //level
    public Tuple(Node node,int row,int col){
        this.node=node;
        this.row=row;
        this.col=col;
    }
}

class VericalTraversalWithTopAndBottomView         
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Node root=new Node(1);
		root.left=new Node(2);
	    root.right=new Node(3);
	    root.left.left=new Node(4);
	    root.left.right=new Node(5);
	    root.right.left=new Node(6);
	    root.right.right=new Node(7);
	    
	    System.out.println("vertcalTraversal -> "+printVerticalTraversal(root));
	    
	    System.out.println("Top-View         -> "+printTopView(root));
	    
	    System.out.println("BOttom-View      -> "+printBottomView(root));
	    
	}
	
	public static TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> vertcalTraversal(Node root){
	    
	    TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
	    //Used pQueue as if 2 or more nodes at same position keeps it sorted 
	    
	    Queue<Tuple> q=new LinkedList<Tuple>();
	    
	    q.offer(new Tuple(root,0,0));//push root element with x-axis-> 0 and  level -> 0
	    
	    while(!q.isEmpty()){
	        Tuple t=q.poll();
	        Node node=t.node;
	        int x=t.row;
	        int y=t.col;
	        
	        // if x-cordinate map contins leave other wise crate a map with the point
	        if(!map.containsKey(x)){
	            map.put(x,new TreeMap<>());
	        }
	        
	        // if level is present in map leave othr wise create a map with the leevel
	        if(!map.get(x).containsKey(y)){
	            map.get(x).put(y,new PriorityQueue<>());
	        }
	        
	        map.get(x).get(y).offer(node.data);  // adds node int queue
	        
	        //every left  x -> x-1 and level -> y+1
	        if(node.left!=null){
	            q.offer(new Tuple(node.left,x-1,y+1));
	        }
	        
	        //every right x -> x+1 and level -> y+1
	        if(node.right!=null){
	            q.offer(new Tuple(node.right,x+1,y+1));
	        }
	    }
	    return map;
	        
	}
	
	
	public static List<List<Integer>> printVerticalTraversal(Node root){
	    
	        
	        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=vertcalTraversal(root);
	        
	       	List<List<Integer>> list=new ArrayList<>();
	        for(TreeMap<Integer,PriorityQueue<Integer>> ys:map.values()){
	            list.add(new ArrayList<>());
	            for(PriorityQueue<Integer> nodes:ys.values()){
	                while(!nodes.isEmpty()){
	                    System.out.println(nodes.peek());
	                    list.get(list.size()-1).add(nodes.poll());
	                }
	            }
	        }
	        return list;
	}
	
	//print all first element of pQueue from vertical travrsal
	public static List<Integer> printTopView(Node root){
    
    Map<Integer,Integer> map = new TreeMap<>();
    Queue<Tuple> q = new LinkedList<>();
    
    q.offer(new Tuple(root,0,0));
    
    while(!q.isEmpty()){
        Tuple t = q.poll();
        
        // first time we see this vertical
        if(!map.containsKey(t.row)){
            map.put(t.row, t.node.data);
        }
        
        if(t.node.left != null){
            q.offer(new Tuple(t.node.left, t.row-1, t.col+1));
        }
        
        if(t.node.right != null){
            q.offer(new Tuple(t.node.right, t.row+1, t.col+1));
        }
    }
    
    return new ArrayList<>(map.values());
}
	
	//print all last element of pQueue from vertical travrsal
public static List<Integer> printBottomView(Node root){
    
    Map<Integer,Integer> map = new TreeMap<>();
    Queue<Tuple> q = new LinkedList<>();
    
    q.offer(new Tuple(root,0,0));
    
    while(!q.isEmpty()){
        Tuple t = q.poll();
        
        // overwrite every time → last seen = bottom
        map.put(t.row, t.node.data);
        
        if(t.node.left != null){
            q.offer(new Tuple(t.node.left, t.row-1, t.col+1));
        }
        
        if(t.node.right != null){
            q.offer(new Tuple(t.node.right, t.row+1, t.col+1));
        }
    }
    
    return new ArrayList<>(map.values());
 }  
}	
