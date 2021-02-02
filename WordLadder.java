/*
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words such that:

The first word in the sequence is beginWord.
The last word in the sequence is endWord.
Only one letter is different between each adjacent pair of words in the sequence.
Every word in the sequence is in wordList.
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog" with 5 words.

*/

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		List<String> wordList = new ArrayList();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		int l = ladderLength("hit", "cog", wordList);
		System.out.println("ladder Length : " +  l);

	}
	
	static public int ladderLength(String beginWord, String endWord, List wordList) {

	    Set<String> reached = new HashSet<String>();
	    
	    Set<String> wordDict = new HashSet<String>(wordList);
	    
	    if(!wordDict.contains(endWord)){
	        return 0;
	    }
	    reached.add(beginWord);
	  //  wordDict.add(endWord);
	    
	    int distance = 1;
	    
	    while (!reached.contains(endWord)) {
	        Set<String> toAdd = new HashSet<String>();
	        for (String each : reached) {
	            for (int i = 0; i < each.length(); i++) {
	                char[] chars = each.toCharArray();
	                for (char ch = 'a'; ch <= 'z'; ch++) {
	                    chars[i] = ch;
	                    String word = new String(chars);
	                    if (wordDict.contains(word)) {
	                        toAdd.add(word);
	                        wordDict.remove(word);
	                    }
	                }
	            }
	        }
	        distance++;
	        if (toAdd.size() == 0) return 0;
	        reached = toAdd;
	    }
	    return distance;
	    
	}
}
