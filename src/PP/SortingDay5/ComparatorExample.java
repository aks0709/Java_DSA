package PP.SortingDay5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
class MyComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        int b1=(int)o1;
        int b2=(int)o2;
        if(b1<b2)
            return -1;
        else
            return 1;

    }
}
public class ComparatorExample {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(8);
        list.add(1);

        // Sorting in ascending order using a Comparator
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int a = (int) o1;
                int b = (int) o2;
                if (a < b)
                    return 1;
                else
                    return -1;
            }
        });
        System.out.println(list);

        //descending order
        Collections.sort(list,new MyComparator());
        System.out.println(list);

    }
}
