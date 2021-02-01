/*
You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.

 

Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
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
		// your code goes here
		int[] flowerbed = new int[] {1,0,0,0,1};
		System.out.println("canPlaceFlowers: " + canPlaceFlowers(flowerbed, 1));
	}
	
	static public boolean canPlaceFlowers(int[] flowerbed, int n) {
	    int count = 1;
	    int result = 0;
	    for(int i=0; i<flowerbed.length; i++) {
	        if(flowerbed[i] == 0) {
	            count++;
	        }else {
	            result += (count-1)/2;
	            count = 0;
	        }
	    }
	    if(count != 0) result += count/2;
	    return result>=n;
	}
}
