/*
Given an array of integers numbers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

Return the indices of the two numbers (1-indexed) as an integer array answer of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.

You may assume that each input would have exactly one solution and you may not use the same element twice.

 

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]

*/

class 2sum2 {
    public int[] twoSum(int[] numbers, int target) {
        int lo = 0, hi = numbers.length - 1;
        while (lo < hi) {
            int curSum = numbers[lo] + numbers[hi];
            if (curSum == target) {
                return new int[]{lo + 1, hi + 1};
            } else if (curSum > target) {
                hi--;
            } else {
                lo++;
            }
        }
        return new int[]{-1, -1};
    }
}
