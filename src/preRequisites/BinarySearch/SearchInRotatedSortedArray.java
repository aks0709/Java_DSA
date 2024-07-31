package preRequisites.BinarySearch;

public class SearchInRotatedSortedArray {
    class Solution {
        //   the main key of binary search is array must be sorted
//   First, we identify the sorted half of the array.
// Once found, we determine if the target is located within this sorted half.
// If not, we eliminate that half from further consideration.
// Conversely, if the target does exist in the sorted half, we eliminate the other half.
        public int search(int[] nums, int target) {
            int low=0;
            int high=nums.length-1;
            while(low<=high){
                int mid=low+(high-low)/2;
                if(nums[mid]==target)  return mid;

                //if left part is sorted
                if(nums[low]<=nums[mid])  //check for sorted array
                {
                    if(nums[low]<=target && target<=nums[mid])
                        high=mid-1;
                    else
                        low=mid+1;
                }

                //if right part is sorted
                if(nums[mid]<=nums[high]){
                    if(nums[mid]<=target && target<=nums[high])
                        low=mid+1;
                    else
                        high=mid-1;
                }

            }
            return -1;
        }
    }
}
