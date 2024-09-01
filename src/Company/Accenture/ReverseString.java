package Company.Accenture;

public class ReverseString {
    public static void main(String[] args) {
        String str1="AYUSH";
        StringBuilder sb=new StringBuilder(str1);
        System.out.println(sb.reverse());

        System.out.println(isPalindrome("AABBAA"));
    }

    static boolean isPalindrome(String str){
        StringBuilder sb=new StringBuilder(str);
        if(str.equals(sb.reverse().toString()))
            return true;

        return false;
    }
}
