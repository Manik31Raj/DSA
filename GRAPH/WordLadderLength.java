import java.util.*;
import java.lang.*;
import java.io.*;

class Pair{
    String word;
    int step;
    public Pair(String word,int step){
        this.word=word;
        this.step=step;
    }
}

class WordLadderLength
{
	public static void main (String[] args) 
	{
	   String startWord="hit";
	   String endWord="cog";
	   Set<String> wordList=new HashSet<>(Set.of("hot","dot","dog","lot","log","cog"));
	   
	   System.out.println(wordLadderLength(startWord,endWord,wordList));
	}
	
	public static int wordLadderLength(String startWord,String endWord,Set<String> wordList){
	   Queue<Pair> q=new LinkedList<>();
	   q.add(new Pair(startWord,1));

	   
	   while(!q.isEmpty()){
	        Pair p=q.poll();
	        String currWord=p.word;
	        int steps=p.step;
	        
	        if(currWord.equals(endWord)) return steps;
	        
	        for(int i=0;i<currWord.length();i++){
	            
	            for(char ch='a';ch<='z';ch++){
	                
	                char[] chars=currWord.toCharArray();
	                
	                if(ch==chars[i]) continue;
	                
	                chars[i]=ch;
	                String newString=new String(chars);
	                
	                if(wordList.contains(newString)){
	                    q.add(new Pair(newString,steps+1));
	                    wordList.remove(newString);
	                    
	                }
	            }
	        }
	    } 
	   
	  return 0;
	}
}
	
