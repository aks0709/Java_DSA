package preRequisites.Arrays;

import java.util.HashMap;
import java.util.Map;
  //if question ask you to yes or no then use two pointer approach
/*sort the array
take l=0,r=n-1  if (arr[l]+arr[r]<target) l++ else if (  >  ) r++ else return true;}
this whole runs while l<r*/
public class TwoSum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            // Create a hashmap to store the numbers and their indices
            Map<Integer, Integer> map = new HashMap<>();
            // Iterate through the array
            for (int i = 0; i < nums.length; i++) {
                // Calculate the complement
                int complement = target - nums[i];
                // Check if the complement is in the map
                if (map.containsKey(complement)) {
                    // Return the indices of the two numbers
                    return new int[]{map.get(complement), i};
                }
                // Add the number and its index to the map
                map.put(nums[i], i);
            }
            // Return -1, -1 if no solution is found
            return new int[]{-1, -1};
        }
    }

}
