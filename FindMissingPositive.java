/*
Given an unsorted integer array nums, find the smallest missing positive integer.

 

Example 1:

Input: nums = [1,2,0]
Output: 3
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1

*/

class Solution {
  public int firstMissingPositive(int[] nums) {
    int n = nums.length;

    // Base case.
    int contains = 0;
    for (int i = 0; i < n; i++)
      if (nums[i] == 1) {
        contains++;
        break;
      }

    if (contains == 0)
      return 1;

    // nums = [1]
    if (n == 1)
      return 2;

    // Replace negative numbers, zeros,
    // and numbers larger than n by 1s.
    // After this convertion nums will contain 
    // only positive numbers.
    for (int i = 0; i < n; i++)
      if ((nums[i] <= 0) || (nums[i] > n))
        nums[i] = 1;

    // Use index as a hash key and number sign as a presence detector.
    // For example, if nums[1] is negative that means that number `1`
    // is present in the array. 
    // If nums[2] is positive - number 2 is missing.
    for (int i = 0; i < n; i++) {
      int a = Math.abs(nums[i]);
      // If you meet number a in the array - change the sign of a-th element.
      // Be careful with duplicates : do it only once.
      if (a == n)
        nums[0] = - Math.abs(nums[0]);
      else
        nums[a] = - Math.abs(nums[a]);
    }

    // Now the index of the first positive number 
    // is equal to first missing positive.
    for (int i = 1; i < n; i++) {
      if (nums[i] > 0)
        return i;
    }

    if (nums[0] > 0)
      return n;

    return n + 1;
  }
}
