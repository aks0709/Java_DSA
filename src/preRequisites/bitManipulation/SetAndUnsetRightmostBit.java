package preRequisites.bitManipulation;

public class SetAndUnsetRightmostBit {

    //unset the rightmost set bit
    //eg n=16  10000   n-1 =15  01111  we will do "and" operation

    //eg  n=40 (101000)  n-1 =39  100111  //rightmost set bit 0 ho jayegi and uske  baad sab kuch 1 ho jayega
    static int unsetBit(int n){
        return n & (n-1);
    }

    //set the right most unset bit
    //n=6 110   n+1=7 111  110 | 111
    //n=15 01111 n+1=16   10000  01111||11111
    static int setBit(int n) {
        // code here
        return n | (n + 1);

    }
}
