import java.util.*;
import java.lang.*;
import java.io.*;


class DisjointSet{
    List<Integer> rank=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    
    public DisjointSet(int n){
        for(int i=0;i<n;i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    
    public int findUltimateParent(int node){
        
        if(node==parent.get(node)){
            return node;
        }
        
        int ultParent=findUltimateParent(parent.get(node));
        parent.set(node,ultParent);
        return parent.get(node);
    }
    
    public void unionBySize(int u,int v){
        
        int ultParent_u=findUltimateParent(u);
        int ultParent_v=findUltimateParent(v);
        
        if(ultParent_u == ultParent_v) return;
        
        if(size.get(ultParent_u) < size.get(ultParent_v)){
            parent.set(ultParent_u,ultParent_v);
            size.set(ultParent_v,size.get(ultParent_u)+size.get(ultParent_v));
        }else{
            parent.set(ultParent_v,ultParent_u);
            size.set(ultParent_u,size.get(ultParent_u)+size.get(ultParent_v));
        }
    }
}

class AccountMerge
{
	public static void main (String[] args)
	{
	     List<List<String>> details = Arrays.asList(
            Arrays.asList("Alexa", "a1@com", "a4@com", "a2@com"),
            Arrays.asList("Alexa", "a5@com"),
            Arrays.asList("Raj", "r1@com", "r4@com"),
            Arrays.asList("Alexa", "a1@com", "a3@com"),
            Arrays.asList("Raj", "r4@com", "r2@com"),
            Arrays.asList("Mohan", "m1@com", "m2@com")
        );
        
        List<List<String>> newDetails=new ArrayList<>();
        
        System.out.println(" New Details   -> "+accountMerge(details,newDetails));
	}
	public static List<List<String>> accountMerge(List<List<String>> details,List<List<String>> newDetails){
	    
	    DisjointSet ds=new DisjointSet(details.size());
	    HashMap<String,Integer> mapMailNode=new HashMap<>();
	    
	    for(int i=0;i<details.size();i++){
	        for(int j=1;j<details.get(i).size();j++){
	            String email=details.get(i).get(j);
	            
	            if(!mapMailNode.containsKey(email)){
	                mapMailNode.put(email,i);
	            }else{
	                ds.unionBySize(i,mapMailNode.get(email));
	            }
	        }
	    }
	    
	    ArrayList<String>[] mergedEmail=new ArrayList[details.size()];
	    for(int i=0;i<details.size();i++){
	        mergedEmail[i]=new ArrayList<String>();
	    }
	    
	    for(Map.Entry<String,Integer> it:mapMailNode.entrySet()){
	        String mail=it.getKey();
	        int node=ds.findUltimateParent(it.getValue());
	        mergedEmail[node].add(mail);
	    }
	    
	    for(int i=0;i<details.size();i++){
	        if(mergedEmail[i].size()==0) continue;
	        
	        Collections.sort(mergedEmail[i]);
	        List<String> temp=new ArrayList<>();
	        temp.add(details.get(i).get(0));
	        for(String it:mergedEmail[i]){
	            temp.add(it);
	        }
	        newDetails.add(temp);
	    }
	    
	    return newDetails;
	}

}
