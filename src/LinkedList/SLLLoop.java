package LinkedList;

public class SLLLoop
{
    private Listnode head;
    public static class Listnode{
        private int data;
        private Listnode next;
        public Listnode(int data){
            this.data=data;
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

    public boolean isloop(){
        if(head==null)
            return false;
        else
        {
         Listnode slowptr=head;
         Listnode fastptr=head;
         while(fastptr!=null&&fastptr.next!=null){
             fastptr=fastptr.next.next;
             slowptr=slowptr.next;
             if(slowptr==fastptr)
                 return true;
         }
         return false;
        }
    }

    public Listnode StartingNodeInALoop(){
        if(head==null)
            return null;
        else
        {
            Listnode slowptr=head;
            Listnode fastptr=head;
            while(fastptr!=null&&fastptr.next!=null){
                fastptr=fastptr.next.next;
                slowptr=slowptr.next;
                if(slowptr==fastptr)
                    return getStartingNode(slowptr);
            }
            return null;
        }
    }

    public Listnode getStartingNode(Listnode slowptr){
        Listnode temp=head;
        while(temp!=slowptr)
        {
            slowptr=slowptr.next;
            temp=temp.next;
        }
        return temp;
    }

    public void  RemoveALoop(){


            Listnode slowptr=head;
            Listnode fastptr=head;
            while(fastptr!=null&&fastptr.next!=null)
            {
                fastptr=fastptr.next.next;
                slowptr=slowptr.next;
                if(slowptr==fastptr)
                {
                    breaklink(slowptr);
                    return;
                }
            }
        }
    public void breaklink(Listnode slowptr){
        Listnode temp=head;
        while(temp.next!=slowptr.next){
            slowptr=slowptr.next;
            temp=temp.next;
        }
        slowptr.next=null;
    }
    public void CreateALoop(){
        Listnode first=new Listnode(10);
        Listnode second=new Listnode(20);
        Listnode third=new Listnode(30);
        Listnode fourth=new Listnode(40);
        Listnode fifth=new Listnode(50);
        Listnode sixth=new Listnode(60);

        head=first;
        first.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
        fifth.next=sixth;
        sixth.next=third;        ///creating a loop
    }

    public static void main(String[] args)
    {
        SLLLoop sll=new SLLLoop();
        sll.CreateALoop();
        System.out.println(sll.isloop());
        System.out.println(sll.StartingNodeInALoop().data);
        sll.RemoveALoop();
        System.out.println(sll.isloop());
    }
}
