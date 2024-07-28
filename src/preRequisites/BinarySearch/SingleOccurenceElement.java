package preRequisites.BinarySearch;

public class SingleOccurenceElement {
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            int n = nums.length;

            // Base cases
            if (n == 1) return nums[0];
            if (nums[0] != nums[1]) return nums[0];
            if (nums[n - 1] != nums[n - 2]) return nums[n - 1];

            int l = 1;
            int r = n - 2;

            while (l <= r) {
                int mid = l + (r - l) / 2;

                // Base case: if mid is the single element
                if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                    return nums[mid];
                }

                // We are in the left half following order E-O E-O E-O E-O........
                if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) || (mid % 2 != 0 && nums[mid] == nums[mid - 1])) {
                    l = mid + 1;
                } else {
                    // This E-O order changes to O-E order due to single element occurrence
                    // We are in the right half following order O-E O-E O-E........
                    r = mid - 1;
                }
            }
            return -1;
        }
    }

}
