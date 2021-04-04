/*
Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
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
		char[][] multi = new char[][]{
		  {'1','1','1','1','0'},
		  {'1','1','0','1','0'},
		  {'1','1','0','0','0'},
		  {'0','0','0','0','0'}
		};
		
		System.out.println("No of Islands: " + numIslands(multi));
	}
	
	static public int n;
	static public int m;
	
	static public int numIslands(char[][] grid) {
	    int count = 0;
	    n = grid.length;
	    if (n == 0) return 0;
	    m = grid[0].length;
	    for (int i = 0; i < n; i++){
	        for (int j = 0; j < m; j++)
	            if (grid[i][j] == '1') {
	                DFSMarking(grid, i, j);
	                ++count;
	            }
	    }    
	    return count;
	}
	
	static public void DFSMarking(char[][] grid, int i, int j) {
	    if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
	    grid[i][j] = '0';
	    DFSMarking(grid, i + 1, j);
	    DFSMarking(grid, i - 1, j);
	    DFSMarking(grid, i, j + 1);
	    DFSMarking(grid, i, j - 1);
	}
}
