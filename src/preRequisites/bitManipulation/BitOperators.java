package preRequisites.bitManipulation;

public class BitOperators {
    public static void main(String[] args) {
        //And operator
        System.out.println(13&7);
        //OR operator
        System.out.println(13|7);
        //XOR operator
        //same-->0 else 1
        //odd no of 1 -->1
        //even no of 1 -->0

        System.out.println(13^7);

        //right shift
        //1 bit from right is discarded rest of bits shift by one
        //x>>k =x/(2^k)
        System.out.println(13>>1);
        //left shift
        //1 bit from left is discarded
        System.out.println(13<<2);
    }
}
