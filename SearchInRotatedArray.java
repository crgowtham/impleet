/*
You are given an integer array nums sorted in ascending order (with distinct values), and an integer target.

Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

If target is found in the array return its index, otherwise, return -1.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
*/

public class Solution {
  public int search(int[] nums, int target) {
      int start = 0, end = nums.length - 1;
      while (start < end) {
          int mid = (start + end) / 2;
          if (nums[mid] > nums[end]) {  // eg. 3,4,5,6,1,2
              if (target > nums[mid] || target <= nums[end]) {
                  start = mid + 1;
              } else {
                  end = mid;
              }
          } else {  // eg. 5,6,1,2,3,4
              if (target > nums[mid] && target <= nums[end]) {
                  start = mid + 1;
              } else {
                  end = mid;
              }
          }
      }
      if (start == end && target != nums[start]) return -1;
      return start;
  }
}
