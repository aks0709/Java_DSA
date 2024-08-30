package preRequisites.bitManipulation;

public class IsPowerOfTWO {
    class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n <= 0) {
                return false;
            }
            return (n & (n - 1)) == 0;
            //eg n=16  10000
            //n-1=15  01111  we observe rightmost last set bit is converted to zero after that all are converted to 1
        }
    }

}
