/*
There is a row of n houses, where each house can be painted one of three colors: red, blue, or green. 
The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. 
For example, costs[0][0] is the cost of painting house 0 with the color red; costs[1][2] is the cost of painting house 1 with color green, and so on... 
Find the minimum cost to paint all houses.

 

Example 1:

Input: costs = [[17,2,17],[16,16,5],[14,3,19]]
Output: 10
Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
Minimum cost: 2 + 5 + 3 = 10.
*/

public class Solution {
  public int minCost(int[][] costs) {
      if(costs==null||costs.length==0){
          return 0;
      }
      for(int i=1; i<costs.length; i++){
          costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
          costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
          costs[i][2] += Math.min(costs[i-1][1],costs[i-1][0]);
      }
      int n = costs.length-1;
      return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
  }
}

class Solution {
    public int minCost(int[][] costs) {

        for (int n = costs.length - 2; n >= 0; n--) {
            // Total cost of painting the nth house red.
            costs[n][0] += Math.min(costs[n + 1][1], costs[n + 1][2]);
            // Total cost of painting the nth house green.
            costs[n][1] += Math.min(costs[n + 1][0], costs[n + 1][2]);
            // Total cost of painting the nth house blue.
            costs[n][2] += Math.min(costs[n + 1][0], costs[n + 1][1]);
        }

        if (costs.length == 0) return 0;   

        return Math.min(Math.min(costs[0][0], costs[0][1]), costs[0][2]);
    }
}
