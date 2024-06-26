package Stack;

import java.util.Stack;

public class StackSort
{
    public static void main(String[] args)
    {
        Stack<Integer> stack=new Stack<>();
        stack.push(10);
        stack.push(-4);
        stack.push(-1);
        stack.push(20);
        stack.push(5);
        stack.push(-10);
        sort(stack);
        while(!stack.isEmpty())
        {
            System.out.print(stack.peek()+" ");
            stack.pop();
        }

    }
    static void sort(Stack<Integer> stack)
    {
        if (stack.isEmpty())
        {
            return;
        }
        int top=stack.pop();
        sort(stack);
        SortedInsert(stack,top);
    }
    static void SortedInsert(Stack<Integer> stack,int element)
    {
        if (stack.isEmpty()||(!stack.isEmpty()&&stack.peek()<=element))
        {
            stack.push(element);
            return;
        }
        int top=stack.pop();
        SortedInsert(stack,element);
        stack.push(top);
    }
}
