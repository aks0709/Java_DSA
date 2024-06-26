package PP.MonotonicSearchSpace;

public class SQRT {
    public static int sqrt(int N){
        int low=0;
        int high=N;
        while(low<=high){
            int mid=(low+high)/2;

            if(mid*mid>N)
                high=mid-1;
            else if(mid*mid<=N)
            {
                if((mid+1)*(mid+1)>N)
                    return mid;
                else
                    low=mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(sqrt(67));
        System.out.println(sqrt(82));
        System.out.println(sqrt(80));
    }
}
