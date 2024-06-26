package Hashing;

import java.util.HashSet;
import java.util.Iterator;

public class HashSets
{
    public static void main(String[] args) {

        HashSet<Integer> set=new HashSet<>();
        set.add(1);
        set.add(4);
        set.add(2);
        set.add(5);
        set.add(2);
        System.out.println(set);

        if(set.contains(2))
            System.out.println("set contain 2");

        set.remove(2);
        System.out.println(set);

        System.out.println("size is "+set.size());
        Iterator it= set.iterator();

        System.out.println(it.next());
        System.out.println(it.next());

        set.add(10);
        set.add(3);
        Iterator it2=set.iterator();
        while (it2.hasNext())
        {
            System.out.print(it2.next()+" ");
        }

    }

}
