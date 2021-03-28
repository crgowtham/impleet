/*
Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

 

Example 1:

Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
Example 2:

Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.
*/

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first_num = Integer.MAX_VALUE;
        int second_num = Integer.MAX_VALUE;
        for (int n: nums) {
            if (n <= first_num) {
                first_num = n;
            } else if (n <= second_num) {
                second_num = n;
            } else {
                return true;
            }
        }
        return false;
    }
} 
