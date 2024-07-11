package preRequisites.slidingWindow_TwoPointers;

public class MaxPointFromCards {
    /*
    There are several cards arranged in a row, and each card has an associated number of points.
    The points are given in the integer array cardPoints.
In one step, you can take one card from the beginning or from the end of the row.
 You have to take exactly k cards.
Your score is the sum of the points of the cards you have taken.
Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
    */

    class Solution {
        public int maxScore(int[] cardPoints, int k) {
            int ls=0,rs=0,ms=0;
            for(int i=0;i<k;i++)
                ls=ls+cardPoints[i];

            ms=ls;
            int rightIndex=cardPoints.length-1;
            for(int i=k-1;i>=0;i--){
                ls=ls-cardPoints[i];
                rs=rs+cardPoints[rightIndex];
                rightIndex=rightIndex-1;

                ms=Math.max(ms,ls+rs);
            }

            return ms;
        }
    }

    public static void main(String[] args) {
        System.out.println("HELLO");
    }
}
