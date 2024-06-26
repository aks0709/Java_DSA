package PP.RecursionDay3;

public class APowB {
    public static int Pow(int a,int b){
        if(b==0)
            return 1;

        return a*Pow(a,b-1);
    }

    public static int Pow2(int a,int b){
        if(b==0)
            return 1;

        if(b%2==0)
            return Pow2(a,b/2)*Pow2(a,b/2);  //for even b : a^b/2 * a^b/2
        else
            return Pow2(a,b/2)*Pow2(a,b/2)*a;  //for odd b : a* a^b/2 * a^b/2
    }
    public static void main(String[] args) {
        System.out.println(Pow(2,5));  //O(N) T.C
        System.out.println(Pow2(3,4));  //O(logN) T.C
    }
}

