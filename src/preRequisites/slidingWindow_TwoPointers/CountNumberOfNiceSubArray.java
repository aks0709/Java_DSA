package preRequisites.slidingWindow_TwoPointers;

public class CountNumberOfNiceSubArray {
    //similar to binary subarray question
    /* even = 0 odd = 1  (k odd number) => (sum =k)*/
    class Solution {
        public int numberOfSubarrays(int[] nums, int k) {
            int arr[]=new int[nums.length];
            for(int i=0;i<nums.length;i++)
            {
                if(nums[i]%2==0)
                    arr[i]=0;
                else
                    arr[i]=1;
            }
            return helper(arr,k)-helper(arr,k-1);
        }
        public int helper(int[] nums, int k){
            int l=0,r=0,count=0,sum=0;
            while(r<nums.length){
                sum=sum+nums[r];
                while(sum>k){
                    sum=sum-nums[l];
                    l++;
                }
                count+=(r-l+1);
                r++;
            }
            return count;
        }

    }
}
