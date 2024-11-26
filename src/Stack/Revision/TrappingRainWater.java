package Stack.Revision;

public class TrappingRainWater {
    class Solution {
        public int trap(int[] height) {
            //the idea behind this problem we have to sum the water stored on terrace of each building ,we can do so by finding corresponding LeftMax Heigth and RightMax Height and then get the minimum of it
            //total+=min(lMax,rMax)-height of current Building
            int n=height.length;
            int leftMax[]=new int[n];//prefixMax
            int rightMax[]=new int[n];  //suffixMax
            leftMax[0]=height[0];
            for(int i=1;i<n;i++){
                leftMax[i]=Math.max(leftMax[i-1],height[i]);
            }

            rightMax[n-1]=height[n-1];
            for(int i=n-2;i>=0;i--){
                rightMax[i]=Math.max(rightMax[i+1],height[i]);
            }

            int total=0;
            for(int i=0;i<n;i++){
                total+=Math.min(leftMax[i],rightMax[i])-height[i];
            }
            return total;
        }
    }
}
