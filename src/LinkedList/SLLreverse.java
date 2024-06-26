public class SLLreverse
{
    private Listnode head;
    public static class Listnode{
        private int data;
        private Listnode next;
        public Listnode(int data)
        {
         this.data=data;
        }
    }

    public void display(Listnode head){
        Listnode current=head;
        while(current!=null){
            System.out.println(current.data+"-->");
            current=current.next;
        }
        System.out.println("null");
        return;
    }
    public Listnode reverse(Listnode head){
        Listnode current=head;
        Listnode next=null;
        Listnode previous=null;
        while(current!=null){
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        return previous;
    }
    public static void main(String[] args) {
        SLLreverse sll=new SLLreverse();
        sll.head=new Listnode(10);
        Listnode second=new Listnode(2);
        Listnode third=new Listnode(6);
        Listnode fourth=new Listnode(5);
        Listnode fifth=new Listnode(9);

        Listnode temp1=sll.head;
        Listnode temp2=sll.head;
        sll.head.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;

        sll.display(temp1);
        System.out.println("after reversing");
        Listnode reversesllhead=sll.reverse(temp2);
        System.out.println("\n");
        sll.display(reversesllhead);
    }
}
