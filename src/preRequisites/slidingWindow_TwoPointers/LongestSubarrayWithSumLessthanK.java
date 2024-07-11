package preRequisites.slidingWindow_TwoPointers;

public class LongestSubarrayWithSumLessthanK {
    public static void main(String[] args) {
        int arr[]={2,5,1,7,10};
        int k=14;
        System.out.println(getMaxLength(arr,k));
        System.out.println(getMaxlength2(arr,k));
    }

    //brute
    public static int getMaxLength(int arr[],int k){
        int maxLength=0;
        int sum=0;
        for (int i=0;i<arr.length;i++){
             sum=0;
            for (int j=i;j<arr.length;j++){
                sum=sum+arr[j];
                if(sum<=k){
                    maxLength=Math.max(maxLength,j-i+1);
                } else if (sum>k) {
                    break;
                }
            }
        }
        return maxLength;
    }

    //better approach
    public static int getMaxlength2(int arr[],int k){
        int left=0;
        int right=0;
        int sum=0;
        int maxLength=0;
        int maxSum=0;
        while(right< arr.length){
            sum=sum+arr[right];
            while (sum>k) {
                sum=sum-arr[left];
                left=left+1;
            }

            if(sum<=k){
                maxLength=Math.max(maxLength,right-left+1);
                maxSum=Math.max(maxSum,sum);
            }
            right=right+1;

        }
        return maxLength;
    }
}
