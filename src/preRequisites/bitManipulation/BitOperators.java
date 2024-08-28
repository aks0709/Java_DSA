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
        //x<<k=x*(2^k)
        //exception :- when all are one 0111111111.......1111
        //in this case 0 is sign bit when it is dicarded it causes overflow


        //x=13;
        //000.......0001101
        //the first bit is sign bit 0 for +ve ,1 for -ve
        //for representing x=-13
        //find it 2's compliment



        //NOT OPERATOR
        /*
        1)flip
        2)check -ve(check first bit)
        if -ve then 2's compliment
        else remain same
        */
        System.out.println(~5);
        //000000.........0101
        //flip
        /*
        111111..........1010
        first bit is 1 hence -ve
        do find 2's compliment
        1' compliment
        1 0000000.....0101
                        +1
        1 000000......0110

        1--> -ve and number is 6
        */
        System.out.println(~(-6));


    }
}
