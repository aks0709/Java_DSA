package preRequisites.BinarySearch;

public class SearchInDuplicatedRotatedSorted {
    class Solution {
        public boolean search(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (nums[mid] == target) {
                    return true;
                }

                // Handle duplicates: increment low and decrement high
                if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                    low++;
                    high--;
                    continue;
                }

                // Check if the left half is sorted
                if (nums[low] <= nums[mid]) {
                    if (nums[low] <= target && target < nums[mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                // Otherwise, the right half must be sorted
                else {
                    if (nums[mid] < target && target <= nums[high]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }

            return false;
        }
    }

}
