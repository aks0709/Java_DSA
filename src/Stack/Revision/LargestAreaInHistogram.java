package Stack.Revision;

import java.util.Stack;

public class LargestAreaInHistogram {
    class Solution {
        public int largestRectangleArea(int[] heights) {
            // we will utilise the concept of previous smaller element and nextsmaller element
            int n=heights.length;
            int pse[]=new int[n];
            int nse[]=new int[n];

            Stack<Integer> st=new Stack<>();
            for(int i=n-1;i>=0;i--){
                while(!st.isEmpty()&& heights[st.peek()]>=heights[i])
                    st.pop();

                if(!st.isEmpty())
                    nse[i]=st.peek();
                else
                    nse[i]=n;

                st.push(i);
            }
            Stack<Integer> st2=new Stack<>();
            for(int i=0;i<n;i++){
                while(!st2.isEmpty()&& heights[st2.peek()]>=heights[i])   //equal element edge case
                    st2.pop();

                if(!st2.isEmpty())
                    pse[i]=st2.peek();
                else
                    pse[i]=-1;

                st2.push(i);
            }
            int maxArea=0;
            for(int i=0;i<n;i++){
                int b=nse[i]-pse[i]-1;
                maxArea=Math.max(maxArea,b*heights[i]);
            }
            return maxArea;
        }
    }
}
