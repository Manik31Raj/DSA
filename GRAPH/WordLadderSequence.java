import java.util.*;
import java.lang.*;
import java.io.*;



class WordLadderSequence
{
	public static void main (String[] args) 
	{
	   String startWord="hit";
	   String endWord="cog";
	   Set<String> wordList=new HashSet<>(Set.of("hot","dot","dog","lot","log","cog"));
	   
	   System.out.println(wordLadderSequence(startWord,endWord,wordList));
	}
	
	public static ArrayList<ArrayList<String>> wordLadderSequence(String startWord,String endWord,Set<String> wordList){
	  
       ArrayList<ArrayList<String>> seq=new ArrayList<>();	  
	   Queue<ArrayList<String>> q=new LinkedList<>();
	   q.add(new ArrayList<>(List.of(startWord)));

	   ArrayList<String> usedOnLevel=new ArrayList<>();
	   usedOnLevel.add(startWord);
	   int level=0;
	   
	   while(!q.isEmpty()){
	        
	        ArrayList<String> arr=q.poll();
	        
	        if(arr.size()>level){
	            level++;
	            for(String str:usedOnLevel){
	                wordList.remove(str);
	            }
	        }
	        
	        String word=arr.get(arr.size()-1);
	        if(word.equals(endWord)){
	            if(seq.size()==0){
	              seq.add(arr);  
	            }else if(seq.get(0).size()==arr.size()){
	                seq.add(arr);
	            }
	        }
	        
	        for(int i=0;i<word.length();i++){
	            
	            for(char ch='a';ch<='z';ch++){
	                
	                char[] chars=word.toCharArray();
	                if(ch==chars[i])  continue;;
	                
	                chars[i]=ch;
	                String newString=new String(chars);
	                
	                if(wordList.contains(newString)){
	                    arr.add(newString);
	                    
	                    ArrayList<String> temp=new ArrayList<>(arr);
	                    q.add(temp);
	                    usedOnLevel.add(newString);
	                    arr.remove(arr.size()-1);
	                }
	            }
	        }
	   }
	  return seq;
	}
}
	
