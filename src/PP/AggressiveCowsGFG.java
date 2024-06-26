package PP;

import java.util.Arrays;

public class AggressiveCowsGFG {
    class Solution {
        public  boolean  place(int stalls[],int k,int d){
            int curr=stalls[0];
            int count=1;
            for(int i=1;i<stalls.length;i++){
                if(curr+d<=stalls[i]){
                    count++;
                    curr=stalls[i];
                }
            }
            if (count>=k)
                return true;
            else
                return false;
        }
        public  int solve(int n, int k, int[] stalls) {
            Arrays.sort(stalls);
            int low=1;
            int high=stalls[n-1]-stalls[0];
            while(low<=high){
                int mid=(low+high)/2;
                if(place(stalls,k,mid))
                    low=mid+1;//it means the cows are placable check in right for greater distance
                else
                    high=mid-1;
            }
            return high;
        }
    }
}
