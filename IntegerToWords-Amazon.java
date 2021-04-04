/*
Convert a non-negative integer num to its English words representation.

 

Example 1:

Input: num = 123
Output: "One Hundred Twenty Three"
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
		//String a[] = new String[]{ "practice", "makes", "perfect", "coding", "makes"}; 
		System.out.println("numberToWords : " + numberToWords(1123));
	}
	
	static private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	static private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	static private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
	
	static public String numberToWords(int num) {
	    if (num == 0) return "Zero";
	
	    int i = 0;
	    String words = "";
	    
	    while (num > 0) {
	        if (num % 1000 != 0)
	    	    words = helper(num % 1000) +THOUSANDS[i] + " " + words;
	    	num /= 1000;
	    	i++;
	    }
	    
	    return words.trim();
	}
	
	static private String helper(int num) {
	    if (num == 0)
	        return "";
	    else if (num < 20)
	        return LESS_THAN_20[num] + " ";
	    else if (num < 100)
	        return TENS[num / 10] + " " + helper(num % 10);
	    else
	        return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
	}
}
