import java.util.*;
import java.lang.*;
import java.io.*;

class Pair{
    int u;
    int v;
    public Pair(int u,int v){
        this.u=u;
        this.v=v;
    }
}

class AlienDictionary
{
	public static void main (String[] args)
	{
	  String[] strArr = {
    "wrt",
    "wrf",
    "er",
    "ett",
    "rftt",
    "rfzz",
    "zg",
    "zga",
    "zgb",
    "zx"
};

int k = 26;
	   
	   char[] chMap=new char[k];
	   for(int i=0;i<k;i++){
	       chMap[i]=(char)('a'+i);
	   }
	  
	   List<Pair> list=new ArrayList<>();
	   
	   if(!makeGraph(strArr,list)){
	       System.out.println("Invalid Prefix Case");
	       return;
	   }	  
   	   ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
       graph(adj,list,k);
	   System.out.print("Alien Dictionary ->  [");
	   for(char x:AlienDictornary(adj,chMap)){
	       System.out.print(" "+x+" ");
       }
	   System.out.print("]");
	}
	
	public static boolean makeGraph(String[] strArr,List<Pair> list){
	    for (int i = 0; i < strArr.length - 1; i++) {
            String s1 = strArr[i];
            String s2 = strArr[i + 1];

            int len = Math.min(s1.length(), s2.length());
            boolean found = false;

            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    list.add(new Pair(s1.charAt(j) - 'a', s2.charAt(j) - 'a'));
                    found = true;
                    break;
                }
            }

            if (!found && s1.length() > s2.length()) {
                return false; // invalid prefix case
            }
        }
        return true;
	}
	public static char[] AlienDictornary(ArrayList<ArrayList<Integer>> adj, char[] chMap){
        int[] inDeg=new int[adj.size()];
        char[] sort=new char[adj.size()];
        int ind=0;
        
        for(int i=0;i<adj.size();i++){
	        for(int node:adj.get(i)){
	            inDeg[node]++;
	        }
	    }
	    
	    
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=0;i<inDeg.length;i++){
	        if(inDeg[i]==0){
	            q.add(i);
	        }
	    }
        
        
        while(!q.isEmpty()){
	        int node =q.poll();
	        sort[ind++]=chMap[node];
	        
	        for(int curr:adj.get(node)){
	             inDeg[curr]--;
	             if(inDeg[curr]==0){
	                q.add(curr);
	             }
	        }
	    }
	    
	    if (ind != adj.size()) {
           throw new IllegalStateException("Cycle detected, alien dictionary order not possible");
        }
	   
        return sort;
    }

    

    //focus on abov ones
	//Graph Formation
	public static void graph(ArrayList<ArrayList<Integer>> adj,List<Pair> list,int n){
	    
	     for(int i=0;i<n;i++){
	       adj.add(new ArrayList<Integer>());
	     }
	     
	     for(int i=0;i<list.size();i++){
	         adj.get(list.get(i).u).add(list.get(i).v);
	     }
	     
	    System.out.println("List Representation");
	    for(int i=0;i<adj.size();i++){
	        System.out.println(i + " : " + adj.get(i));
	    }
	  
	}
}
