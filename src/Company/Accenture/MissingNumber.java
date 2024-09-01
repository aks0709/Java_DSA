package Company.Accenture;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int sum=(n*(n+1))/2;
        for(int num : nums)
            sum-=num;

        return sum;

    }
}
