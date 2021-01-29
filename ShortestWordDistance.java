/*
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
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
		String a[] = new String[]{ "practice", "makes", "perfect", "coding", "makes"}; 
		System.out.println("shortestDistance : " + shortestDistance(a,"coding","practice"));
	}
	
	static public int shortestDistance(String[] words, String word1, String word2) {
	    int p1 = -1, p2 = -1, min = Integer.MAX_VALUE;
	    
	    for (int i = 0; i < words.length; i++) {
	        if (words[i].equals(word1)) 
	            p1 = i;
	
	        if (words[i].equals(word2)) 
	            p2 = i;
	            
	        if (p1 != -1 && p2 != -1)
	            min = Math.min(min, Math.abs(p1 - p2));
	    }
	    
	    return min;
	}
}
