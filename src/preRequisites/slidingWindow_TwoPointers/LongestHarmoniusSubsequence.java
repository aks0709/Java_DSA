package preRequisites.slidingWindow_TwoPointers;
import java.util.*;
public class LongestHarmoniusSubsequence {
    class Solution {
        public int findLHS(int[] nums) {
            Arrays.sort(nums);
            int l=0;
            int r=0;
            int maxLen=0;
            while(r<nums.length){
                while(nums[r]-nums[l]>1) l++;

                if(nums[r]-nums[l]==1)
                    maxLen=Math.max(maxLen,r-l+1);

                 r++;
            }
            return maxLen;
        }
    }
}
