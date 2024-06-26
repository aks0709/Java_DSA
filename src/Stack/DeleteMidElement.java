package Stack;
// https://practice.geeksforgeeks.org/problems/delete-middle-element-of-a-stack/1
import java.util.Stack;

public class DeleteMidElement
{
    public static void main(String[] args)
    {
        Stack<Integer> s=new Stack<>();
        s.push(12);
        s.push(13);
        s.push(14);
        s.push(15);
        s.push(16);
        s.push(18);
        s.push(20);
        //deleteMid(s,0);
        deleteMid(s, s.size(),0);
        while (!s.isEmpty())
        {
            System.out.print(s.peek()+" ");
            s.pop();
        }

    }
    static void deleteMid(Stack<Integer> s, int sizeOfStack)
    {
        if(sizeOfStack==(s.size())/2)// code here
        {
            s.pop();
            return;
        }

        int top=s.peek();
        s.pop();
        deleteMid(s,sizeOfStack+1);
        s.push(top);
    }
    static void deleteMid(Stack<Integer> inputStack, int N,int count)
    {
        if(count==N/2)// code here
        {
            inputStack.pop();
            return;
        }

        int top=inputStack.peek();
        inputStack.pop();
        deleteMid(inputStack,N,count+1);
        inputStack.push(top);

    }


}
