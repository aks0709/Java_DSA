package preRequisites.slidingWindow_TwoPointers;

public class BinarySubarrayWithSum {
    class Solution {
        public int numSubarraysWithSum(int[] nums, int goal) {
            //no of subarray with sum equal to goal=subarray with sum<= goal - subarray having sum less than equal to goal-1
            return numSubarraysWithSum2(nums,goal)-numSubarraysWithSum2(nums,goal-1);
        }
        public int numSubarraysWithSum2(int[] nums, int goal) {
            if(goal<0) return 0;  //handle edge case for goal-1 function call
            int l=0,r=0;
            int sum=0,count=0;
            while(r<nums.length){
                sum=sum+nums[r];

                //we count subaaray having sum less than equal to goal
                while(sum>goal){
                    sum=sum-nums[l];
                    l++;
                }
                count=count+(r-l+1);  //suppose window is [1,0,0] and goal is 2
                                     //so possible subarrays are [0],[0,0],[1,0,0]  i.e r-l+1
                r++;
            }
            return count;
        }
    }
}
