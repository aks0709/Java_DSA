package Stack;

import java.util.Stack;

public class PushAtBottom
{
    public static void main(String[] args)
    {
        Stack<Integer> s=new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        pushAtBottom(40,s);
        while (!s.isEmpty())
        {
            System.out.println(s.peek());
            s.pop();
        }
    }

    public static void pushAtBottom(int data, Stack<Integer> s)
    {
        if (s.isEmpty()) {

            s.push(data);
            return;
        }
        int top=s.pop();
        pushAtBottom(data,s);
        s.push(top);
    }
}
