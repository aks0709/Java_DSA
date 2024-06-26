public class SLLDeleteFirst
{
    private Listnode head;
    public static class Listnode {
        private int data;
        private Listnode next;

        public Listnode(int data) {
            this.data = data;
        }
    }
        public void display(){
            Listnode current=head;
            while(current!=null)
            {
                System.out.println(current.data+"-->");
                current=current.next;
            }
            System.out.println("null");
        }

        public void insert(int position,int value)
        {
            Listnode node=new Listnode(value);
            if(position==1)
            {
             node.next=head;
             head=node;
            }
            else
            {
                Listnode previous=head;
                int count=1;
                while(count<position-1)
                {
                    previous=previous.next;
                    count++;
                }
                Listnode current=previous.next;
                previous.next=node;
                node.next=current;
            }
        }

        public Listnode DeleteFirst()    //function is of return type Listnode -
        {
        if(head==null) //if there is no node
            return null;
        else {
            Listnode temp=head;   //temp node will start pointing node that head is pointing
            head=head.next;  //as first node is deleted so we need to assign head to its next
            temp.next=null;  //breaking link
            return temp;
        }
        }
    public static void main(String[] args) {
        SLLDeleteFirst sll=new SLLDeleteFirst();
        sll.insert(1,5);
        sll.insert(2,8);
        sll.insert(3,99);
        sll.insert(4,3);
        sll.insert(5,9);
        System.out.println("\n");
        //function calling
        System.out.println(sll.DeleteFirst().data+"\n"); //print data that to be deleted i.e 5 ,as 5 is first node
        System.out.println(sll.DeleteFirst().data+"\n");//print data that to be deleted i.e 8 ,as 8 is first node
        sll.display(); //display sll
    }
}
