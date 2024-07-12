package preRequisites.slidingWindow_TwoPointers;

public class MaxConsecutiveOne3 {
    //better approach O(2N)

    class Solution {
        public int longestOnes(int[] nums, int k) {
            int l=0;
            int r=0;
            int maxLen=0;
            int cz=0;
            while(r<nums.length){
                if(nums[r]==0) cz++;

                while(cz>k){
                    if(nums[l]==0) {
                        cz--;
                    }
                    l++;
                }
                if(cz<=k) {
                    maxLen=Math.max(maxLen,r-l+1);
                }

                r=r+1;
            }
            return maxLen;
        }
    }
//optimal solution O(N)
    class Solution2 {
        public int longestOnes(int[] nums, int k) {
            int l=0;
            int r=0;
            int maxLen=0;
            int cz=0;
            while(r<nums.length){
                if(nums[r]==0) cz++;
                if(cz<=k){
                    maxLen=Math.max(maxLen,r-l+1);
                    r++;
                }
                else{
                    if(nums[l]==0) cz--;
                    l++;
                    r++;
                }
            }
            return maxLen;
        }
    }
}
