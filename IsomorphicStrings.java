/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"
Output: true

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
		System.out.println("isIsomorphic: " + isIsomorphic("abb", "caa"));
	}
	
	class Solution {
	public:
	    bool isIsomorphic(string s, string t) {
		int len = s.length();
		int m1[256], m2[256];
		for (int i = 0; i < 256; i++) {
		    m1[i] = m2[i] = -1;
		}

		for (int i = 0; i < len; i++) {
		    if (m1[s[i]] != m2[t[i]]) return false;
		    m1[s[i]] = m2[t[i]] = i;
		}
		return true;
	    }
	};
	
	static public boolean isIsomorphic(String s1, String s2) {
        int[] m = new int[512];
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
        }
        return true;
    }
}
