package Company.Accenture;

import java.util.Arrays;

public class KadanesAlgo {
    public static void main(String[] args) {
        int arr[]={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(Arrays.toString(maxSubArray2(arr)));
        System.out.println(maxSubArray(arr));
    }
    public static int[] maxSubArray2(int[] nums) {
        int maxSum=Integer.MIN_VALUE;
        int sum=0;
        int start=0;
        int ansStart=-1;
        int ansEnd=-1;
        for(int i=0;i<nums.length;i++){
            if(sum==0)  start=i;
            sum+=nums[i];

            if(sum>maxSum) {
                maxSum=sum;
                ansStart=start;
                ansEnd=i;
            }

            if(sum<0) sum=0;
        }
        int ans[]=new int[maxSum];
        int k=0;
        for(int i=ansStart;i<=ansEnd;i++){
            ans[k++]=nums[i];
        }
        return ans;
    }
    public static int maxSubArray(int[] nums) {
        int maxSum=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];

            if(sum>maxSum) maxSum=sum;

            if(sum<0) sum=0;
        }
        return maxSum;
    }
}
