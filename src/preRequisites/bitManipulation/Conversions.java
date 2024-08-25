package preRequisites.bitManipulation;

public class Conversions {
    //TC O(Log N)
    public static String IntToBinary(int num){
        StringBuilder str=new StringBuilder();
        while(num>0){
            if(num%2==0) str.append('0');
            else str.append('1');
            num=num/2;
        }
        return str.reverse().toString();
    }
    //TC O(N)
    public static int BinaryToInt(String str){
        int pow=1;
        int res=0;
        for(int i=str.length()-1;i>=0;i--){
            if(str.charAt(i)=='1')
                res=res+pow;

            pow=pow*2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(IntToBinary(7));
        System.out.println(BinaryToInt("111"));
        System.out.println(IntToBinary(13));
    }
}
