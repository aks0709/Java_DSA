package preRequisites.bitManipulation;

public class ithBitSetOrNot {
    public static void main(String[] args) {

    }
    static boolean checkKthBit(int n, int k) {
        // Your code here

        //using left shift
        // if((n&(1<<k))==0) return false;
        // else return true;
        /*
        let say n=1101 and k=2 (second bit from last)
        1<<k =>  100
        1101 & 100  ==>1 true
        */




        //using right shift
        if(((n>>k)&1)==0) return false;
        else return true;

        /*
        let say n=1101 and k=2 (second bit from last)
        n>>k =>  0011
        0011 & 1  ==>1 true
        */
    }
}
