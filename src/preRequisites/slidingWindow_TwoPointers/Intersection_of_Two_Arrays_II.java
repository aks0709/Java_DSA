package preRequisites.slidingWindow_TwoPointers;
import java.util.*;
/*
Given two integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must appear as many times as it shows in both arrays and
you may return the result in any order.
Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
*/
public class Intersection_of_Two_Arrays_II {
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            int l1 = nums1.length;
            int l2 = nums2.length;
            int i = 0, j = 0, k = 0;
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            while( i < l1 && j < l2)
            {
                if(nums1[i] < nums2[j])
                {
                    i++;
                }
                else if(nums1[i] > nums2[j])
                {
                    j++;
                }
                else
                {
                    nums1[k++] = nums1[i++];
                    j++;
                }
            }
            return Arrays.copyOfRange(nums1,0,k);
        }
    }
}
