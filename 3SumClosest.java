/*
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

*/

public int threeSumClosest(int[] nums, int target) {
    int diff = Integer.MAX_VALUE, sz = nums.length;
    Arrays.sort(nums);
    for (int i = 0; i < sz && diff != 0; ++i) {
        int lo = i + 1, hi = sz - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (Math.abs(target - sum) < Math.abs(diff))
                diff = target - sum;
            if (sum < target)
                ++lo;
            else
                --hi;
        }
    }
    return target - diff;
}
