package Company.Accenture;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int i = 0;  // Slow pointer

        for (int j = 1; j < nums.length; j++) {  // Fast pointer
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;  // The length of the array with unique elements
    }
}
