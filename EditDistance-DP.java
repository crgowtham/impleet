/*
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
*/

class Solution {
    public int minDistance(String word1, String word2) {
		int M = word1.length();
		int N = word2.length();
		int dp[][] = new int[M + 1][N + 1];
		if (M * N == 0)
			return M + N;

		for (int i = 0; i <= M; i++) {
			dp[i][0] = i;
		}
		for (int i = 0; i <= N; i++) {
			dp[0][i] = i;
		}

		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
				}
			}
		}
		return dp[M][N];

	}
}
