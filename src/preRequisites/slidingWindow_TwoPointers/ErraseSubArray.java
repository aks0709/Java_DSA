package preRequisites.slidingWindow_TwoPointers;

import java.util.HashSet;
import java.util.*;

@SuppressWarnings("all")  // Suppresses all compiler warnings
public class ErraseSubArray {

    @SuppressWarnings("all")
    class Solution {
        public int maximumUniqueSubarray(int[] nums) {
            int l = 0, r = 0;
            Set<Integer> set = new HashSet<>();
            int sum = 0, maxSum = 0;

            while (r < nums.length) {
                if (!set.contains(nums[r])) {
                    set.add(nums[r]);
                    sum += nums[r];
                    maxSum = Math.max(maxSum, sum);
                    r++;
                } else {
                    set.remove(nums[l]);
                    sum -= nums[l];
                    l++;
                }
            }

            return maxSum;
        }
    }
}

