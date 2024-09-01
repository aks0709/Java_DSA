package Company.Accenture;

import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfArrays {
    public static void main(String[] args) {
        int arr1[]={1,2,3,4,5};
        int arr2[]={1,2,5,7};

        HashSet<Integer> set=new HashSet<>();
        for(int num : arr1)
            set.add(num);

        HashSet<Integer> res=new HashSet<>();
        for(int num : arr2){
            if(set.contains(num))
                res.add(num);
        }
        System.out.println(Arrays.toString(res.toArray()));
    }
}
