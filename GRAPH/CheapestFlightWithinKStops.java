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

class Price{
    int stopsCount;
    long price;
    int stop;
    public Price(int stopsCount,int stop,long price){
        this.stopsCount=stopsCount;
        this.stop=stop;
        this.price=price;
    }
}

class CheapestFlightWithinKStops
{
	public static void main (String[] args)
	{
	   int n=5;
	   int src=0;
	   int des=2;
	   int k=2;     //stops
	   ArrayList<ArrayList<WeightPair>> adj=new ArrayList<>();
	   graph(adj,n-1);
	   System.out.println("Cheapest flight cost from "+src+" to "+des +" with at most "+k+" stops -> "+cheapestFlight(adj,src,des,k));
	   

	}
	
	public static long cheapestFlight(ArrayList<ArrayList<WeightPair>> adj,int start,int end,int k){
	    
	    long[] cost=new long[adj.size()];
	    Arrays.fill(cost,Long.MAX_VALUE);
	    
	    Queue<Price> q=new LinkedList<>();
	    q.add(new Price(0,start,0));
	    cost[start]=0;
	    
	    while(!q.isEmpty()){
	        
	        Price p=q.poll();
	        long flightPrice=p.price;
	        int currStop=p.stop;
	        int currstopsCount=p.stopsCount;
	        
	        if(currstopsCount>k) continue;
	        
	        for(WeightPair w:adj.get(currStop)){
	            long currPrice=(flightPrice+w.weight);
	            
	            if(currPrice<cost[w.node] && currstopsCount<=k){
	                cost[w.node]=currPrice;
	                q.add(new Price(currstopsCount+1,w.node,currPrice));
	            }
	        }
	    }
	    
	    return cost[end]==Long.MAX_VALUE ? -1 : cost[end];
	}
	

    //focus on abov ones
	//Graph Formation
	public static void graph(ArrayList<ArrayList<WeightPair>> adj,int n){
	    
	     List<Pair> list=List.of(new Pair(0,1,500),new Pair(1,2,500),new Pair(0,3,200),new Pair(3,1,200),new Pair(1,4,100),new Pair(4,2,100));
	     
	
	     
	     for(int i=0;i<=n;i++){
	       adj.add(new ArrayList<WeightPair>());
	     }
	     
	     for(int i=0;i<list.size();i++){
	         adj.get(list.get(i).u).add(new WeightPair(list.get(i).v,list.get(i).w));
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
