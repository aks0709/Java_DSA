public class SinglyLinkedList0
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
        if (head==null)
            return;
        else {
            Listnode current = head;
            while(current!=null)
            {
                System.out.println(current.data+"-->");
                current=current.next;
            }
            System.out.println("null");
        }
    }


}
