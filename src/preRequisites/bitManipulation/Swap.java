package preRequisites.bitManipulation;

public class Swap {
    public static void main(String[] args) {
        int a=5,b=10;
        System.out.println("before:- "+a+" "+b);
        //xor of two same number is zero

        a=a^b;
        b=a^b;  //b=(a^b)^b => a
        a=a^b;  //a=(a^b)^b  => (a^b)^a ==>b
        System.out.println("after:- "+a+" "+b);
    }
}
