package preRequisites.bitManipulation;

public class GetSetClear {

    class Solution {
        static void bitManipulation(int num, int i) {
            // code here
            i=i-1;
            int  ans1,ans2,ans3;
            ans1=(num>>i)&1;  //get

            ans2=num|(1<<i);  //set  let n=9 and i=2       1001 |  0100  ==>1101

            ans3=num&(~(1<<i));  //clear   i=2    1101 & ~(0100)  ==>1101 & 1011  ==> 1001

            System.out.println(ans1+" "+ans2+" "+ans3);
        }
    }
}
