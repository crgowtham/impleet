/*
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.

Example 1:
11000
11000
00011
00011
*/

public int numDistinctIslands(int[][] grid) {
    Set<String> set = new HashSet<>();
    for(int i = 0; i < grid.length; i++) {
        for(int j = 0; j < grid[i].length; j++) {
            if(grid[i][j] != 0) {
                StringBuilder sb = new StringBuilder();
                dfs(grid, i, j, sb, "o"); // origin
                grid[i][j] = 0;
                set.add(sb.toString());
            }
        }
    }
    return set.size();
}
private void dfs(int[][] grid, int i, int j, StringBuilder sb, String dir) {
    if(i < 0 || i == grid.length || j < 0 || j == grid[i].length 
       || grid[i][j] == 0) return;
    sb.append(dir);
    grid[i][j] = 0;
    dfs(grid, i-1, j, sb, "u");
    dfs(grid, i+1, j, sb, "d");
    dfs(grid, i, j-1, sb, "l");
    dfs(grid, i, j+1, sb, "r");
    sb.append("b"); // back
}
