import java.util.*;
import java.lang.*;
import java.io.*;

class Pair{
    int u;
    int v;
    int w;
    public Pair(int u,int v,int w){
        this.u=u;
        this.v=v;
        this.w=w;
    }
}

class WeightPair{
    int node;
    int weight;
    public WeightPair(int node,int weight){
        this.node=node;
        this.weight=weight;
    }
}


class Distance{
    long distance;
    int node;
    public Distance(long distance,int node){
        this.distance=distance;
        this.node=node;
    }
}

class NumberOfWaysToArriveAtDestination
{   final static int mod=(int)(1e9 + 7 );
	public static void main (String[] args)
	{
	   int n=9;
	   int src=0;
	   int end=8;
	   ArrayList<ArrayList<WeightPair>> adj=new ArrayList<>();
	   graph(adj,n-1);
	   System.out.println("Number Of ways to arrive at destination -> "+noOfWaysToArriveAtDst(adj,src,end));
	  

	}
	
	public static int noOfWaysToArriveAtDst(ArrayList<ArrayList<WeightPair>> adj,int srt,int dst){
	    
	    int n=adj.size();
	    int[] ways=new int[n];
	    
	    long[] dist=new long[n];
	    Arrays.fill(dist,Long.MAX_VALUE);
	    
	    PriorityQueue<Distance> pq = new PriorityQueue<>((a, b) -> {
            int compareDistance = Long.compare(a.distance, b.distance);
            if (compareDistance == 0) {
                return Integer.compare(a.node, b.node);
            }
            return compareDistance;
        });
        
        pq.add(new Distance(0,srt));
        ways[srt]=1;
        dist[srt]=0;
        
        while(!pq.isEmpty()){
            Distance dis=pq.poll();
            long d=dis.distance;
            int curr=dis.node;
            
            if(d > dist[curr]) continue;
            
            for(WeightPair w:adj.get(curr)){
                int currNode=w.node;
                int wei=w.weight;
                long newDist=d+wei;
                
                if(newDist < dist[currNode]){
                    dist[currNode]=newDist;
                    ways[currNode]=ways[curr];
                    pq.add(new Distance(newDist,currNode));
                }else if(newDist == dist[currNode]){
                    ways[currNode]=(ways[currNode]+ways[curr])%mod;
                }
            }
        }
        return ways[dst];
	}
	


    //focus on abov ones
	//Graph Formation
	public static void graph(ArrayList<ArrayList<WeightPair>> adj,int n){
	    
	     List<Pair> list=List.of(new Pair(0,1,1),new Pair(0,2,2),new Pair(0,3,1),new Pair(0,4,2),new Pair(1,5,2),new Pair(2,5,1),new Pair(3,5,2),new Pair(3,7,3),new Pair(3,6,2),new Pair(4,6,1),new Pair(5,8,1),new Pair(7,8,1),new Pair(6,8,1));
	     
	     for(int i=0;i<=n;i++){
	       adj.add(new ArrayList<WeightPair>());
	     }
	     
	     for(int i=0;i<list.size();i++){
	         adj.get(list.get(i).u).add(new WeightPair(list.get(i).v,list.get(i).w));
	         adj.get(list.get(i).v).add(new WeightPair(list.get(i).u,list.get(i).w));
	     }
	     
	    System.out.println("List Representation");
	    for(int i=0;i<adj.size();i++){
	        System.out.print(i + " : ");
	        for(WeightPair p:adj.get(i)){
	            System.out.print("{"+p.node+","+p.weight+"}");
	        }
	        System.out.println("");
	    }
	  
	}
}
