package PP.SortingDay5;

import java.util.*;

class MyComparator2 implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        int b1=(int)o1;
        int b2=(int)o2;
        if(b1%2==0&&b2%2==0)
        {
            if(b1<b2)  //sort in ascending order if both are even
                return -1;
            else
                return 1;
        }
        else if(b1%2!=0&&b2%2!=0)
        {//sort in descending order if both are odd
            if(b1<b2)
                return 1;
            else
                return -1;
        }else if(b1%2==0)  //if only b1 is even sort in left half
            return -1;
        else               // else sort it in second half
            return 1;

    }
}
public class CustomSortingEven_Odd {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        /*list.add(6);
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(9);
        list.add(11);*/
        List<Integer> l1=Arrays.asList(6,1,3,4,2,9,11);  //it is method of List
        Collections.sort(l1,new MyComparator2());
        System.out.println(l1);
        List<Integer> numbers = Arrays.asList(4, 2, 5, 1, 3,9,7,17,13,10);
        //Collections.sort(numbers,new MyComparator2());
        numbers.sort(new MyComparator2());
        System.out.println(numbers);
    }
}
