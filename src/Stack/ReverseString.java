package Stack;

import java.util.Stack;

public class ReverseString
{
    public static String revString(String str){
        Stack<Character> s=new Stack<>();
        char arr[]=str.toCharArray();
        for (char c : arr)
        {
            s.push(c);
        }
        for (int i=0;i<str.length();i++)
        {
            arr[i]=s.pop();
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        String str="AYUSH";
        System.out.println(revString(str));
    }
}
