import java.util.NoSuchElementException;

public class CircularLinkedList
{
    private Listnode last;
    private int length;
    public static class Listnode{
        private int data;
        private Listnode next;
        public Listnode(int data){
            this.data=data;
        }
    }
    public CircularLinkedList(){
        last=null;
        length=0;
    }
    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length==0;
    }

    public void Displaycsll(){
        if (last==null)
            return;
        Listnode first=last.next;
        while (first!=last)
        {
            System.out.println(first.data+" ");
            first=first.next;
        }
        System.out.println(first.data);
    }
    public void createcsll(){
        Listnode first=new Listnode(15);
        Listnode second=new Listnode(13);
        Listnode third=new Listnode(15);
        Listnode fourth=new Listnode(17);

        first.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=first;

        last=fourth;
    }
    public void insertfirst(int value){
        Listnode temp=new Listnode(value);
        if (last==null)
            last=temp;
        else {
            temp.next=last.next;
        }
        last.next=temp;
        length++;

    }

    public  void insertlast(int value){
        Listnode temp=new Listnode(value);
        if (last==null) {
            last = temp;
            last.next = last;   //last.next means first node of cll so this step is necessary to create cll
        }
        else {
            last.next=temp;
            temp.next=last.next;
            last=temp;// in order keep track of last pointer
        }
        length++;
    }

    public int removefirst(){
        if (isEmpty()) {
            throw new  NoSuchElementException();
        }
        Listnode temp=last.next;
        int result=temp.data;
        if (last.next==last)   //when only one node
        {
            last=null;
        }
        else
        {
            last.next=temp.next;  //to break link with first node
        }
        //temp.next=null;  //to seperate out first node
        length--;
        return result;
    }

    public static void main(String[] args) {
        CircularLinkedList csll=new CircularLinkedList();
        //csll.createcsll();
        //csll.Displaycsll();
        //System.out.println("\n");
        csll.insertfirst(98);
        csll.insertfirst(8);
        csll.insertfirst(97);
        //csll.Displaycsll();
        csll.insertfirst(7);
        //csll.Displaycsll();
        System.out.println(csll.removefirst()+"\n");
        csll.Displaycsll();
    }
}
