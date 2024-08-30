package preRequisites.bitManipulation;

public class Toogle_ithBit {
    //0-->1
    //1-->0
    public static void main(String[] args) {
        int n=13;  //1101
        int i=1;
        System.out.println(n^(1<<i));  //1101 ^ 0010
    }
}
