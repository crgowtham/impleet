/*
Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
 

Example 1:

Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]

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
		 String[] strArray = new String[]{ "This", "is", "an", "example", "of", "text", "justification."}; 
		 
		 List<String> op = fullJustify(strArray, 16);
		 for(String ele : op) {
			System.out.println(ele);
		 }
	}
    
    static public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (words == null) return res;
        // l, r are the boundary of the window that constitutes one line
		int l = 0, r = 0;
        while (l < words.length) {
            int len = 0;
            while (r < words.length && len + words[r].length() + 1 <= maxWidth + 1) len += words[r++].length() + 1;
            int space = 1, extra = 0;
            if (r != words.length && r != l + 1) {
                space = (maxWidth - len + 1) / (r - l - 1) + 1;
                extra = (maxWidth - len + 1) % (r - l - 1);
            }
            StringBuilder sb = new StringBuilder(words[l++]);
            while (l < r) {
                for (int i = 0; i < space; i++) sb.append(' ');
                if (extra-- > 0) sb.append(' ');
                sb.append(words[l++]);
            }
            int remaining = maxWidth - sb.length();
            while (remaining-- > 0) sb.append(' ');
            res.add(sb.toString());
        }
        return res;
    }
}
