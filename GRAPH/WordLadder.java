import java.util.*;
import java.lang.*;
import java.io.*;



class WordLadder
{
    static String b;
    static Map<String,Integer> map;
    static ArrayList<ArrayList<String>> ans;
    
	public static void main (String[] args) 
	{
	   String startWord="hit";
	   String endWord="cog";
	   Set<String> wordList=new HashSet<>(Set.of("hot","dot","dog","lot","log","cog"));
	   
	   System.out.println(wordLadderSequence(startWord,endWord,wordList));
	}
	
	public static ArrayList<ArrayList<String>> wordLadderSequence(String startWord,String endWord,Set<String> wordList){
	  
	   Queue<String> q=new LinkedList<>();
	   b=startWord;
	   q.add(startWord);
	   map=new HashMap<>();
	   map.put(startWord,1);
	   
	   int size=startWord.length();
	   if(wordList.contains(startWord)) wordList.remove(startWord);

	   ArrayList<String> usedOnLevel=new ArrayList<>();
	   usedOnLevel.add(startWord);
	   int level=0;
	   
	   while(!q.isEmpty()){
	        
	        String word=q.poll();
	        int steps=map.get(word);
	        
	        if(word.equals(endWord)) break;
	        
	        for(int i=0;i<size;i++){
	            for(char ch='a';ch<='z';ch++){
	                
	                char[] chars=word.toCharArray();
	                if(chars[i]==ch) continue;
	                
	                chars[i]=ch;
	                String newString=new String(chars);
	                if(wordList.contains(newString)){
	                    q.add(newString);
	                    wordList.remove(newString);
	                    map.put(newString,steps+1);
	                }
	            }
	        }
	   }
	   
	  ans=new ArrayList<>();
	  if(map.containsKey(endWord)){
	      ArrayList<String> seq=new ArrayList<>();
	      seq.add(endWord);
	      dfs(endWord,seq);
	  }
	  
	  return ans;
	}
	
	private static void dfs(String word,ArrayList<String> seq){
	    
	    if(word.equals(b)){
	        ArrayList<String> dup=new ArrayList<>(seq);
	        Collections.reverse(dup);
	        ans.add(dup);
	        return;
	    }
	    
	    int steps=map.get(word);
	    int sz=word.length();
	    
	    for(int i=0;i<sz;i++){
	        for(char ch='a';ch<='z';ch++){
	            char[] chars=word.toCharArray();
	            if(chars[i]==ch) continue;
	            
	            chars[i]=ch;
	            String newString=new String(chars);
	            if(map.containsKey(newString) && map.get(newString)+1==steps){
	                seq.add(newString);
	                dfs(newString,seq);
	                seq.remove(seq.size()-1);
	            }
	        }
	    }
	}
}
	
