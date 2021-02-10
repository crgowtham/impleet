/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

Follow up: Could you write an algorithm with O(log n) runtime complexity?

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
*/

public int[] searchRange(int[] nums, int target) {
    return helper(nums, target, 0, nums.length - 1);
}
private int[] helper(int[] nums, int target, int lo, int hi) {
    if (nums[lo] == target && nums[hi] == target) return new int[]{lo, hi};
    if (nums[lo] <= target && nums[hi] >= target) {
        int mid = lo + (hi - lo) / 2;
        int[] left = helper(nums, target, lo, mid);
        int[] right = helper(nums, target, mid + 1, hi);
        if (left[0] == -1) return right;
        if (right[0] == -1) return left;
        return new int[]{left[0], right[1]};
    }
    return new int[]{-1, -1};
}

public class Solution {
  public int[] searchRange(int[] nums, int target) {
      int[] result = new int[2];
      result[0] = findFirst(nums, target);
      result[1] = findLast(nums, target);
      return result;
  }

  private int findFirst(int[] nums, int target){
      int idx = -1;
      int start = 0;
      int end = nums.length - 1;
      while(start <= end){
          int mid = (start + end) / 2;
          if(nums[mid] >= target){
              end = mid - 1;
          }else{
              start = mid + 1;
          }
          if(nums[mid] == target) idx = mid;
      }
      return idx;
  }

  private int findLast(int[] nums, int target){
      int idx = -1;
      int start = 0;
      int end = nums.length - 1;
      while(start <= end){
          int mid = (start + end) / 2;
          if(nums[mid] <= target){
              start = mid + 1;
          }else{
              end = mid - 1;
          }
          if(nums[mid] == target) idx = mid;
      }
      return idx;
  }
}
