package DyanamicProgramming.DP_ON_LIS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LIS_UsingBinarySearch {
    class Solution {
        //must refer lecture

        //only return length of LIS
        public int lengthOfLIS(int[] nums) {
            return longestIncreasingSubsequence(nums,nums.length);
        }
        static int longestIncreasingSubsequence(int[] arr, int n) {
            List<Integer> temp = new ArrayList<>();
            temp.add(arr[0]);

            int len = 1;

            for (int i = 1; i < n; i++) {
                if (arr[i] > temp.get(temp.size() - 1)) {
                    // arr[i] > the last element of temp array

                    temp.add(arr[i]);
                    len++;
                } else {
                    // Replacement step
                    int ind = Collections.binarySearch(temp, arr[i]);

                    if (ind < 0) {
                        ind = -ind - 1;
                    }

                    temp.set(ind, arr[i]);
                }
            }

            return len;
        }
    }
}
