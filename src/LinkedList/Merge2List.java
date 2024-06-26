public class Merge2List
{
    private Listnode head;
    public static class Listnode{
        private int data;
        private Listnode next;
        public Listnode (int data){
            this.data=data;
        }
    }
    public void InsertLast(int value){
        Listnode newNode=new Listnode(value);
        if(head==null)
        {
            head=newNode;
            return;
        }
        Listnode current=head;
        while(current.next!=null)
        {
            current=current.next;
        }
        current.next=newNode;

    }
    public void display()
    {

        Listnode current=head;
        while(current!=null)
        {
            System.out.println(current.data+"-->");
            current=current.next;
        }
        System.out.println("null");
    }

    public static Listnode merge(Listnode a,Listnode b){
        Listnode dummy=new Listnode(0);  //to avoid null pointer error
        Listnode tail=dummy;
        while(a!=null&&b!=null){
            if(a.data<=b.data){
                tail.next=a;
                a=a.next;
            }
            else {
                tail.next=b;
                b=b.next;
            }
            tail=tail.next;   //as tail is used to link linkedlist
        }
        if(a==null)//list a finish first
        {
            tail.next=b;  //attach list b to tail
        }
        else {
            tail.next=a;
        }
        return dummy.next;   // first node of dummy not needed to be there
    }

    public static void main(String[] args) {
        Merge2List sll1=new Merge2List();
       sll1.InsertLast(1);
        sll1.InsertLast(4);
        sll1.InsertLast(8);
        sll1.InsertLast(9);

        Merge2List sll2=new Merge2List();  //second linkd list
       sll2.InsertLast(3);
       sll2.InsertLast(6);
       sll2.InsertLast(8);
       sll2.InsertLast(12);

       sll1.display();
       sll2.display();
       Merge2List resultantlist=new Merge2List();
       resultantlist.head=merge(sll1.head,sll2.head);
       resultantlist.display();

    }
}
