/*
Given a matrix of integers A with R rows and C columns, find the maximum score of a path starting at [0,0] and ending at [R-1,C-1].

The score of a path is the minimum value in that path.  For example, the value of the path 8 →  4 →  5 →  9 is 4.

A path moves some number of times from one visited cell to any neighbouring unvisited cell in one of the 4 cardinal directions (north, east, west, south).

 

Example 1:



Input: [[5,4,5],[1,2,6],[7,4,6]]
Output: 4
Explanation: 
The path with the maximum score is highlighted in yellow. 
*/

public int maximumMinimumPathBinarySearch(int[][] A) {
        int low = 0, high = Math.min(A[0][0], A[A.length - 1][A[0].length - 1]), ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            boolean[][] visited = new boolean[A.length][A[0].length];
            visited[0][0] = true;
            if (pathExistsWithMinValue(A, 0, 0, mid, visited)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean pathExistsWithMinValue(int[][] a, int row, int col, int minVal, boolean[][] visited) {
        if (row == a.length - 1 && col == a[0].length - 1) {
            return true;
        } else {
            for (int i = 0; i < 4; i++) {
                int new_row = row + x_offsets[i];
                int new_col = col + y_offsets[i];
                if (new_row >= 0 && new_row < a.length && new_col >= 0 && new_col < a[0].length && !visited[new_row][new_col] && a[new_row][new_col] >= minVal) {
                    visited[new_row][new_col] = true;
                    if (pathExistsWithMinValue(a, new_row, new_col, minVal, visited)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

int[] x_offsets = new int[]{0, 1, 0, -1};
int[] y_offsets = new int[]{1, 0, -1, 0};
