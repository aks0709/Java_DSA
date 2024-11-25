package Stack.Revision;

import java.util.Stack;

public class MonotonicStack_nge {
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int n = nums2.length;
            int nge[] = new int[n];
            Stack< Integer > st = new Stack < > ();
            for (int i = n - 1; i >= 0; i--) {
                while (!st.isEmpty() && st.peek() <= nums2[i]) {
                    st.pop();
                }
                if (!st.isEmpty())
                    nge[i] = st.peek();
                else
                    nge[i] = -1;
                st.push(nums2[i]);
            }
            int res[]=new int[nums1.length];
            for(int i=0;i<nums1.length;i++){
                for(int j=0;j<nums2.length;j++){
                    if(nums2[j]==nums1[i]){
                        res[i]=nge[j];
                        break;
                    }
                }
            }
            return res;
        }
    }
}
