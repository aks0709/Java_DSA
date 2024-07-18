package preRequisites.slidingWindow_TwoPointers;

import java.util.Arrays;

public class TwoSum {

    class Solution {
        public boolean twoSum(int[] nums, int target) {
            // Sort the array
            Arrays.sort(nums);

            int l = 0;
            int r = nums.length - 1;

            // Use two pointers to find the two numbers
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum < target) {
                    l++;
                } else if (sum > target) {
                    r--;
                } else {
                    return true;
                }
            }
            return false;
        }
    }

}
