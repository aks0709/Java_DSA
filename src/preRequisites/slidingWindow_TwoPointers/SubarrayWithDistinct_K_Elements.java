package preRequisites.slidingWindow_TwoPointers;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithDistinct_K_Elements {
    class Solution {
        //we will tackle this  question in such a way that subarrays with <=k diff integers - subarrays with <= k-1 diff integers
        public int subarraysWithKDistinct(int[] nums, int k) {
            return helper(nums,k)-helper(nums,k-1);
        }
        public static int helper(int nums[],int k){
            int l=0,r=0,count=0;
            Map<Integer,Integer> map=new HashMap<>();
            //it stores element and it's frequency
            while(r<nums.length){
                if(map.containsKey(nums[r]))
                    map.put(nums[r],map.get(nums[r])+1);
                else
                    map.put(nums[r],1);

                while(map.size()>k){
                    map.put(nums[l],map.get(nums[l])-1);

                    if(map.get(nums[l])==0)
                        map.remove(nums[l]);

                    l++;
                }
                count+=(r-l+1);
                r++;
            }
            return count;
        }
    }
}
